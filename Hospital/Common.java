public  class Common extends Medicine{
    int id;
    /** Class constructor
         * @param name sets the name of the medicine
         * @param price sets the price of the medicine
         * @param active_substance sets the active_substance of the medicine
         * @param strength sets the addictive strength of the medicine        
         */     
    public Common(String name, double price,double active_substance){
        super(name, price, active_substance);
        this.id=super.id;
        super.id++;
    }

 /**
     * overrinding the toString() method
     */
    public String toString() 
    { 
        return "ID:"+Integer.toString(this.id)+this.name + " " + Double.toString(this.price)  + " " + Double.toString(this.active_substance) ; 
    } 
       
}  