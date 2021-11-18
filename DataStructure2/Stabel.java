class Stabel<T> extends Lenkeliste<T>{
    public Stabel(){
        super();
    }

    public void leggPaa(T x){
        //legger til element på slutten av listen
        super.leggTil(this.stoerrelse(), x);
    }
    
    public T  taAv(){
        //fjerner element fra slutten av listen
        return super.fjern(this.stoerrelse()-1);
    }
}
