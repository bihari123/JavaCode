public class WhitePrescription extends Prescription{
    /**
     * @var color stores the color code of the prescription
     */
    String color;
    
    public WhitePrescription(Medicine medicine,Doctor printedDoctor, int patientID, int REIT){
        super(medicine,printedDoctor,patientID,REIT);
        this.color= "White";
    }

    public String color(){
        return this.color;
    }

    public double priceToPay(){
        return this.medicine.getPrice();
    }
}   
   