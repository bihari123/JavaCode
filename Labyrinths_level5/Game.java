import java.io.File;
import java.io.FileNotFoundException;
public class Game {

    
        public static void main(String[] args)throws FileNotFoundException  {
            boolean loopExit=false;
            int wantRobot=0;
            Terrain terrain=new Terrain();
            Terminal terminal=new Terminal();
            Robot robot=new Robot();
            int numberOfPlayersFinished=0;           
            Player[] players;
           
            int robotPlayerSize=0;
            int playerSize=0;
            int humanPlayerSize=terminal.askForCommand("how many human players do you want", null);
        
            while(!loopExit){
                try {
                    wantRobot=terminal.askForCommand("do you want robot players? (press 1 for yes or 0 for no)", null);

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

            while(numberOfPlayersFinished!=playerSize){
                for(int i=0;i<playerSize;i++){
                    if(players[i].isHuman()){
                        if(players[i].place.next!=null){
                            terminal.giveStatus("----\n"+players[i].getName()+"\'s turn");
                            players[i].newMove();
                        }
                        else{
                            terminal.giveStatus("----\n"+"no turn left for "+players[i].getName()+" skipping turn");
                            numberOfPlayersFinished++; 
                        }
                    }
                    else{
                        if(players[i].place.next!=null){
                            terminal.giveStatus("----\n"+players[i].getName()+"\'s turn");
                            players[i].newMove();
                        }
                        else{
                            terminal.giveStatus("----\n"+"no turn left for "+players[i].getName()+" skipping turn");
                            numberOfPlayersFinished++; 
                        }

                    }
                }             
            }

            terminal.giveStatus("----- The End -----\n Here is the scores");
            for(int i=0;i<playerSize;i++){
                terminal.giveStatus(players[i].getName()+" : "+players[i].getFortune());
            }
              
            terminal.giveStatus("----------");
            terminal.giveStatus("The winner is "+getWinner(players).getName());     
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
         
         public static void print(String s){
           System.out.println(s);
        }
        
        
        
    
}