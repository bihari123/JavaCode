package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Terminal implements UserInterface {

   public void giveStatus(String status){
       System.out.println(status);
    }

    public int askForCommand(String question, String[] options){
        System.out.println(question);
        Scanner sc=new Scanner(System.in);  
        
        try{
            for(int i=0;i<options.length;i++) {
        
                System.out.println(Integer.toString(i)+" : "+options[i]);
        
            }
        }
        catch(NullPointerException e){
        }
        
        
        String str= sc.nextLine();
        return Integer.parseInt(str);
        
    }

   
}
    
