public class BluePrescription extends Prescription{
	String color;
    public BluePrescription(Medicine medicine,Doctor printedDoctor, int patientID, int REIT){
        super(medicine, printedDoctor, patientID, REIT);
        this.color="Blue";
        this.medicine.setNewPrice(this.medicine.getPrice()*0.25);
    }

	public String color() {
		// TODO Auto-generated method stub
		return this.color;
	}

	public double priceToPay() {
		// TODO Auto-generated method stub
		return this.medicine.getPrice();
	}
}