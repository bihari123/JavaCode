public class Specialist extends Doctor implements approvalExemption{
    /**
     * @var controllID stores the id of the specialist
     */
    int controllId;
    public Specialist(String name, int controllId){
        super(name);
        this.controllId=controllId;
    }

    /**
     * getter method
     * @return controllId of the specialist
     */
    public int getControllID(){
        return this.controllId;
    }
    /**
     * overrinding the toString() method
     */
    public String toString() 
    { 
        return "Name:"+ this.name + " ControllId: "+ Integer.toString(this.controllId);
    }
}