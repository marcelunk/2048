public class GameBoard {

  private Tile[][] gameBoard;

  public GameBoard() {
    this.gameBoard = new Tile[4][4];
  }

  public void setTile(Coordination coordination, Tile tile) {
    int row = coordination.getRow();
    int col = coordination.getCol();
    this.gameBoard[row][col] = tile;
  }

  public void executeMove(Direction direction) {
    this.gameBoard = direction.move(gameBoard);
    for(int row=0; row<4; row++) {
      for(int col=1; col<4; col++) {
        Tile tile = gameBoard[row][col];
        if(tile.getValue() > 0) {
          for(int left=col-1; left>=0; left--) {
            Tile tileOnLeft = gameBoard[row][left];
            if(tileOnLeft.getValue() == 0) {
              tileOnLeft.setValue(tile.getValue());
              Tile tileTemp = tileOnLeft;
              tile.setValue(0);
              tile = tileTemp;
            } else if(tileOnLeft.getValue() == tile.getValue()) {
              tileOnLeft.setValue(tileOnLeft.getValue()*2);
              Tile tileTemp = tileOnLeft;
              tile.setValue(0);
              tile = tileTemp;
            }
          }
        }
      }
    }
  }

  public Tile[][] getGameBoard() {
    return this.gameBoard;
  }

  public void printGameState() {
    StringBuilder builder = new StringBuilder();
    for(int row=0; row<4; row++) {
      for(int col=0; col<4; col++) {
        Tile tile = gameBoard[row][col];
        builder.append(tile + " ");
      }
      builder.deleteCharAt(builder.length()-1);
      builder.append("\n");
    }
    System.out.print(builder.toString());
  }
}
