class SortertLenkeliste < T extends Comparable <T>> extends Lenkeliste <T> {
    public SortertLenkeliste(){
        super();
    }
    @Override
    public void leggTil(T x) { //overring the leggTil(T x) method of the parent class
   
      Node newNode = new Node(x);
      Node p =new Node();
      Node q =new Node();   
      p=this.head;
       if (super.stoerrelse() == 0) {
         this.head = newNode;
       }
   
       // comparing the new element to be added with all the exixting elements and the placing it in ascending order
       else if (x.compareTo(this.head.data) <= 0) {
           newNode.next=p;
           this.head=newNode;
           newNode.next=p;
       }
   
       else if (x.compareTo(this.head.data) > 0) {
         
            while(p!= null){
              if(x.compareTo(p.data)>0){
                  q= p;
                  p=p.next;
                
              }else{
                break;
              }
            }
            q.next=newNode;
            newNode.next=p;
        }
        
        this.printList();
      }

      
   
    /*   
       else {
         while(p!= null){
             if(x.compareTo(p.data)>0){
                 q= p;
                 p=p.next;
                 break;
             }
             
         }
         q.next=newNode;
         newNode.next=p;
       }
       this.printList();
   */
      
   
   @Override
   public T fjern() {
     
     Node p =this.head;
     Node q = new Node();
  
   if (this.head == null) {
       throw new UgyldigListeIndeks(-1);
   }
  
   if (head.next == null) {
       this.head = null;
       
   }
   else {
       while (p.next != null) {
          q=p;
          p=p.next;
       }
       q.next = null;  // removing the largest element i.e. the last element
   }
  
  
  
   return p.data; 
  
   }

   
   @Override
   public void sett(int pos, T x) {
    throw new UnsupportedOperationException(); // disabling the method of parent class
  }
  
  @Override
  public void leggTil(int pos, T x) {
   throw new UnsupportedOperationException();// disabling the method of parent class
 }
 

}
