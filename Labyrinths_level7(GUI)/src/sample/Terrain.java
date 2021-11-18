package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terrain {

    File file = new File("./resources/steder.txt");
    Place startingPlace=null;
    //Liste<Place> liste = new Lenkeliste<Place>();

    public Terrain() throws FileNotFoundException {
        
        Scanner read;
    
        read = new Scanner(file);
       
        while(read.hasNextLine()) {

            String description = read.nextLine();
            Place myPlace=new Place(description);
           // print("hi");
            this.leggTil(myPlace);
            myPlace.placeTreasure();    
        }
      
        read.close();
    }

    public Place getStart(){
        return this.hent(0);    
    }

    public void print(String s){
        System.out.println(s);
    }

    public  void printPath() 
    { 
        Place currPlace = this.getStart(); 
   
        System.out.println("Terrain: "); 
   
        // Traverse through the LinkedList 
        while (currPlace != null) { 
            // Print the data at current node 
            System.out.println(currPlace.description + " "); 
   
            // Go to next node 
            currPlace = currPlace.next; 
        } 
         System.out.print( "\n"); 
    } 

    // adding the node to the last
    public void leggTil(Place x){
         
        Place p,q,newNode;
        q=new Place();
        

        if (x == null){
            System.out.println("Memory Error");
        }
        
        p= this.startingPlace;
        // if the list is empty then add it to head
        if(this.startingPlace == null){
            this.startingPlace= x;
        }
        else{ // go to the last node
            while(p!= null){
               q=p; 
               p=p.next;
            }
            q.next = x;
            x.next=p;
        }

    }

    public Place hent(int pos) {
        int k=0;
        //this.printList();
        if (pos < 0 || pos >= this.stoerrelse()) {
           throw new UgyldigListeIndeks(pos);
       }

        
        Place p=new Place();
        p=this.startingPlace;
        if(this.startingPlace == null){
            System.out.println("List empty");
        }
        else{
            if(pos==(this.stoerrelse())){
               while(p.next!=null){
                   p=p.next;
                  } 

            }else{
               while(p.next!=null&& k<pos){
                   //System.out.println("hi");
                   k++;     
                   p=p.next;
                  }     
            }
            }
        return p;
    }


    public int  stoerrelse(){
        int count =0;
        Place current= this.startingPlace;
        
        while(current!=null){ // count untill null
            count++;
            current=current.next;
        }
       return count;
    }

}