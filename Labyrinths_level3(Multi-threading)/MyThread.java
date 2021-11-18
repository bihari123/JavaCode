
class MyThread implements Runnable{
	
	Lenkeliste<Route> path;
	
	Route r;
	
	public MyThread(Route r, Lenkeliste<Route> path){
		
		this.path = path;
		this.r=r;
	}

	public void run(){
		r.go(path);
	}

}
