class Lenkeliste <T> implements Liste<T>{
    Node hode;
    public Lenkeliste(){
        hode = null;
    }

    // oppretter klassen Node
     public class Node{
         public T data ;
         public Node neste;

         public Node(T x){
            data=x;
            neste=null;
         }

         public Node(){
            data=null;
            neste=null;
         }
     }

      // adderer noden på slutten
     public void leggTil(T x){

         Node p,q,nyNode;
         q=new Node();
         nyNode=new Node(x);

         if (nyNode == null){
             System.out.println("Minnefeil");
         }

         p= this.hode;
         //hvis listen er tom, adder den til hode
         if(this.hode == null){
             this.hode= nyNode;
         }

         //gå til siste noden
         else{
             while(p!= null){
                q=p;
                p=p.neste;
             }
             q.neste = nyNode;
             nyNode.neste=p;
         }
     }

     //legg til på spesifikk posisjon.
     public void leggTil(int pos, T x){

        if (pos < 0 || pos > this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
		}
        int k=0;
        Node p,q,nyNode;
        q=new Node();
        nyNode=new Node(x);
        if (nyNode == null){
            System.out.println("Minnefeil");
        }

        p= this.hode;

        if(pos==0){
            nyNode.neste=p;
            this.hode=nyNode;
        }else{
            //transverserer til noden på spesifisert posisjon
            while(p!= null && k<pos){
                k++;
                q=p;
                p=p.neste;
            }
            q.neste=nyNode;
            nyNode.neste=p;
        }
     }

     //erstatte noden i den gitte posisjonen
     public void sett(int pos, T x){

        if (pos < 0 || pos >= this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
		}
        int k=0;
        Node p,q,nyNode;
        q=new Node();
        nyNode=new Node(x);
        if (nyNode == null){
            System.out.println("Minnefeil");
        }

        p= this.hode;

        if(pos == 0){
            nyNode.neste=p;
            nyNode.neste=this.hode.neste;
            this.hode=nyNode;

        }else{
            //transverserer til noden på spesifisert posisjon
            while(p!= null && k<pos){
            k++;
            q=p;
            p=p.neste;
            }
            q.neste=nyNode;
            nyNode.neste=p.neste;
         }
     }

     public T fjern(){

      Node p=this.hode;
      if(this.hode == null){
          //Linjen nede er ikke tilgjenglig fordi da blir output til "TestLenkliste"-filen ryddig/lettere å lese.
          //System.out.println("Listen er tom");
          throw new UgyldigListeIndeks(-1);
      }
      else{
          //slett hode
          this.hode= this.hode.neste;

      }
      return p.data;
     }

     public T fjern(int pos){

        if (pos < 0 || pos >= this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
		}

        int k=0;
        Node q= new Node();
        Node p=this.hode;
        if(this.hode == null){
            System.out.println("Listen er tom");
        }

        else if(pos==0){
            if(this.hode == null){
                System.out.println("Listen er tom");
                throw new UgyldigListeIndeks(-1);
            }
            else{
                //slett hode
                this.hode= this.hode.neste;
            }
            return p.data;
        }

        else{
            //gå til den spesifikke posisjon.
            while(p.neste!=null&& (k<pos)){
                k++;
                q=p;
                p=p.neste;
            }
                if(p==null){
                    System.out.println("Posisjon eksisterer ikke");
                }
                else{
                    //fjernet det midterste elementet
                    q.neste=p.neste;
                }
        }
        return p.data;
       }


     public int stoerrelse(){
         int teller =0;
         Node naavaerende= this.hode;

         //telle til null
         while(naavaerende!=null){
             teller++;
             naavaerende=naavaerende.neste;
         }
        return teller;
     }

     public T hent(int pos) {
         int k=0;
         //Linjen nede er ikke tilgjenglig fordi da blir output til "TestLenkliste"-filen ryddig/lettere å lese.
         //this.printListe();
         if (pos < 0 || pos >= this.stoerrelse()) {
			throw new UgyldigListeIndeks(pos);
		}

         Node p=new Node();
         p=this.hode;
         if(this.hode == null){
             System.out.println("Listen er tom");
         }
         else{
             if(pos==(this.stoerrelse())){
                while(p.neste!=null){
                    p=p.neste;
                   }

             }else{
                while(p.neste!=null&& k<pos){
                    //Linjen nede er ikke tilgjenglig fordi da blir output til "TestLenkliste"-filen ryddig/lettere å lese.
                    //System.out.println("hei");
                    k++;
                    p=p.neste;
                   }
             }
             }
         return p.data;
     }


     public  void printListe()
     {
         Node naaNode = this.hode;

  //Linjen nede er ikke tilgjenglig fordi da blir output til "TestLenkliste"-filen ryddig/lettere å lese.
         //System.out.print("Lenkeliste: ");

         // Går gjennom Lenkeliste
         while (naaNode != null) {

             // Skriver ut data på naavaerende node
             System.out.print(naaNode.data + " ");

             // Går til neste node
             naaNode = naaNode.neste;
         }
          System.out.print( "\n");
     }
}
