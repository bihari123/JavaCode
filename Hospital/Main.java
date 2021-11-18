public class Main{
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
        
        Addictive a=new Addictive("name",90,78,2);
        print(a.getName()); 
        printDouble(a.getActiveSubstance());
        printDouble(a.getPrice());
        printInt(a.getID());
        printInt(a.getAddictiveStrength());

        Doctor printedDoctor=new Doctor("Waleed");
        WhitePrescription b= new WhitePrescription(a, printedDoctor, 12, 3);
        print(" the information of WhitePrescription b is as follows \n");
        print(b.getMedicine().toString()); 
        printDouble(b.getID());
        print(b.getDoctor().toString());
        printInt(b.getPatientID());
        printInt(b.getReit());

        print("\n \n the old price of the military prescription was");
        printDouble(a.getPrice());
        MilitaryPrescription m =new MilitaryPrescription(a, printedDoctor, 4, 5);
        print(" the new price of the military prescription is \n ");
        printDouble(m.medicine.getPrice());


        Narcotic b2=new Narcotic("narcos", 200, 45, 5);
        print(" the old price of the P prescription was");
        printDouble(b2.getPrice());
        
        P_prescription p= new P_prescription(b2, printedDoctor, 5);
        print(" the new price of the military prescription is \n");
        printDouble(p.medicine.getPrice());

        Specialist my_Specialist=new Specialist("Mustafa", 123);
        printInt(my_Specialist.getControllID());
        print("the name of the specialist doctor is");
        print(my_Specialist.getName());
        print(" The id is");
        printInt(my_Specialist.getControllID());

    }
}