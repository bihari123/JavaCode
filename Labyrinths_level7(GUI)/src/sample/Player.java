package sample;

import java.io.FileNotFoundException;

public class Player {
    Place place;
    double fortune;
    Terminal terminal;
    TreasureChest backpack;
    Robot robot;
    boolean human;
    String name;
    public Player(Place startingPlace, Terminal terminal) throws FileNotFoundException {
        this.place=startingPlace;
        this.terminal=terminal;
        this.backpack= new TreasureChest();
        this.fortune=0.0;
        this.human=true;
    }

    public Player(Place startingPlace, Robot robot) throws FileNotFoundException {
        this.place=startingPlace;
        this.robot=robot;
        this.backpack= new TreasureChest();
        this.fortune=0.0;
        this.human=false;
    }

    public void newMove(){
       boolean loopExit=false;
       if(human){
        while(!loopExit){
            try{
                int answer=terminal.askForCommand("do you want to sell an item? (press 1 for yes or 0 for no)", null);
            
                if(answer==1 ){
                    loopExit=true;
                    String[] options = new String[this.backpack.box.size()];
                    
                    for(int i=0;i<this.backpack.box.size();i++){
                        options[i]=this.backpack.box.get(i).toString();
                    }
                     int index=terminal.askForCommand("which item do you want to sell",options );
                     //Item itemToremove=this.backpack.box.get(index);
                     this.terminal.giveStatus("you selected "+Integer.toString(index));    
                     this.terminal.giveStatus("player previous fortune = "+ Double.toString(this.fortune));   
                     this.fortune=this.fortune+this.place.treasureChest.addItem(index, this);
        
                     print("player new fortune = "+ Double.toString(this.fortune));
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
    
       }
       else{
        while(!loopExit){
            try{
                int answer=robot.askForCommand("do you want to sell an item? (press 1 for yes or 0 for no)", null);
            
                if(answer==1 ){
                    loopExit=true;
                    String[] options = new String[this.backpack.box.size()];
                    
                    for(int i=0;i<this.backpack.box.size();i++){
                        options[i]=this.backpack.box.get(i).toString();
                    }
                     int index=robot.askForCommand("which item do you want to sell",options );
                     //Item itemToremove=this.backpack.box.get(index);
                     this.robot.giveStatus("you selected "+Integer.toString(index));    
                     this.robot.giveStatus("player previous fortune = "+ Double.toString(this.fortune));   
                     this.fortune=this.fortune+this.place.treasureChest.addItem(index, this);
        
                     print("player new fortune = "+ Double.toString(this.fortune));
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
    
       }
       
       this.place=this.place.moveForward();
       
    }
    
    public Place getPlace(){
        return this.place;
    }
    
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public boolean isHuman(){
        return this.human;
    }
    public double getFortune(){
        return this.fortune;
    }
    public void print(String s){
        System.out.println(s);
    }
}