class Lenkeliste<T> implements Liste<T> {
    Node head;
    public Lenkeliste() {
        head = null;
    }
    // initializing the node
     public class Node{
          public T data ;
         public Node next;

         public Node(T x){  
            data=x;
            next=null;
         }

         public Node(){
            data=null;
            next=null;
         }
         
         
     } 
     // adding the node to the last
     public void leggTil(T x){
         
         Node p,q,newNode;
         q=new Node();
         newNode=new Node(x);

         if (newNode == null){
             System.out.println("Memory Error");
         }
         
         p= this.head;
         // if the list is empty then add it to head
         if(this.head == null){
             this.head= newNode;
         }
         else{ // go to the last node
             while(p!= null){
                q=p; 
                p=p.next;
             }
             q.next = newNode;
             newNode.next=p;
         }

     }

     public void leggTil(int pos, T x){ // add at specific position
        
        if (pos < 0 || pos > this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
        }
        

        int k=0;
        Node p,q,newNode;
        q=new Node();
        newNode=new Node(x);
        if (newNode == null){
            System.out.println("Memory Error");
        }
        
        p= this.head;
        if(pos==0){
            newNode.next=p;
            this.head=newNode;
        }else{
            while(p!= null && k<pos){ // transversing to the node at specified position
    
                k++;
                q=p;
                p=p.next;
            }
            q.next=newNode;
            newNode.next=p;
        }
        
     }
     
     
     public void sett(int pos, T x){ // replace the node at the given position
      
        if (pos < 0 || pos >= this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
		}
        int k=0;
        Node p,q,newNode;
        q=new Node();
        newNode=new Node(x);
        if (newNode == null){
            System.out.println("Memory Error");
        }
        
        p= this.head;

        if(pos == 0){
            newNode.next=p;
            newNode.next=this.head.next;
            this.head=newNode;

        }else{
            while(p!= null && k<pos){ // transversing to the node at specified position
            k++;
            q=p;
            p=p.next;
            }
            q.next=newNode;
            newNode.next=p.next;
         }
     }
     

     public T fjern(){
      
      Node p=this.head;
      if(this.head == null){
          System.out.println("List empty");
          throw new UgyldigListeIndeks(-1);
      }
      else{
          this.head= this.head.next; // remove the head
          
      }
      return p.data;
     }

     public T fjern(int pos){


        if (pos < 0 || pos >= this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
		}

        int k=0;
        Node q = new Node();
        Node p=this.head;
        if(this.head == null){
            System.out.println("List empty");
        }
        else if(pos==0){ 
            if(this.head == null){
                System.out.println("List empty");
                throw new UgyldigListeIndeks(-1);
            }
            else{
                this.head= this.head.next;// remove the head
                
            }
            return p.data;

        }
        
        
        else{
             while(p.next!=null&& k<pos){ //go to the specific position
                k++;
                q=p;
                p=p.next;
            }
            if(p==null){
                    System.out.println("Position doesn\'t exist");
                }

            else{
                    q.next=p.next; //removed the middle element
                    
                    
                }
                 
        }
        return p.data; 
       }
      

     public int  stoerrelse(){
         int count =0;
         Node current= this.head;
         
         while(current!=null){ // count untill null
             count++;
             current=current.next;
         }
        return count;
         
     }

     public T hent(int pos) {
         int k=0;
         this.printList();
         if (pos < 0 || pos >= this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
		}

         
         Node p=new Node();
         p=this.head;
         if(this.head == null){
             System.out.println("List empty");
         }
         else{
             if(pos==(this.stoerrelse())){
                while(p.next!=null){
                    p=p.next;
                   } 

             }else{
                while(p.next!=null&& k<pos){
                    System.out.println("hi");
                    k++;     
                    p=p.next;
                   }     
             }
             }
         return p.data;
     }


     public  void printList() 
     { 
         Node currNode = this.head; 
    
         System.out.print("LinkedList: "); 
    
         // Traverse through the LinkedList 
         while (currNode != null) { 
             // Print the data at current node 
             System.out.print(currNode.data + " "); 
    
             // Go to next node 
             currNode = currNode.next; 
         } 
          System.out.print( "\n"); 
     } 
}   
