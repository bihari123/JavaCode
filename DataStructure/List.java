interface List < T > {
    public int size ();
    public void add( int pos , T x );
    public void add( T x );
    public void set ( int pos, T x );
    public T get( int pos );
    public T remove(int pos );
    public T remove();
    }