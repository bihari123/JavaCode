public class Doctor{
    /**
     * @var name stores the name of the doctor
     */
	String name;
    public Doctor(String name){
        this.name= name;
    }

    /**
     * getter method
     * @return  the name of the doctore
     */

    public String getName(){
        return this.name;
    }

    /**
     * overrinding the toString() method
     */
    public String toString() 
    { 
        return this.name; 
    }
}