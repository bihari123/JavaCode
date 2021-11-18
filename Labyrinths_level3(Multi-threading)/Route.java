public abstract class Route{
 
    private enum Directions {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    public Route north;
    public Route south; 
    public Route east;
    public Route west;
    
    int row; int col;

    Labyrinth labyrinth;

    protected boolean visited=false;

    public Route(int row, int col, Labyrinth labyrinth){
        this.col=col;
        this.row=row;
        this.labyrinth=labyrinth;
        this.north=null;
        this.south=null;
        this.east=null;
        this.west=null;
        
    }
    public void print(String s){
        System.out.println(s+"\n");
    }
    

    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }

    // checking exit
    public boolean isEnding(int row,int col){
        if(row==this.labyrinth.route.length-1 || row==0 || col==0 || col==this.labyrinth.route[0].length-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isOpening(Route r){
        boolean result=false;
        if((r instanceof WhiteRoute) && isEnding(r.getRow(), r.getCol())){
            result=true;
        }
        return result;
    }

    public boolean isVisited(){
        return this.visited;
    } 
    
    public int totalNeighbours(){
        int i=0;
        if(canGoNorth()){
             i++; //start counting the num of available paths
        }
        if(canGoSouth()){
            i++; 
       }
       if(canGoEast()){
        i++;
       }
        if(canGoWest()){
            i++; 
       }
       return i;
        
    }

    // return the list of extra paths in case the available paths are more than one
    public Lenkeliste<Route> extra_route(){
        Lenkeliste<Route> extra_neighbors=new Lenkeliste<>();
        int i=0;
        if( totalNeighbours()>1){
             if(canGoNorth()){
                 if(i==0){
                     i++;  // alwways leave the firdt path, it will be followed by original thread
                 }
                 else{
                     extra_neighbors.leggTil(this.north); // put extra path in list
                                                          // will be followed by new threads
                 }
             }
             if(canGoSouth()){
                if(i==0){
                    i++;
                }
                else{
                    extra_neighbors.leggTil(this.south);
                }
            }
            if(canGoEast()){
                if(i==0){
                    i++;
                }
                else{
                    extra_neighbors.leggTil(this.east);
                }
            }
            if(canGoWest()){
                if(i==0){
                    i++;
                }
                else{
                    extra_neighbors.leggTil(this.west);
                }
            }
        }
        return extra_neighbors;
    }
    
    public Route only_path_left(){
        Lenkeliste<Route> list= extra_route();
        if(canGoNorth()){
            // the extra_route contains all the paths except one
            // that path, which is not included in extra_route
            // will be followed by the old thread
            if(!list.isContain(this.north)){ 
                return this.north;
            }
        }
        else if(canGoSouth()){
            if(!list.isContain(this.south)){
                return this.south;
            }
        }
        else if(canGoEast()){
            if(!list.isContain(this.east)){
                return this.east;
            }
        }
        else if(canGoWest()){
            if(!list.isContain(this.west)){
                return this.west;
            }
        }
        
           return this;
        
    }
    
    public boolean canGoSouth(){
        //  print("in canGoSouth fn");
        if(this.south!=null ){
          return true ; 
        }
        else{ 
            //print("the south node is null");
            return false;
        }
    }

    public boolean canGoNorth(){
       // print("in canGoNorth fn");
        if(this.north!=null ){
            return true;
        }
        else{ 
           // print("the north node is null");
            return false;
        }
    }

    public boolean canGoEast(){
        //print("in canGoEast fn");
        if(this.east!=null ){
            return true;
        }
        else{ 
            //print("the east node is null");
            return false;
        }
    }


    public boolean canGoWest(){
        //print("in canGoWest fn");
        if(this.west!=null ){
            return true;
        }
        else{ 
           // print("the west node is null");
            return false;
        }
    }
 
    public void go(Lenkeliste<Route> myRoute){
        print("in go() "+coordToSring());
        
        Lenkeliste<Route> myList=new Lenkeliste<>();
        myList.copyElements(myRoute);
        myList.leggTil(this);
        if(isOpening(this)){
            print("found end");

            labyrinth.all_possible_routes.addPathToList(myList); 
        }
        else{
            Lenkeliste<Thread> threadList=new Lenkeliste<>();
            int num_of_neighbours= totalNeighbours();
            
            if(num_of_neighbours>1){
                Lenkeliste<Route> extra_route_list= extra_route();
                
                for(Route r : extra_route_list){
                    if(!alreadyVisited(myList, r)){
                    Runnable task =new MyThread(r,myList);
                    Thread myThread1 = new Thread(task);
                    print("created a thread for "+r.coordToSring());
                    threadList.leggTil(myThread1);
                    }  
                }

                //starting threads
                for(Thread t: threadList){
                    t.start();

                }
            }       
                    // next step for original thread
                    Route next= only_path_left();
                    
                    if(! alreadyVisited(myList, next)){
                //        hinself going ahead
                        next.go(myList);
              //          recursive call ended
                    }
           
            for(Thread t: threadList){
                try{
                    print(" waiting till all the threads end");
                   t.join();
                }catch(Exception e){
                    print("something went wrong in threads");
                }
            }
        }

    }

   
public boolean alreadyVisited(Lenkeliste<Route> route_list, Route route){
    for(Route r: route_list){
        if(r.getRow()==route.getRow() && r.getCol()==route.getCol()){
            return true;
        }
        
    }
    
    return false;
}

// convert the coordinates to String
public String coordToSring() {
    return "(" + row + ", " + col + ")";
}

  abstract char toCharacter();

}