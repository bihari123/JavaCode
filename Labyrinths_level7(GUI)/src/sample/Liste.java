package sample;

interface Liste < T > {
    /*public int size ();
    public void add( int pos , T x );
    public void add( T x );
    public void set ( int pos, T x );
    public T get( int pos );
    public T remove(int pos );
    public T remove();
*/

public int stoerrelse ();
    public void leggTil( int pos , T x );
    public void leggTil( T x );
    public void sett ( int pos, T x );
    public T hent( int pos );
    public T fjern(int pos );
    public T fjern();

}