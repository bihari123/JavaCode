class P_prescription extends WhitePrescription{
        
    public P_prescription(Medicine medicine, Doctor printedDoctor, int patientID) {
        super(medicine, printedDoctor, patientID,3);
        
        
        this.medicine.setNewPrice(this.medicine.getPrice()-108);
    
    }
}