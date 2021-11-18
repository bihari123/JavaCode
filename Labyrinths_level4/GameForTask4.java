import java.io.File;
import java.io.FileNotFoundException;

public class GameForTask4 {
    public static void main(String[] args) throws FileNotFoundException {
        // File file=new File("gjenstander.txt");
       //TreasureChest t = new TreasureChest();
       MultipleExitTerrain terrain=new MultipleExitTerrain();
       Terminal terminal=new Terminal();
       Robot robot=new Robot();
      MultipleExitPlayer player0= new MultipleExitPlayer(terrain.getStart(), robot);
      player0.setName("Robot 0");
      player0.robot.giveStatus("First "+player0.getName()+" will start");
      while(player0.place.forward!=null){
        player0.newMove();    
        robot.giveStatus("player's new position is "+ player0.getPlace().toString());   
       }

       robot.giveStatus("player\'s fortune is '"+ Double.toString(player0.fortune));
      robot.giveStatus("-------------------\n");
      
      MultipleExitPlayer player1=new MultipleExitPlayer(terrain.getStart(), terminal);
      player1.setName("Player 0");
      player1.terminal.giveStatus("Now its  "+player1.getName()+" \'s turn ");
      
      while(player1.place.forward!=null){
        player1.newMove();    
        terminal.giveStatus("player's new position is "+ player1.getPlace().toString());   
       }

       terminal.giveStatus("player\'s fortune is '"+ Double.toString(player1.fortune));
      terminal.giveStatus("-------------------\n");
      
     
    }

    public static void print(String s){
      System.out.println(s);
  }
}