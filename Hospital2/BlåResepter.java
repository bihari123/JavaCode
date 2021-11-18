//subklassen BlåResepter arver egenskaper fra klassen  Resepter.
//I tillegg, har den metoder farge() og prisAaBetale() som legger til
//farge og pris å betale.
public class BlåResepter extends Resepter{

    public BlåResepter(Legemiddel legemiddel,Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
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
        return ("BlåResept ID: " + id +"\nLegemiddel: "+ legemiddel.hentNavn() + "\nLege: " + utskrivendeLege.hentNavn()+ "\nPasient ID:: " + pasientId + "\nReit: " + reit + "\nPris å betale: "+prisAaBetale());
    }
}
