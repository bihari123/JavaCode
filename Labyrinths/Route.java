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
    public boolean isVisited(){
        return this.visited;
    } 

   
    
    public boolean canGoSouth(){
        //print("in canGoSouth fn");
        if(this.south!=null ){
            if(this.south.isVisited()){
               // print("the south node is already visited");
                return false;
            }
            else{
                return true;
            
            }
            
        }
        else{ 
            //print("the south node is null");
            return false;
        }
    }

    public boolean canGoNorth(){
       // print("in canGoNorth fn");
        if(this.north!=null ){
            if(this.north.isVisited()){
              //  print("the north node is already visited");
                return false;
            }
            else{
                return true;
            
            }
            
        }
        else{ 
           // print("the north node is null");
            return false;
        }
    }

    public boolean canGoEast(){
        //print("in canGoEast fn");
        if(this.east!=null ){
            if(this.east.isVisited()){
             //   print("the east node is already visited");
                return false;
            }
            else{
                return true;
            
            }
            
        }
        else{ 
            //print("the east node is null");
            return false;
        }
    }


    public boolean canGoWest(){
        //print("in canGoWest fn");
        if(this.west!=null ){
            if(this.west.isVisited()){
             //   print("the west node is already visited");
                return false;
            }
            else{
                
                return true;
            
            }
            
        }
        else{ 
           // print("the west node is null");
            return false;
        }
    }


   
// recursive method to let each route ask its neighbour fo the way
  public void go(int i, int j, String way,Directions dir){
    if(alreadyVisited(way)){
       // print("going back");
        return;
    }
    way+=" --> "+coordToSring();
   // print(way);

    if(isEnding(i, j)){
        //way+=coordToSring();
        labyrinth.all_possible_routes.leggTil(way);
        
        return;
    }

    
    if(dir!=Directions.NORTH){ // if it  didin't come from north
        if(this.canGoNorth()){
         //   print("going north");
            this.north.go(this.north.getRow(),this.north.getCol(),way,Directions.SOUTH);
        }
    }

    if(dir!=Directions.SOUTH){ // if it didn't come from south
        if(this.canGoSouth()){
           // print("going south");
            this.south.go(this.south.getRow(),this.south.getCol(),way,Directions.NORTH);
        }
    }

    if(dir!=Directions.EAST){// if it didn't come from east
        if(this.canGoEast()){
            //print("going east");
            this.east.go(this.east.getRow(),this.east.getCol(),way,Directions.WEST);
        }
    }

    if(dir!=Directions.WEST){// if it didn't come from west
        if(this.canGoWest()){
            //print("going west ");
            this.west.go(this.west.getRow(),this.west.getCol(),way,Directions.EAST);
        }
    }
             
} 

// find exit by repeatedly calling the go function
  public void findExit(){
    if (isEnding(this.row, this.col)) {
            // when end is found, store it in the list
            //print("found end");
            labyrinth.all_possible_routes.leggTil(coordToSring());
        return;
    }

    if (canGoNorth()){
        //print("cheching north");
        north.go(north.getRow(),north.getCol(),this.coordToSring() ,Directions.SOUTH);
    
    }

    if (canGoSouth()){
        //print("cheching south");
        south.go(south.getRow(),south.getCol(),this.coordToSring(),Directions.NORTH);

    }
        
    if (canGoEast()){
        //print("checking east");
        east.go(east.getRow(),east.getCol(),this.coordToSring() ,Directions.WEST);

    }
        
    if (canGoWest()){
        //print("checking west");
        west.go(west.getRow(),west.getCol(),this.coordToSring() ,Directions.EAST);
    }
        
}
 
public boolean alreadyVisited(String way){
    return way.contains(coordToSring());
}
// convert the coordinates to String
private String coordToSring() {
    return "(" + row + ", " + col + ")";
}

  abstract char toCharacter();

}