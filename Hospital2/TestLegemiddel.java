//Beskriver testprogram for legemiddel. Her oppretter jeg et objekt av hver av
//subklassene og utfører enkle enhetstester.
public class TestLegemiddel {
    public static void main(String[] args) {

        //oppretter objektene:
        
        Narkotisk a=new Narkotisk("Narkotisk",150.50,7.8,2);
        Vanedannende b=new Vanedannende("Vanedannende",300.50,2.8,3);
        Vanlig c=new Vanlig("Vanlig",199.50,5.5);

        //sjekker at navnene til legemiddel er som forventet. Hvis de er som forventet,
        //skrives det ut at navnene er riktige. Hvis en av navn er feil, skrives det ut at 
        //navn er ikke riktig. Videre gjøres det samme med andre variablene, altså med 
        // pris,virkestoff,og styrke.
        if (a.hentNavn() == "Narkotisk" && b.hentNavn() == "Vanedannende" && c.hentNavn() == "Vanlig"){
            System.out.println("Navnene er riktige, som forventet.");
        }
        else{
            System.out.println("Navnene er ikke riktige som forventet.");
        }

        if (a.hentPris() == 150.5 && b.hentPris() == 300.50 && c.hentPris() == 199.50){
            System.out.println("Prisene er riktige, som forventet.");
        }
        else{
            System.out.println("Prisene er ikke riktige som forventet.");
        }

        if (a.hentVirkestoff() == 7.8 && b.hentVirkestoff() == 2.8 && c.hentVirkestoff() == 5.5){
            System.out.println("Virkestoff-mengde er riktige, som forventet.");
        }
        else{
            System.out.println("Virkestoff-mengde er ikke riktige som forventet.");
        }

        a.settNyPris(100.50);
        if(a.hentPris() == 100.50){
            System.out.println("Prisen har blitt endret til: " + a.hentPris());
        }
        else{
            System.out.println("Prisen ble ikke endret");
        }

        b.settNyPris(400.50);
        if(b.hentPris() == 400.50){
            System.out.println("Prisen har blitt endret til: " + b.hentPris());
        }
        else{
            System.out.println("Prisen ble ikke endret");
        }

        c.settNyPris(200.50);
        if(c.hentPris() == 200.50){
            System.out.println("Prisen har blitt endret til: " + c.hentPris());
        }
        else{
            System.out.println("Prisen ble ikke endret");
        }

        if (a.hentNarkotiskStyrke() == 2 && b.hentVanedannendeStyrke() == 3) {
            System.out.println("Styrke er riktig, som forventet.");
        }
        else{
            System.out.println("Styrke er ikke riktig som forventet.");
        }
    }
}
