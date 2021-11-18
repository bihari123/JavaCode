import java.io.FileNotFoundException;

class MultipleExitPlayer extends Player {
    MultipleExitPlace place; Terminal terminal;Robot robot;
    public MultipleExitPlayer(MultipleExitPlace startingPlace, Terminal terminal) throws FileNotFoundException {
        super(startingPlace, terminal);
        this.place=startingPlace;
        this.terminal=terminal;       
    }

    public MultipleExitPlayer(MultipleExitPlace startingPlace, Robot robot) throws FileNotFoundException {
        super(startingPlace, robot);
        this.place=startingPlace;
        this.robot=robot;
    }



    public void newMove(){
        boolean loopExit=false;
        if(human){
         while(!loopExit){
             try{
                 this.terminal.giveStatus("\n---------------");
                 int answer=terminal.askForCommand("do you want to sell an item? (press 1 for yes or 0 for no)", null);
             
                 if(answer==1 ){
                     loopExit=true;
                     String[] options = new String[this.backpack.box.size()];
                     
                     for(int i=0;i<this.backpack.box.size();i++){
                         options[i]=this.backpack.box.get(i).toString();
                     }
                      this.terminal.giveStatus("------------------\n");
                      
                      int index=terminal.askForCommand("which item do you want to sell",options );
                      //Item itemToremove=this.backpack.box.get(index);
                      this.terminal.giveStatus("------------------\n");
                      this.terminal.giveStatus("you selected "+Integer.toString(index));    
                      this.terminal.giveStatus("player previous fortune = "+ Double.toString(this.fortune));   
                      this.fortune=this.fortune+this.place.treasureChest.addItem(index, this);
         
                      this.terminal.giveStatus("player new fortune = "+ Double.toString(this.fortune));
                      this.terminal.giveStatus("----------------------\n");
                  }
                  else if(answer ==0){
                     loopExit=true;
                      answer=terminal.askForCommand("do you want to take an item from the treasureChest? (press 1 for yes or 0 for no)", null);
                      if(answer==1){
                          this.place.treasureChest.removeRandomItem(this);   
                      }
                      
                  }
                  else{
                     this.terminal.giveStatus("please enter a valid input");
                  }
             }catch(Exception e){
                 this.terminal.giveStatus("please enter a valid input");
             }
             
            }

            int answer=terminal.askForCommand("where do you want to go? \n Press 0 for forward \n Press 1 for right \n Press 2 for left", null);
            switch (answer){
                case 0: this.place=this.place.moveForward();break;
                case 1: this.place=this.place.moveRight(); break;
                case 2: this.place=this.place.moveLeft(); break; 
            }
     
        }
        else{
         while(!loopExit){
             try{
                this.robot.giveStatus("\n---------------");
                 int answer=robot.askForCommand("do you want to sell an item? (press 1 for yes or 0 for no)", null);
             
                 if(answer==1 ){
                     loopExit=true;
                     String[] options = new String[this.backpack.box.size()];
                     
                     for(int i=0;i<this.backpack.box.size();i++){
                         options[i]=this.backpack.box.get(i).toString();
                     }
                     this.robot.giveStatus("------------------\n");
                       
                     int index=robot.askForCommand("which item do you want to sell",options );
                      //Item itemToremove=this.backpack.box.get(index);
                      this.robot.giveStatus("------------------\n");
                      this.robot.giveStatus("you selected "+Integer.toString(index));    
                      this.robot.giveStatus("player previous fortune = "+ Double.toString(this.fortune));   
                      this.fortune=this.fortune+this.place.treasureChest.addItem(index, this);
         
                      this.robot.giveStatus("player new fortune = "+ Double.toString(this.fortune));
                      this.robot.giveStatus("--------------------------\n");

                  }
                  else if(answer ==0){
                     loopExit=true;
                      answer=robot.askForCommand("do you want to take an item from the treasureChest? (press 1 for yes or 0 for no)", null);
                      if(answer==1){
                          this.place.treasureChest.removeRandomItem(this);   
                      }
                      
                  }
                  else{
                     this.robot.giveStatus("please enter a valid input");
                  }
             }catch(Exception e){
                 this.robot.giveStatus("please enter a valid input");
             }
             
            }

            int answer=robot.askForCommand("where do you want to go? \n Press 0 for forward \n Press 1 for right \n Press 2 for left", null);
            switch (answer){
                case 0: this.place=this.place.moveForward();break;
                case 1: this.place=this.place.moveRight(); break;
                case 2: this.place=this.place.moveLeft(); break; 
            }
     
        }
        
        
        
     }
     public MultipleExitPlace getPlace(){
        return this.place;
    }

}