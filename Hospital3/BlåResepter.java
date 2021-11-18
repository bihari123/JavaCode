//subklassen BlåResepter arver egenskaper fra klassen  Resepter.
//I tillegg, har den metoder farge() og prisAaBetale() som legger til
//farge og pris å betale.
public class BlåResepter extends Resepter{

    public BlåResepter(Legemiddel legemiddel,Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

	public String farge() {
		return ("Blå");
	}

	public double prisAaBetale() {
		return (legemiddel.hentPris()*0.25);
	}

	//Overskriver toString() metoden for senere bruk i integerasjonstest.
    public String toString()
    {
        return ("BlåResept ID: " + id +"\nLegemiddel: "+ legemiddel.hentNavn() + "\nLege: " + utskrivendeLege.getName())+ "\nPasient :: " + pasient+ "\n Reit: " + reit + "\nPris å betale: "+prisAaBetale();
    }
}
