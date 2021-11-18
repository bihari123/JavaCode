public class MySubThread extends Thread{
    String sub_way;
    Route sub_route;
    Route.Directions sub_dir;
    MySubThread(Route sub_route,String sub_way,Route.Directions sub_dir){
        this.sub_route=sub_route;
        this.sub_way=sub_way;
        this.sub_dir=sub_dir;
    }

    public void run(){
        System.out.println("in sub thread");
        this.sub_route.go(this.sub_route.getRow(),this.sub_route.getCol(),this.sub_way,sub_dir);
    }

}