class LinkedListTest{
public static void main(String[] args) 
{ 
    /* Start with the empty list. */
    LinkedList list = new LinkedList(); 
    list.add(1);
    list.add(2);
    list.add(4);
    list.add(6);
    list.add(1,3);
    list.printList();
   /* while(list!= null){
        System.out.println(list.remove());
    }
    */
    int k=0;
    while(k<list.size()){
        System.out.println("k= "+Integer.toString(k)+" "+list.get(k));
        k++;
        System.out.println(Integer.toString(list.size()));
    }
   
   //list.printList();
   System.out.println(list.remove(1));

   System.out.println(list.get(1));

}
}