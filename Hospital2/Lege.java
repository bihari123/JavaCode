//Beskriver klassen lege.
public class Lege{
	
	String navn; //navnet til legen

	//Konstruktøren defineres
    public Lege(String navn){
        this.navn= navn;
    }

	//retunerer navnet til legen
    public String hentNavn(){
        return this.navn;
    }

	//Overskriver toString() metoden for senere bruk i integerasjonstest.
	public String toString(){
		return("Lege navn: " + hentNavn());
	}
}
