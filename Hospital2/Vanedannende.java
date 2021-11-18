//subklassen Vanedannende arver egenskaper fra klassen  Legemiddel. 
//I tillegg, har den en egen metode "hentVanedannendeStyrke()" som setter styrke.

public class Vanedannende extends Legemiddel{
    int styrke;
    public Vanedannende(String navn, double pris,double virkestoff, int styrke){
        super(navn,pris,virkestoff);
        this.styrke=styrke;
    }

    public int hentVanedannendeStyrke(){
        return this.styrke;
    }

    //Overskriver toString() metoden for senere bruk i integerasjonstest.
    public String toString()
    {
        return ("ID: "+ id + "\nNavn: " + navn+ "\nPris: " + pris + "\nVirkestoff: " + virkestoff+ "\nStyrke: " + hentVanedannendeStyrke());
    }
}
