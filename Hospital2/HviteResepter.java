//subklassen HviteResepter arver egenskaper fra klassen  Resepter.
//I tillegg, har den metoder farge() og prisAaBetale() som legger til
//farge og pris å betale.
public class HviteResepter extends Resepter{

    public HviteResepter(Legemiddel legemiddel,Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel,utskrivendeLege,pasientId,reit);
    }

    public String farge(){
        return "Hvit";
    }

    public double prisAaBetale(){
        return this.legemiddel.hentPris();
    }
}
