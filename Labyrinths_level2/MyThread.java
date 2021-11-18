


public class MyThread extends Thread {
    String way;
    Thread t;
    int row, col;
    Route route;
    Route.Directions dir;

    boolean exit = false;

    MyThread(Route route, String way) {
        System.out.println("in the my thread constructor");
        this.route = route;
        this.way = way;

    }

    
      public void look_out(){
      
     //this.route.go(this.row,this.col,this.way,this.dir);
      System.out.println("in the look out function"); 
     // this.route.go(this.route.getRow(),this.route.getCol(),"",Route.Directions.NULL); 
      this.route.findExit();
    }
     
    public void print(String s) {
        System.out.println(s + "\n");
    }

    public void run() {
            print("entered thread");
            look_out();
          
    }

    //print("thread stopped running");

    public void stopRunning(){
        this.exit = true;
    }

}