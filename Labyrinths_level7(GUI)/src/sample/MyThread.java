package sample;

import javafx.application.Platform;

class MyThread implements Runnable{
	

	public MyThread(){
		
		}

	public void run(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Platform.exit();
	}

}
