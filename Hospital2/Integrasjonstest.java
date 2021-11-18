//tester hvordan de forskjellige delene av systemet fungerer sammen
class Integrasjonstest{
    public static void main(String[] args) {
        //Oppretter en instans av hver eneste klasse:

        //instans av hvert legemiddel.
        Vanlig vanlig=new Vanlig("Vanlig",98.5,3.5);
        Vanedannende vanedannende=new Vanedannende("Vanedannende",150.50,3.5,2);
        Narkotisk narkotisk = new Narkotisk ("Narkotisk",150.5,1.4,1);

        //oppretter lege  og spesialist.
        Lege sara=new Lege("Sara");
        Spesialist oyvind=new Spesialist("oyvind", 10101);

        //instans av hver resept.
        Militærresepter militærresepter=new Militærresepter(vanlig,sara,181818,4);
        P_resepter p_resepter=new P_resepter(vanedannende,sara,191919);
        BlåResepter blåResepter=new BlåResepter(narkotisk,oyvind,202020,3);

        //skriver ut informasjon om legemiddler.
        System.out.println(vanlig + "\n");
        System.out.println(vanedannende + "\n");
        System.out.println(narkotisk + "\n");

        //skriver ut informasjon om leger.
        System.out.println(sara + "\n");
        System.out.println(oyvind + "\n");

        //skriver ut informasjon om resepter.
        System.out.println(militærresepter + "\n");
        System.out.println(p_resepter + "\n");
        System.out.println(blåResepter + "\n");

    }
}