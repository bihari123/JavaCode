//subklassen Narkotisk arver egenskaper fra klassen  Legemiddel. 
//I tillegg, har den en egen metode "hentNarkotiskStyrke()" som setter styrke.

public class Narkotisk extends Legemiddel {
    int styrke;
    public Narkotisk(String navn, double pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke=styrke;
    }

    public int hentNarkotiskStyrke(){
        return this.styrke;
    }

    //Overskriver toString() metoden for senere bruk i integerasjonstest.
    public String toString()
    {
        return ("ID: "+ id + "\nNavn: " + navn+ "\nPris: " + pris + "\nVirkestoff: " + virkestoff+ "\nStyrke: " + hentNarkotiskStyrke());
    }
}
