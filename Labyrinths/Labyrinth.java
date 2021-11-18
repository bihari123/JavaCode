import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



class Labyrinth{
    protected Route[][] route;
    protected Lenkeliste<String> all_possible_routes; // for storing all the possible paths to exit
    protected int rows;
    protected int cols;
    private Labyrinth (int rows, int cols,Route[][] route){
        this.rows=rows;
        this.cols=cols;
        this.route=route;
        all_possible_routes = new Lenkeliste<String>();
    }
    
    // to print statements between the program for testing
    public static void print(String s){
        System.out.println(s+"\n");
    }

    //getter method for row
    public int getRows(){
        return this.rows;
    }
    
    // getter method for columns 

    public int getCols(){
        return this.cols;
    }
    
    // checks if the route is walkable
    public static boolean isWhite(String r) {
        if (r.equals(".")) {
            return true;
        } else {
            return false;
        }
    }

    // checks if we have reached the edge of the maze board
    public static boolean isEdge(int i, int j, Route[][] r) {
        if (i == 0 || j == 0 || i == r.length - 1 || j == r[0].length - 1) {
            return true;
        } else {
            return false;
        }
    }
/* A static factory method is a public static method on the object that returns a new instance 
  of the object. This pattern provides a layer between the caller and the creation(factory)
  
  Advantages:
    - Unlike constructors, they have names
    - Unlike Constructors, they are not required to create a new object everytime they are invoked
    - Unlike constructors, they can return an object of their return type
    -They reduce the verbosity of creating parametrized type
*/
    public static Labyrinth readFromFile(File file) throws FileNotFoundException {

        Scanner read = new Scanner(file);
       // print("scanning star, reading the first line");
        
        String line = read.nextLine();
        //print("read the first line, now splitting the text");

        String[] splitted_line = line.split(" ");
        //print("splitting complete");
        
        int rows = Integer.parseInt(splitted_line[0]);
        int cols = Integer.parseInt(splitted_line[1]);
        //print("got rows and cols");
        
        Route[][] new_route = new Route[rows][cols];
        //print("declared new_route");
        print("row: "+Integer.toString(rows)+"col "+Integer.toString(cols));
        Labyrinth labyrinth = new Labyrinth(rows, cols, new_route);

        for (int i = 0; i < rows; i++) {
            splitted_line = read.nextLine().split("");
            for (int j = 0; j < cols; j++) {
                if (isWhite(splitted_line[j])) {
                    if (isEdge(i, j,new_route)) {
                        labyrinth.route[i][j]= new Opening(i,j,labyrinth);
                        //print("opening is at "+Integer.toString(i)+" , "+Integer.toString(j));
                    }
                    else{
                        labyrinth.route[i][j]= new WhiteRoute(i,j,labyrinth);
                        //print("white route is at "+Integer.toString(i)+" , "+Integer.toString(j));
                    }
                }
                else{
                    labyrinth.route[i][j]= new BlackRoute(i,j,labyrinth);
                }
            }
        }
        read.close();
      
        // connecting the neighbouring routes
        for(int i=0;i<labyrinth.route.length;i++){
            for(int j=0;j<labyrinth.route[0].length;j++){
                if(labyrinth.route[i][j] instanceof WhiteRoute ||labyrinth.route[i][j] instanceof Opening ){
                    if(i==0){
                        if(j==0){
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                                labyrinth.route[i][j].east= labyrinth.route[i][j+1];
                            }
                        }
                        else if(j==labyrinth.route[0].length -1){
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                        }
                        else{
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                                labyrinth.route[i][j].east= labyrinth.route[i][j+1];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                        }
                    }

                    else if(i==labyrinth.route.length-1){
                        if(j==0){
                            if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                                labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                            }

                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                                labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                            }
                        }
                        else if(j==labyrinth.route[0].length -1){
                            if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                                labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                       }
                       else{
                        if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                            labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                        }
                        if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                            labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                        }
                        if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                            labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                        }
                       }
                    }
                    
                    else if(i>0 && j==0){
                        if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                            labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                        }
                        if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                            labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                        }
                        if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                            labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                        }
                    }
                    else if(i>0 && j==labyrinth.route[0].length-1){
                        if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                            labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                        }
                        if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                            labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                        }
                        if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                            labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                        }
                    }
                     else{
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                                labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                            if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                                labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                            }
                        }

                    }
                } 
            } 
        

        return labyrinth;
    }


    public static Labyrinth readFromFile(File file,boolean b) throws FileNotFoundException {

        Scanner read = new Scanner(file);
        print("scanning star, reading the first line");
        
        String line = read.nextLine();
        print("read the first line, now splitting the text");

        String[] splitted_line = line.split(" ");
        print("splitting complete");
        
        int rows = Integer.parseInt(splitted_line[0]);
        int cols = Integer.parseInt(splitted_line[1]);
        print("got rows and cols");
        
        Route[][] new_route = new Route[rows][cols];
        print("declared new_route");
        
        Labyrinth labyrinth = new Labyrinth(rows, cols, new_route);

        for (int i = 0; i < rows; i++) {
            splitted_line = read.nextLine().split("");
            for (int j = 0; j < cols; j++) {
                if (isWhite(splitted_line[j])) {
                    if (isEdge(i, j,new_route)) {
                        labyrinth.route[i][j]= new Opening(i,j,labyrinth);
                        print("made an opening at "+"("+Integer.toString(i)+","+Integer.toString(j)+")");
                        //print("opening is at "+Integer.toString(i)+" , "+Integer.toString(j));
                    }
                    else{
                        print("made an white route at "+"("+Integer.toString(i)+","+Integer.toString(j)+")");
                        labyrinth.route[i][j]= new WhiteRoute(i,j,labyrinth);
                        //print("white route is at "+Integer.toString(i)+" , "+Integer.toString(j));
                    }
                }
                else{
                    print("made an black route at "+"("+Integer.toString(i)+","+Integer.toString(j)+")");
                    labyrinth.route[i][j]= new BlackRoute(i,j,labyrinth);
                }
            }
        }
        read.close();
      
        // connecting the neighbouring routes
        for(int i=0;i<labyrinth.route.length;i++){
            for(int j=0;j<labyrinth.route[0].length;j++){
                if(labyrinth.route[i][j] instanceof WhiteRoute ||labyrinth.route[i][j] instanceof Opening ){
                    if(i==0){
                        if(j==0){
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                print(Integer.toString(i+1)+","+Integer.toString(j)+" is south to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                                print(Integer.toString(i)+","+Integer.toString(j+1)+" is east to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].east= labyrinth.route[i][j+1];
                            }
                        }
                        else if(j==labyrinth.route[0].length -1){
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                print(Integer.toString(i+1)+","+Integer.toString(j)+" is south to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                print(Integer.toString(i)+","+Integer.toString(j-1)+" is west to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                        }
                        else{
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                print(Integer.toString(i+1)+","+Integer.toString(j)+" is south to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){

                                print(Integer.toString(i)+","+Integer.toString(j+1)+" is east to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                               
                                labyrinth.route[i][j].east= labyrinth.route[i][j+1];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                print(Integer.toString(i)+","+Integer.toString(j-1)+" is west to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                               
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                        }
                    }

                    else if(i==labyrinth.route.length-1){
                        if(j==0){
                            if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                                print(Integer.toString(i-1)+","+Integer.toString(j)+" is north to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                               
                                labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                            }

                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                                print(Integer.toString(i)+","+Integer.toString(j+1)+" is east to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");

                                labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                            }
                        }
                        else if(j==labyrinth.route[0].length -1){
                            if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                                print(Integer.toString(i-1)+","+Integer.toString(j)+" is north to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                print(Integer.toString(i)+","+Integer.toString(j-1)+" is west to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                       }
                       else{
                        if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                            print(Integer.toString(i-1)+","+Integer.toString(j)+" is north to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                        }
                        if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                            print(Integer.toString(i)+","+Integer.toString(j+1)+" is east to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                        }
                        if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                            print(Integer.toString(i)+","+Integer.toString(j-1)+" is west to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                        }
                       }
                    }
                    
                    else if(i>0 && j==0){
                        if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                            print(Integer.toString(i)+","+Integer.toString(j+1)+" is east to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                        }
                        if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                            print(Integer.toString(i+1)+","+Integer.toString(j)+" is south to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                        }
                        if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                            print(Integer.toString(i-1)+","+Integer.toString(j)+" is north to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                        }
                    }
                    else if(i>0 && j==labyrinth.route[0].length-1){
                        if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                            print(Integer.toString(i)+","+Integer.toString(j-1)+" is west to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                        }
                        if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                            print(Integer.toString(i+1)+","+Integer.toString(j)+" is south to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                        }
                        if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                            print(Integer.toString(i-1)+","+Integer.toString(j)+" is north to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                            labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                        }
                    }
                     else{
                            if(labyrinth.route[i+1][j] instanceof WhiteRoute){
                                print(Integer.toString(i+1)+","+Integer.toString(j)+" is south to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].south=labyrinth.route[i+1][j];
                            }
                            if(labyrinth.route[i][j+1] instanceof WhiteRoute){
                                print(Integer.toString(i)+","+Integer.toString(j+1)+" is east to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].east=labyrinth.route[i][j+1];
                            }
                            if(labyrinth.route[i][j-1] instanceof WhiteRoute){
                                print(Integer.toString(i)+","+Integer.toString(j-1)+" is west to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].west=labyrinth.route[i][j-1];
                            }
                            if(labyrinth.route[i-1][j] instanceof WhiteRoute){
                                print(Integer.toString(i-1)+","+Integer.toString(j)+" is north to "+ "("+Integer.toString(i)+","+Integer.toString(j)+")");
                                labyrinth.route[i][j].north=labyrinth.route[i-1][j];
                            }
                        }

                    }
                } 
            } 
        

        return labyrinth;
    }

    public String toString(){
        String element="";
        for (int i=0; i<this.getRows();i++){
            for (int j=0;j<this.getCols();j++){
                element= element + this.route[i][j].toCharacter();
            }
            element=element+"\n";
        }
        return element;
    }

    public Liste<String> findExitFrom(int row, int col) {
        // Fjern alt fra listen
        try{
        while (all_possible_routes.stoerrelse()>0) {
            //all_possible_routes.removeNotReturn();
            all_possible_routes.fjern();
        }
           // print("calling find exit function");  
            route[row][col].findExit();
           // print("returning all_routes_possible");
     }
     catch(IndexOutOfBoundsException e){
         print("please enter a valid coordinate");
     } return all_possible_routes;
    }
}