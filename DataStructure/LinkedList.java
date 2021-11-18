public class LinkedList <T> implements List<T>{
    Node head;
    public LinkedList(){
        head = null;
    }
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
     
     public void add(T x){
         
         Node p,q,newNode;
         q=new Node();
         newNode=new Node(x);

         if (newNode == null){
             System.out.println("Memory Error");
         }
         
         p= this.head;

         if(this.head == null){
             this.head= newNode;
         }
         else{
             while(p!= null){
                q=p; 
                p=p.next;
             }
             q.next = newNode;
             newNode.next=p;
         }

     }

     public void add(int pos, T x){
        
        if (pos < 0 || pos >= this.size()) {
			throw new InvalidListIndex(pos);
		}

        int k=0;
        Node p,q,newNode;
        q=new Node();
        newNode=new Node(x);
        if (newNode == null){
            System.out.println("Memory Error");
        }
        
        p= this.head;
        while(p!= null && k<pos){
            k++;
            q=p;
            p=p.next;
        }
        q.next=newNode;
        newNode.next=p;
     }
     
     
     public void set(int pos, T x){
      
        if (pos < 0 || pos >= this.size()) {
			throw new InvalidListIndex(pos);
		}
        int k=0;
        Node p,q,newNode;
        q=new Node();
        newNode=new Node(x);
        if (newNode == null){
            System.out.println("Memory Error");
        }
        
        p= this.head;
        while(p!= null && k<pos){
            k++;
            q=p;
            p=p.next;
        }
        q.next=newNode;
        newNode.next=p.next;
     }
     

     public T remove(){
      
      Node p=this.head;
      if(this.head == null){
          System.out.println("List empty");
      }
      else{
          this.head= this.head.next;
          
      }
      return p.data;
     }

     public T remove(int pos){


        if (pos < 0 || pos >= this.size()) {
			throw new InvalidListIndex(pos);
		}

        int k=0;
        Node q;
        Node p=this.head;
        if(this.head == null){
            System.out.println("List empty");
        }
        else{
            while(p!=null&& (k<pos)){
                k++;
                q=p;
                p=p.next;
                
                if(p==null){
                    System.out.println("Position doesn\'t exist");
                }

                else{
                    q.next=p.next;
                }
            }
           
            
        }
        return p.data;
       }
      

     public int size(){
         int count =0;
         Node current= this.head;
         
         while(current!=null){
             count++;
             current=current.next;
         }
        return count;
         
     }

     public T get(int pos) {
         int k=0;
         
         if (pos < 0 || pos >= this.size()) {
			throw new InvalidListIndex(pos);
		}

         
         Node p=new Node();
         p=this.head;
         if(this.head == null){
             System.out.println("List empty");
         }
         else{
             while(p!=null&& k<pos){
                 k++;     
                 p=p.next;
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