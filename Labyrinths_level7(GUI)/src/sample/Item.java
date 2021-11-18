package sample;

public class Item {
    String name;
    int value;

    public Item(String name,int value){
        this.name=name;
        this.value=value;   
    }

    String getName(){
        return this.name;
    }

    int getValue(){
        return this.value;
    }
    public String toString(){
        return this.name;
    }
}