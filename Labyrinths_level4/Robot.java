public class Robot implements UserInterface{

    public void giveStatus(String status){
        System.out.println(status);
     }
 
     public int askForCommand(String question, String[] options){
         System.out.println(question);
         int answer;
         if(options !=null ){
            try{
                for(int i=0;i<options.length;i++) {
            
                    System.out.println(Integer.toString(i)+" : "+options[i]);
            
                }
            }
            catch(NullPointerException e){
            }
          
            answer=(int)Math.round(Math.random()*(options.length-1));
            giveStatus("the selected answer is "+Integer.toString(answer)+"\n");
         }
         else{
             answer=(int)Math.round(Math.random());
             giveStatus("the selected answer is "+Integer.toString(answer)+"\n");
         
         }  
         
         return answer;
         
         
     }
    
}