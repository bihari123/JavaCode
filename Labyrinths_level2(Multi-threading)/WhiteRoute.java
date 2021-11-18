class WhiteRoute extends Route{
    public WhiteRoute(int row,int col,Labyrinth labyrinth){
        super(row, col,labyrinth);
    }
    public char toCharacter(){
        return '.';
    }
}