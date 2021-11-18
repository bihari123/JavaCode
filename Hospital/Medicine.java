/**
     * The class Medicine.
     * contains sub-classes Narcotic,Addictive and Common.
     * @author Waleed Nasir
     */

    /**
     * A simp[le class which contains the information
     * about the parent class Medicine.
     *
     */
public abstract class Medicine{
     /**
    * @var int id stores the id of the medicine
    * @var string name stores the name of the medicine
    * @var double price contains the price
    * @var double active_substance contains the active substance containing in total
    * 
     */
    int id = 0;
    String name;
    double price;
    double active_substance;


/** Class constructor
         * @param name sets the name of the medicine
         * @param price sets the price of the medicine
         * @param active_substance sets the active_substance of the medicine        
         */    

    protected Medicine(String name, double price, double active_substance) {
        this.name = name;
        this.price = price;
        this.active_substance = active_substance;
        this.id = id;
        id++;
    }
/**
 *  getter method 
 * @return  id of the medice
 */
    public int getID() {
        return this.id;
    }
/**
 *  getter method 
 * @return  name of the medice
 */

    public String getName() {
        return this.name;
    }

/**
 *  getter method 
 * @return  price of the medice
 */


    public double getPrice() {
        return this.price;
    }

/**
 *  getter method 
 * @return  active substance of the medice
 */

    public double getActiveSubstance() {
        return this.active_substance;
    }
  
    /**
     * A function setNewPrice
     * @param new_price String
     * update the price of the medicine
     */    
    public void setNewPrice(double new_price) {
        this.price = new_price;
        System.out.println("Price has been successfully updated");
    }
    
    /**
     * overrinding the toString() method
     */
    public String toString() 
    { 
        return "ID:"+Integer.toString(this.id)+" "+this.name + " " + Double.toString(this.price)  + " " + Double.toString(this.active_substance) ; 
    } 
    
}
