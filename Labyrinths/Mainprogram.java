import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Mainprogram {
    public static void print(String s){
        System.out.println(s+"\n");
    }
    public static void main(String[] args) {
        String filnavn = null;

        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println(
                "ERROR! Proper use of the program:"
                                               + "java Oblig5 <maze file>");
            return;
        }
        
        File fil = new File(filnavn);
        Labyrinth l = null;

        if(args.length>1 && args[1].equals("detailed")){
            try {
                l = Labyrinth.readFromFile(fil,true);
            } catch (FileNotFoundException e) {
                System.out.printf("Error: could not read from'%s'\n", filnavn);
                System.exit(1);
            }    
        }
     else{   
        try {
            l = Labyrinth.readFromFile(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("Error: could not read from'%s'\n", filnavn);
            System.exit(1);
        }
    }
    print(l.toString());
        Scanner inn = new Scanner(System.in);
        System.out.println(" Enter coordinates <rad> <col> ('a' to end)");
        String[] ord = inn.nextLine().split(" ");
        while (!ord[0].equals("a")) {

            try {
                 int startRow = Integer.parseInt(ord[0]);
                int startCol = Integer.parseInt(ord[1]);
                
                

                Liste<String> utveier = l.findExitFrom(startRow, startCol);
                
                print("the size of path array= "+Integer.toString(utveier.stoerrelse()));
                if (utveier.stoerrelse() != 0) {
                    for (String s : utveier) {
                        System.out.println(s);
                    }
                } else {
                    System.out.println("No way out.");
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input!");
            }
            
            System.out.println(" Enter coordinates <rad> <col> ('a' to end)");
            ord = inn.nextLine().split(" ");
        }
    }
}