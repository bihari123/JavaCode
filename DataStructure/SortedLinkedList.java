class SortedLinkedList < T extends Comparable <T>> extends LinkedList <T> {
    public SortedLinkedList(){
        super();
    }
    @Override
    public void add(T x) {
   
      Node newNode = new Node(x);
      Node p =new Node();
      Node q =new Node();   
      
       if (super.size() == 0) {
         head = newNode;
       }
   
       
       else if (x.compareTo(head.data) < 0) {
           newNode.next=p;
           head=newNode;
           q.next=newNode;
           newNode.next=p;
       }
   
       else if (x.compareTo(head.data) > 0) {
         
         head.next=newNode;
       }
   
       
       else {
         while(p!= null){
             if(x.compareTo(p.data)<0){
                 q= p;
                 p=p.next;
                 break;
             }
         }
         q.next=newNode;
         newNode.next=p;
       }
   }
   
   @Override
   public T remove() {
     
     Node p =head;
     Node q = new Node();
  
   if (head == null) {
       throw new UnsupportedOperationException();
   }
  
   if (head.next == null) {
       head = null;
       
   }
   else {
       while (p.next != null) {
          q=p;
          p=p.next;
       }
       q.next = null; 
   }
  
  
  
   return p.data; 
  
   }

}
