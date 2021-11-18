import java.io.FileNotFoundException;

public class Place {
    String description;
    TreasureChest treasureChest;
    Place next;

    public Place(String description) {
        this.description = description;
        this.next = null;
    }
    public Place() {
        this.description = null;
        this.next = null;
    }
    public void placeTreasure() throws FileNotFoundException {
        this.treasureChest=new TreasureChest();
    }

    public TreasureChest getTreasure(){
        return this.treasureChest;
    }

    public Place moveForward(){
        return this.next;
    }

    public String toString(){
        return this.description;
    }
}