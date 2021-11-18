class Stack<T> extends LinkedList<T>{
    public Stack(){
        super();
    }

    public void Addon(T x){
        super.add(this.size(), x);
    }
    public T removeoff(){
        return super.remove(this.size()-1);
    }
}