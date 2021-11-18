import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
public class GameForTask6 {
    public static void main(String[] args) throws FileNotFoundException {
      boolean loopExit=false;
      int wantRobot=0;
      Terrain terrain=new Terrain();
      Terminal terminal=new Terminal();
      Robot robot=new Robot();
      int numberOfPlayersFinished=0;           
      Player[] players;
      Lenkeliste<Thread> threadList=new Lenkeliste<>();
      int robotPlayerSize=0;
      int playerSize=0;
      int humanPlayerSize=0;
  
      while(!loopExit){
          try {
              wantRobot=1;
              if(wantRobot==1){
                  robotPlayerSize=terminal.askForCommand("how many robot players do you want", null);
                  loopExit=true;
              }
              else if(wantRobot==0){
                  robotPlayerSize=0;
                  loopExit=true;
              }
              else{
                  terminal.giveStatus("please enter a valid value");
              }
                      
          } catch (Exception e) {
              //TODO: handle exception
              terminal.giveStatus("please enter a valid value");
          }    
      }
      
      if(wantRobot==1){
          playerSize=humanPlayerSize+robotPlayerSize;
          players=new Player[playerSize];
          for(int i=0; i<playerSize;i++){
              if(i<humanPlayerSize){
                  players[i]=new Player(terrain.getStart(), terminal);
                  players[i].setName("Player "+Integer.toString(i));
             
              }
              else{
                  players[i]=new Player(terrain.getStart(), robot);
                  players[i].setName("Robot "+Integer.toString(i-humanPlayerSize));
                  
              }
              }

          

      }else{
          playerSize=humanPlayerSize;
          players=new Player[playerSize];
          for(int i=0; i<playerSize;i++){
              players[i]=new Player(terrain.getStart(), terminal);
              players[i].setName("Player "+Integer.toString(i));
              
          }
      }

      terminal.giveStatus("----------------\n"+"the players are as follow \n");

      for(int i=0;i<playerSize;i++){
          terminal.giveStatus(players[i].getName());
      }
      terminal.giveStatus("--------------------- \n");

      for(int i=0;i<playerSize;i++){
          Runnable thread=players[i];
         // new Thread(thread).start();
         Thread myThread=new Thread(thread);
         threadList.leggTil(myThread);
      }
      threadList.printListe();
      for(Thread t: threadList){
        t.start();

      }
      for(Thread t: threadList){
        try{
            print(" waiting till all the threads end");
           t.join();
        }catch(Exception e){
            print("something went wrong in threads");
        }
      }

      print("all threads are killed");

      terminal.giveStatus("----------");
      terminal.giveStatus("The winner is "+getWinner(players).getName());     

    }
     
    public static void print(String s){
      System.out.println(s);
  }

  public static Player getWinner(Player[] players){
    Player winner = players[0]; 
    double max=0;
     for(int i=0;i<players.length;i++){
         if(players[i].getFortune()>max){
             max=players[i].getFortune();
             winner=players[i];
         }
     }
     return winner;
 }
 
}