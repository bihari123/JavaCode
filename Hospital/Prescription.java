public abstract class Prescription{
    /**
     * @var id stores the id of the prescription
     * @var medicine stores the refrence to the medicine
     * @var doctor stores the reference to the doctor
     * @var patientId stores the id of the patient
     * @var REIT stores the no of times a prescription can be used
     */
    int id ;
    Medicine medicine;
    Doctor doctor;
    int patientId;
    int REIT;
    

    public Prescription(Medicine medicine,Doctor printedDoctor, int patientID, int REIT){
        this.medicine=medicine;
        this.doctor=printedDoctor;
        this.patientId=patientID;
        this.REIT=REIT;
    }

     public int getID() {
        return this.id;
    }

    public int getPatientID() {
        return this.patientId;
    }

    public int getReit() {
        return this.REIT;
    }

    public Medicine getMedicine(){
        return this.medicine;
    }

    public Doctor getDoctor(){
        return this.doctor;
    }
/**
 * checks whether the prescription has expired or not
 * @return  true or false
 */
    public boolean use(){
        if (this.REIT == 0){
            return false;
        }
        else{
            return true;
        }
    }

/**
     * overrinding the toString() method
     */
    public String toString() 
    { 
        return "ID:"+Integer.toString(this.id)+ "\n"+this.medicine.toString() +"\n"+ "PatientID:"+Integer.toString(this.patientId)  + "\n Doctor:"+this.doctor.toString() ; 
    }
    
    
    abstract public String color ();
    abstract public double priceToPay();
}