class Stabel<T> extends Lenkeliste<T>{
    public Stabel(){
        super();
    }

    public void leggPaa(T x){ 
        super.leggTil(this.stoerrelse(), x); // adding element at the end of the list
    }
    public T taAv(){
        return super.fjern(this.stoerrelse()-1);// removing element at the end of the list
    }
}