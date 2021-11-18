
public class TestPrescription{

/**
 * Functions to print various data types
 */
    public static void print(String s){
        System.out.println(s);
    }

    public static void printInt(int s){
        System.out.println(Integer.toString(s));
    }


    public static void printDouble(double s){
        System.out.println(Double.toString(s));
    }


    public static void main(String[] args) {

        Addictive b=new Addictive("AlphaCapsules",90,78,2);
        Doctor printedDoctor=new Doctor("Waleed");
        WhitePrescription a= new WhitePrescription(b, printedDoctor, 12, 3);
        print(" the information of a is as follows \n");
        print(a.getMedicine().toString()); 
        printDouble(a.getID());
        print(a.getDoctor().toString());
        printInt(a.getPatientID());
        printInt(a.getReit());

        print(" the old price of the military prescription was");
        printDouble(b.getPrice());
        MilitaryPrescription m =new MilitaryPrescription(b, printedDoctor, 4, 5);
        
        print(" the new price of the military prescription is \n ");
        printDouble(m.medicine.getPrice());

        Narcotic b2=new Narcotic("narcos", 200, 45, 5);
        print(" the old price of the P prescription was");
        printDouble(b2.getPrice());
        P_prescription p= new P_prescription(b2, printedDoctor, 5);

        print(" the new price of the military prescription is \n");
        printDouble(p.medicine.getPrice());
    }  
}