//Beskriver klassen Resept som har subklassene blåresepter og hviteresepter.
public abstract class Resepter{
    public static int teller = 0; //øker indeksen til id for å gi en ny resept en ny id.
    protected int id ;  //lagrer id til resept.
    protected Legemiddel legemiddel; //referanse til et legemiddel
    protected Lege utskrivendeLege; //referanse til den legen som har skrevet ut resepten
    protected int pasientId; // ID-en til den pasienten som eier resepten
    protected int reit; //antall ganger som er igjen på resepten

    // Konstruktøren defineres.
    public Resepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        this.legemiddel=legemiddel;
        this.utskrivendeLege=utskrivendeLege;
        this.pasientId=pasientId;
        this.reit=reit;
        this.id=teller++;
    }

    //skriver metoder som henter relevant data: hentId, hentLegemiddel (henter tilhørende Legemiddel),
    // hentLege (henter utskrivende Lege), hentPasientId og hentReit.
     public int hentId() {
        return this.id;
    }

    public int hentPasientId() {
        return this.pasientId;
    }

    public int hentReit() {
        return this.reit;
    }

    public Legemiddel hentLegemiddel(){
        return this.legemiddel;
    }

    public Lege hentLege(){
        return this.utskrivendeLege;
    }

    //Skriver metoden bruk() som retunerer False om resepten alt er oppbrukt,
    //ellers returnerer den true.
    public boolean bruk(){
        if (this.reit == 0){
            return false;
        }
        else{
            return true;
        }
    }

    abstract public String farge ();  // Returnerer reseptens farge.
    abstract public double prisAaBetale(); //Returnerer prisen pasienten må betale.
}
