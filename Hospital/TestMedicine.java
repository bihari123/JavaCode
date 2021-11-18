public class TestMedicine {
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
        Narcotic a=new Narcotic("name",90,78,2);  
        print(" the information of a is as follows \n");
        print(a.getName()); 
        printDouble(a.getActiveSubstance());
        printDouble(a.getPrice());
        printInt(a.getID());
        printInt(a.getNarcoticStrength());

        Addictive b=new Addictive("name",90,78,2);
        print("the information about b is as follows");
        printInt(b.getAddictiveStrength()); 
        printInt(b.getID());
        Common c= new Common("name", 68, 86);
        print("the information about c is as follows");
        printDouble(c.getPrice());
        printInt(c.getID());
        
}
}