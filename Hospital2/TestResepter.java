//Beskriver testprogram for resepter. Her oppretter jeg et objekt av hver av
//subklassene og utfører enkle enhetstester.
public class  TestResepter{
    public static void main(String[] args) {

        //oppretter objektene:
        BlåResepter blåResepter= new BlåResepter(new Vanlig("A",300,9),new Lege("Anna"),131313,1);
        Militærresepter militærresepter=new Militærresepter(new Narkotisk("B",200.50,2.4,4),new Lege("Per"),121212,1);
        P_resepter p_resepter= new P_resepter(new Vanedannende("C", 300,4.2,2),new Lege("Kristian"),141414);

        //sjekker at pasientId til pasientene er som forventet. Hvis de er som forventet,
        //skrives det ut at "Skriver ut riktige pasientId". Hvis en av pasientId er feil, skrives det ut at 
        //"Skriver ut feil passienId". Videre gjøres det samme med andre variablene, altså med 
        // id, reit, og metodene farge(),prisAaBetale() og bruk().
        if(blåResepter.hentPasientId()==131313 && militærresepter.hentPasientId()== 121212 && p_resepter.hentPasientId()==141414){
            System.out.println("Skriver ut riktige pasientId");
        }
        else{
            System.out.println("Skriver ut feil passienId");
        }

        if(blåResepter.farge()=="Blå" && militærresepter.farge()== "Hvit" && p_resepter.farge()=="Hvit"){
            System.out.println("Skriver ut riktige farger");
        }
        else{
            System.out.println("Skriver ut feil farger");
        }

        if(blåResepter.hentId()==0 && militærresepter.hentId()== 1 && p_resepter.hentId()==2){
            System.out.println("Skriver ut riktige id.");
        }
        else{
            System.out.println("Skriver ut feil id");
        }

        if(blåResepter.hentReit()==1 && militærresepter.hentReit()== 1 && p_resepter.hentReit()==3){
            System.out.println("Skriver ut riktige reit.");
        }
        else{
            System.out.println("Skriver ut feil reit");
        }

        if(blåResepter.prisAaBetale()==75 && militærresepter.prisAaBetale()== 0 && p_resepter.prisAaBetale()==192){
            System.out.println("Skriver ut riktige priser.");
        }
        else{
            System.out.println("Skriver ut feil priser");
        }

        if(blåResepter.bruk()==true && militærresepter.bruk()== true && p_resepter.bruk()==true){
            System.out.println("Reit er ikke tom (er større enn null)");
        }
        else{
            System.out.println("Reit er tom");
        }
    }
}
