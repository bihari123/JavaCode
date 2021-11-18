class BlackRoute extends Route{
    public BlackRoute(int row,int col,Labyrinth labyrinth){
        super(row, col,labyrinth);
    }
    public char toCharacter(){
        return '#';
    }
/*
    @Override
    public void findRoute(){
        return;
    }
*/

}