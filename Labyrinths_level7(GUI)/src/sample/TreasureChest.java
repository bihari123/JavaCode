package sample;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class TreasureChest {

    ArrayList <Item> itemList =new ArrayList<>();
    ArrayList <Item> box =new ArrayList<>();

    

    public TreasureChest() throws FileNotFoundException{
        File file=new File("./resources/gjenstander.txt");

        Scanner read;
    
        read = new Scanner(file);
       
        while(read.hasNextLine()) {

            String line = read.nextLine();

            String[] splitted_line = line.split(" ");
        
            String name = splitted_line[0];
            int value = Integer.parseInt(splitted_line[1]);
        
            //System.out.println(name+" " +Integer.toString(value));
                
            itemList.add(new Item(name, value)); 
  
        }
      
        read.close();
     
        for(int i=0;i<4;i++){
            int rand= (int) (Math.random()*(itemList.size()-1));
            box.add(itemList.get(rand));
        }

      /*  for(int i=0; i<box.size();i++){
            print(box.get(i).getName());
        }
        */
        
    }   

    /*public void addItem(Item item, Player player){
    
        box.add(item);
        player.fortune=player.fortune+ item.getValue()+ Math.pow(-1,  (int)(Math.random()*3))*(Math.random()*10);
        //player.backpack.remove();
    }

    public void remove(Player player){
        int i= (int)Math.random()*(box.size()-1);
        //player.backpack.addItem(box.get(i), player);
    }

    */

    public double addItem(int index,Player player){   
        Item itemToadd=player.backpack.box.get(index);
        this.box.add(itemToadd);
        for(int i=0;i<this.box.size();i++){
            print(this.box.get(i).toString());
        }
        player.backpack.removeSelectedItem(index);
        print("the players backpack content is");
        for(int i=0;i<player.backpack.box.size();i++){
            print(player.backpack.box.get(i).toString());
        }
        return  (itemToadd.getValue() + Math.pow(-1, (int) (Math.random() * 3)) * (Math.random() * 10));
    }

    /*public Item getRandomItem(){
        int index= (int)Math.random()*(box.size()-1);
        return box.get(index);
    }*/

    public void removeRandomItem(Player player){
        int index= (int)Math.random()*(box.size()-1);
        player.backpack.box.add(this.box.get(index));
        this.box.remove(index);
    }

    public void removeSelectedItem( int index){
         this.box.remove(index);
    }
    public void print(String s){
        System.out.println(s);
    }

}