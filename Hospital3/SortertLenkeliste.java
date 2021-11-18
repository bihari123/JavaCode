class SortertLenkeliste < T extends Comparable <T>> extends Lenkeliste <T> {
    public SortertLenkeliste(){
        super();
    }
    //Overskriver leggTil metoden fra superklassen
    @Override
    public void leggTil(T x) {

      Node nyNode = new Node(x);
      Node p =new Node();
      Node q =new Node();
      p=this.hode;
       if (super.stoerrelse() == 0) {
         this.hode = nyNode;
       }

       //sammenligne det nye elementet som skal legges til med alle eksisterende elementer, og plasserer det i stigende rekkefølge.
       else if (x.compareTo(this.hode.data) <= 0) {
           nyNode.neste=p;
           this.hode=nyNode;
           nyNode.neste=p;
       }

       else if (x.compareTo(this.hode.data) > 0) {

           while(p!= null){
              if(x.compareTo(p.data)>0){
                  q= p;
                  p=p.neste;

              }else{
                break;
              }
            }
            q.neste=nyNode;
            nyNode.neste=p;
        }
        //Linjen nede er ikke tilgjenglig fordi da blir output til "TestSortertLenkeliste"-filen ryddig/lettere å lese.
        //this.printListe();
      }

   @Override
   public T fjern() {

     Node p =this.hode;
     Node q = new Node();

   if (this.hode == null) {
       throw new UgyldigListeIndeks(-1);
   }

   if (hode.neste == null) {
       this.hode = null;
   }
   else {
       while (p.neste != null) {
          q=p;
          p=p.neste;
       }
       // fjerner det største elementet, dvs. det siste elementet
       q.neste = null;
   }
   return p.data;
   }

   @Override
   public void sett(int pos, T x) {
    throw new UnsupportedOperationException(); //deaktiverer metoden av superklassen.
}

  @Override
  public void leggTil(int pos, T x) {
   throw new UnsupportedOperationException(); //deaktiverer metoden av superklassen.
}
}
