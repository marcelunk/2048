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

  public void executeMove(Move move) {
    setAllTilesNotMerged();
    this.gameBoard = move.execute(gameBoard);
  }

  public Tile[][] getGameBoard() {
    return this.gameBoard;
  }

  private void setAllTilesNotMerged() {
    for(int row=0; row<4; row++) {
      for(int col=0; col<4; col++) {
        gameBoard[row][col].setMerged(false);
      }
    }
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
