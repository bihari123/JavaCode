class Pasient  {
    public static int s_no=0;
    int id;
    String name;
    String dateOfBirth;
    Stabel<Resepter> list_of_prescriptions=new Stabel<Resepter>();

    public Pasient(String name, String dateOfBirth){
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        
        this.id=s_no++;
    }

    public void addNewPrescription(Resepter p){
        this.list_of_prescriptions.leggPaa(p);
    }

    public Stabel<Resepter> getPrescriptionList(){
        return this.list_of_prescriptions;
    }

    public int getPatientId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDataOfBirth(){
        return this.dateOfBirth;
    }

}