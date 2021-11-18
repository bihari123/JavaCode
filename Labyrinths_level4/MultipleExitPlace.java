class MultipleExitPlace extends Place{
    MultipleExitPlace right,left,forward;
    public MultipleExitPlace(String description){
        super(description);
        this.right=null;
        this.left=null;
        this.forward=null;
    }
    public MultipleExitPlace(){
        this.right=null;
        this.left=null;
        this.forward=null;
        this.description=null;
    }

    public MultipleExitPlace moveForward(){
        return this.forward;
    }

    public MultipleExitPlace moveLeft(){
        return this.left;
    }

    public MultipleExitPlace moveRight(){
        return this.right;
    }


}