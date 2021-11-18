
public abstract class Route extends Thread {

    enum Directions {
        NORTH, SOUTH, EAST, WEST, NULL
    }

    public Route north;
    public Route south;
    public Route east;
    public Route west;

    int row;
    int col;

    Labyrinth labyrinth;

    protected boolean visited = false;

    public Route(int row, int col, Labyrinth labyrinth) {
        this.col = col;
        this.row = row;
        this.labyrinth = labyrinth;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;

    }

    public void print(String s) {
        System.out.println(s + "\n");
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    // checking exit
    public boolean isEnding(int row, int col) {
        if (row == this.labyrinth.route.length - 1 || row == 0 || col == 0
                || col == this.labyrinth.route[0].length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isVisited() {
        return this.visited;
    }

    public boolean canGoSouth() {
        // print("in canGoSouth fn");
        if (this.south != null) {
            if (this.south.isVisited()) {
                // print("the south node is already visited");
                return false;
            } else {
                return true;

            }

        } else {
            // print("the south node is null");
            return false;
        }
    }

    public boolean canGoNorth() {
        // print("in canGoNorth fn");
        if (this.north != null) {
            if (this.north.isVisited()) {
                // print("the north node is already visited");
                return false;
            } else {
                return true;

            }

        } else {
            // print("the north node is null");
            return false;
        }
    }

    public boolean canGoEast() {
        // print("in canGoEast fn");
        if (this.east != null) {
            if (this.east.isVisited()) {
                // print("the east node is already visited");
                return false;
            } else {
                return true;

            }

        } else {
            // print("the east node is null");
            return false;
        }
    }

    public boolean canGoWest() {
        // print("in canGoWest fn");
        if (this.west != null) {
            if (this.west.isVisited()) {
                // print("the west node is already visited");
                return false;
            } else {

                return true;

            }

        } else {
            // print("the west node is null");
            return false;
        }
    }

    public int num_of_ways_possible() {
        int i = 0;
        if (this.canGoNorth()) {
            i = i + 1;
        }

        if (this.canGoSouth()) {
            i = i + 1;
        }

        if (this.canGoEast()) {
            i = i + 1;
        }

        if (this.canGoWest()) {
            i = i + 1;
        }

        return i;
    }

    // recursive method to let each route ask its neighbour fo the way
    public void go(int i, int j, String way, Directions dir) {
        print("in go fn");
        if (alreadyVisited(way)) {
            // print("going back");
            Thread.currentThread().interrupt();
            return;
        }
        way += " --> " + coordToSring();
        // print(way);

        if (isEnding(i, j)) {
            // way+=coordToSring();
            Thread.currentThread().interrupt();
            labyrinth.all_possible_routes.leggTil(way);
            return;
        }

        if (this.num_of_ways_possible() > 1) {
            print("more than one function is available");

            int count = num_of_ways_possible();

            if (dir != Directions.NORTH) { // if it didin't come from north
                if (this.canGoNorth()) {
                    if (count > 1) {
                        count = count - 1;
                        this.visited=true;
                        print("created a sub thread to go north");
                        Thread s = new MySubThread(this.north, way, Directions.SOUTH);
                        s.start();
                        try {
                            s.join();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        this.visited=false;
                    }
                    else{
                        print("going north");

                        this.north.go(this.north.getRow(), this.north.getCol(), way, Directions.SOUTH);    
                        }
                }
            }

            if (dir != Directions.SOUTH) { // if it didn't come from south
                if (this.canGoSouth()) {
                    if (count > 1) {
                        count = count - 1;
                        this.visited=true;
                        print("created a sub thread to go south");
                        Thread s = new MySubThread(this.south, way, Directions.NORTH);
                        s.start();
                        try {
                            s.join();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        this.visited=false;
                    }
                    else{
                        print("going south");
                        this.south.go(this.south.getRow(), this.south.getCol(), way, Directions.NORTH);    
                    }
                }
            }

            if (dir != Directions.EAST) {// if it didn't come from east
            
                if (this.canGoEast()) {
                    if (count > 1) {
                        count = count - 1;
                        this.visited=true;
                        print("created a sub thread to go east");
                        Thread s = new MySubThread(this.east, way, Directions.WEST);
                        s.start();
                        try {
                            s.join();
                        } catch (InterruptedException e) {
                             // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        this.visited=false;
                    }
                    else{
                        print("going east");
                        this.east.go(this.east.getRow(), this.east.getCol(), way, Directions.WEST);    
                        }
                }

            }

            if (dir != Directions.WEST) {// if it didn't come from west
                
                if (this.canGoWest()) {
                    if (count > 1) {
                        count = count - 1;
                        this.visited=true;
                        print("created a sub thread to go west");
                        Thread s = new MySubThread(this.west, way, Directions.EAST);
                        s.start();
                        try {
                            s.join();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        this.visited=false;
                    }
                    else{
                        print("going west");
                        this.west.go(this.west.getRow(), this.west.getCol(), way, Directions.EAST);    
                    }
                }

            }

        }
        else{
            if (dir != Directions.NORTH) { // if it didin't come from north
                if (this.canGoNorth()) {
                    print("going north");
                    this.north.go(this.north.getRow(), this.north.getCol(), way, Directions.SOUTH);
                }
            }

            if (dir != Directions.SOUTH) { // if it didn't come from south
                if (this.canGoSouth()) {
                    print("going south");
                    this.south.go(this.south.getRow(), this.south.getCol(), way, Directions.NORTH);
                }
            }

            if (dir != Directions.EAST) {// if it didn't come from east
                if (this.canGoEast()) {
                    print("going east");
                    this.east.go(this.east.getRow(), this.east.getCol(), way, Directions.WEST);
                }
            }

            if (dir != Directions.WEST) {// if it didn't come from west
                if (this.canGoWest()) {
                    print("going west ");
                    this.west.go(this.west.getRow(), this.west.getCol(), way, Directions.EAST);
                }
            }

            }

       
    }

    // find exit by repeatedly calling the go function
    public void findExit() {
        print("in findExit function");
        if (isEnding(this.row, this.col)) {
            // when end is found, store it in the list
            // print("found end");
            
            Thread.currentThread().interrupt();
            labyrinth.all_possible_routes.leggTil(coordToSring());
            return;
        }

        if (num_of_ways_possible() > 1) {
            int count = num_of_ways_possible();
            print(Integer.toString(count) + " ways possible");
            if (canGoNorth()) {
                print("cheching north");
                if (count > 1) {
                    count = count - 1;
                    print("crated  a new thread to go north");
                    this.visited=true;
                    /* ANSWER TO THE ASSIGNMENT QUESTION
                       QUES: What happens if the old thread moves on the next route and then starts 
                       the new thread?

                       ANS: In the assignment, we are required to find the path to the opening in such a way 
                            that in case of more than one way emerging from a white route, the search through 
                            all the wasy should continue in parallel. However, if we move the old thread 
                            before starting a new thread, then the new thread will not be started before the 
                            old thread is finished. The reason behind this is that we are recursively calling the 
                            go function.So once the old thread is moved before starting a new thread, due to 
                            recursion, the old thread will keep calling the go function untill it finds the end and 
                            only after it stops, the compiler will run the next line where the new thread is started.
                            Hence, it will not enable parallel search.  
                             
                         */
                    Thread t = new MyThread(this.north, this.coordToSring());
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    this.visited=false;
                } else {
                    print("himself going north");
                    north.go(north.getRow(), north.getCol(), this.coordToSring(), Directions.SOUTH);
                }

            }

            if (canGoSouth()) {
                print("cheching south");
                if (count > 1) {
                    count = count - 1;
                    this.visited=true;
                    Thread t = new MyThread(this.south, this.coordToSring());
                    print("crated  a new thread to go south");
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    this.visited=false;
                } else {
                    print("himself going south");
                    south.go(south.getRow(), south.getCol(), this.coordToSring(), Directions.NORTH);
                }

            }

            if (canGoEast()) {
                print("cheching East");
                if (count > 1) {
                    count = count - 1;
                    this.visited=true;
                    Thread t = new MyThread(this.east, this.coordToSring());
                    print("crated  a new thread to go east");
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    this.visited=false;
                } else {
                    print("himself going east");
                    east.go(east.getRow(), east.getCol(), this.coordToSring(), Directions.WEST);
                }
            }

            if (canGoWest()) {
                print("cheching West");
                if (count > 1) {
                    count = count - 1;
                    this.visited=true;
                    Thread t = new MyThread(this.west, this.coordToSring());
                    print("crated  a new thread to go west");
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    this.visited=false;
                } else {
                    print("himself going west");
                    west.go(west.getRow(), west.getCol(), this.coordToSring(), Directions.EAST);
                }

            }
        }
        else{
            print("only one way possible");
            if (canGoNorth()) {
                  print("cheching north");
                north.go(north.getRow(), north.getCol(), this.coordToSring(), Directions.SOUTH);

            }

            if (canGoSouth()) {
                 print("cheching south");
                south.go(south.getRow(), south.getCol(), this.coordToSring(), Directions.NORTH);

            }

            if (canGoEast()) {
                 print("checking east");
                east.go(east.getRow(), east.getCol(), this.coordToSring(), Directions.WEST);

            }

            if (canGoWest()) {
                 print("checking west");
                west.go(west.getRow(), west.getCol(), this.coordToSring(), Directions.EAST);
            }
            
        }
      //  try {
       //     Thread.currentThread().join();
       // } catch (InterruptedException e) {
            // TODO Auto-generated catch block
        //    e.printStackTrace();
       // }
}
 
public boolean alreadyVisited(String way){
    return way.contains(coordToSring());
}
// convert the coordinates to String
public String coordToSring() {
    return "(" + row + ", " + col + ")";
}



  abstract char toCharacter();

}