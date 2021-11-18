//Beskriver klassen Legemiddel, som består av subklassene: Narkotisk, Vanedannende, eller Vanlig.

public abstract class Legemiddel {
    protected int id;   //lagrer id til legemiddel.
    public static int teller = 0;  //øker indeksen til id for å gi et nytt legemiddel en ny id.
    protected String navn; //lagrer navnet til legemiddel.
    protected double pris; //prisen til legemiddel.
    protected double virkestoff; //innhold av virkestoff i legemiddel.

    //Konstruktør defineres:
    public Legemiddel(String navn, double pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id = teller++;
    }

    //skriver metodene hentId, hentNavn, hentPris, hentVirkestoff, settNyPris som returnerer
    //de relevante verdiene.

    public int hentId() {
        return id;
    }

    public String hentNavn() {
        return navn;
    }

    public double hentPris() {
        return pris;
    }

    public double hentVirkestoff() {
        return virkestoff;
    }

    public void settNyPris(double ny_pris) {
        pris= ny_pris;
    }
}
