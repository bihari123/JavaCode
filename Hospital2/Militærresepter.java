//subklassen Militærresepter arver egenskaper fra klassene HviteResepter og Resepter.
//I tillegg, har den metoden prisAaBetale() som legger til pris å betale.
class Militærresepter extends HviteResepter{

    public Militærresepter(Legemiddel legemiddel,Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);

    }

    public double prisAaBetale() {
		return (legemiddel.hentPris()*0); //her ganger jeg med 0 fordi militærresepter alltid gir en 100% rabatt på prisen til et legemiddel.
	}

    //Overskriver toString() metoden for senere bruk i integerasjonstest.
    public String toString()
    {
        return ("Militærresept ID: " + id +"\nLegemiddel: "+ legemiddel.hentNavn() + "\nLege: " + utskrivendeLege.hentNavn()+ "\nPasient ID:: " + pasientId + "\nReit: " + reit + "\nPris å betale: "+prisAaBetale());
    }
}
