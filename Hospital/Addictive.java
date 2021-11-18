public class Addictive extends Medicine{
     /**
    * @var int id stores the id of the medicine
    * @var int strength stores the addictive strength of the medicine
     */
    
    int strength;
    int id;
    
    /** Class constructor
         * @param name sets the name of the medicine
         * @param price sets the price of the medicine
         * @param active_substance sets the active_substance of the medicine
         * @param strength sets the addictive strength of the medicine        
         */    

    public Addictive(String name, double price,double active_substance, int strength){
        super(name,price,active_substance);
        this.strength=strength;
        this.id=super.id;
        super.id++;
    }

    /**
 * getter method
 * @return the strength of the addictive medicine
 */

    public int getAddictiveStrength(){
        return this.strength;
    }

 /**
     * overrinding the toString() method
     */
    public String toString() 
    { 
        return "ID:"+Integer.toString(this.id)+" "+this.name + " " + Double.toString(this.price)  + " " + Double.toString(this.active_substance) ; 
    } 
       
}