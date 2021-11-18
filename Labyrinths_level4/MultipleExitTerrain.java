import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MultipleExitTerrain extends Terrain{
    File file = new File("steder.txt");
    MultipleExitPlace startingPlace=null;

    public MultipleExitTerrain() throws FileNotFoundException {
        
        // TODO Auto-generated constructor stub

        Scanner read;
    
        read = new Scanner(file);
       
        while(read.hasNextLine()) {

            String description = read.nextLine();
            MultipleExitPlace myPlace=new MultipleExitPlace(description);
           // print("hi");
            this.addForward(myPlace);
            myPlace.placeTreasure();    
        }
     // this.printPath();
        read.close();
       // print("generating random path");
        this.generateRandomPath();

    }

    public void addForward(MultipleExitPlace x){
         
        MultipleExitPlace p,q;
        q=new MultipleExitPlace();
        

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
               p=p.forward;
            }
            q.forward = x;
            x.forward=p;
        }

    }


    public void generateRandomPath(){
        for(int i=0;i<this.stoerrelse();i++){
            MultipleExitPlace p,q;
            boolean keepLooping=true;
            boolean firstTest;
            boolean secondTest;
            
            while(keepLooping){
                p=this.hent(i);
                int randomElement=(int)Math.round(Math.random()*(this.stoerrelse()-1));
            
                firstTest=false;
                secondTest=false;


               // print("adding left");
                q=this.hent(randomElement);
                
                if(p.left==null /*&&q.right==null*/){
    
                    p.left=q;
                    q.right=p;
                    firstTest=true;
                   // print(q.toString());
                }
                
                randomElement=(int)Math.round(Math.random()*(this.stoerrelse()-1));
                q=this.hent(randomElement);
               // print("adding right");
                
                if(p.right==null /*&&q.left==null*/){
                    p.right=q;
                    q.left=p;
                    secondTest=true;
                 //   print(q.toString());
                }
                keepLooping=firstTest&&secondTest;
            }
              
        }
    }
   

    public MultipleExitPlace hent(int pos) {
        int k=0;
        //this.printList();
        if (pos < 0 || pos >= this.stoerrelse()) {
           throw new UgyldigListeIndeks(pos);
       }

        
        MultipleExitPlace p=new MultipleExitPlace();
        p=this.startingPlace;
        if(this.startingPlace == null){
            System.out.println("List empty");
        }
        else{
            if(pos==(this.stoerrelse())){
               while(p.forward!=null){
                   p=p.forward;
                  } 

            }else{
               while(p.forward!=null&& k<pos){
                   //System.out.println("hi");
                   k++;     
                   p=p.forward;
                  }     
            }
            }
        return p;
    }

    public MultipleExitPlace getStart(){
        return this.hent(0);    
    }
    
}