//subklassen Spesialist arver egenskaper fra klassenn Lege.
//I tillegg, har den metoden hentKontrollID() som legger til ID til legen.
public class  Spesialist extends Lege implements Godkjenningsfritak{

    int kontrollID;
    
    public  Spesialist(String navn, int kontrollID){
        super(navn);
        this.kontrollID=kontrollID;
    }
    public int hentKontrollID(){
        return this.kontrollID;
    }

    //Overskriver toString() metoden for senere bruk i integerasjonstest.
    public String toString(){
		return("Spesialist navn: " + hentNavn() + "\nID: " + hentKontrollID());
	}
}