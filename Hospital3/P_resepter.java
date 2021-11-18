//subklassen P_resepter arver egenskaper fra klassene HviteResepter og Resepter.
//I tillegg, har den metoden prisAaBetale() som legger til pris å betale.
class P_resepter extends HviteResepter{

    public P_resepter(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
        super(legemiddel, utskrivendeLege, pasient,3);
    }

    public double prisAaBetale() {
        double pris= (legemiddel.hentPris()-108); //trekker fra 108 fordi brukeren betaler 108 kroner mindre for legemiddelet.

        //Brukeren kan aldri betale mindre enn 0 kroner, alltså pris kan ikke være negativ, derfor behøver vi å bruke en løkke her.
        if(pris >= 0){
            return pris;
        }
        else{
            return 0;
        }
	}

    //Overskriver toString() metoden for senere bruk i integerasjonstest.
    public String toString()
    {
        return ("P_resept ID: " + id +"\nLegemiddel: "+ legemiddel.hentNavn() + "\nLege: " + utskrivendeLege.getName()+ "\nPasient ID:: " + pasient + "\nReit: " + reit + "\nPris å betale: "+prisAaBetale());
    }
}
