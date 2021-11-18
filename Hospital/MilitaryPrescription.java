class MilitaryPrescription extends WhitePrescription{
    public MilitaryPrescription(Medicine medicine, Doctor printedDoctor, int patientID, int REIT) {
        super(medicine, printedDoctor, patientID, REIT);
        // military prescriptions have 100% discount
        // therefore, setting the price of medicine to zero.
        this.medicine.setNewPrice(0);
    }   

}