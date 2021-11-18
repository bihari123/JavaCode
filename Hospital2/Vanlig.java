//subklassen Vanlig arver egenskaper fra klassen  Legemiddel. 
public  class Vanlig extends Legemiddel{

    public Vanlig(String navn, double pris,double virkestoff){
        super(navn, pris, virkestoff);
    }
    //Overskriver toString() metoden for senere bruk i integerasjonstest.
    public String toString()
    {
        return ("ID: "+ id + "\nNavn: " + navn+ "\nPris: " + pris + "\nVirkestoff: " + virkestoff);
    }
}
