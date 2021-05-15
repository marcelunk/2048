import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Game {

  private GameBoard gameBoard;

  public Game() {
    gameBoard = new GameBoard();
  }

  public void printGame() {
    this.gameBoard.printGameState();
  }

  public void initializeGameBoard(BufferedReader reader) throws IOException {
    for(int row=0; row<4; row++) {
      String[] rowInput = reader.readLine().split(" ");
      for(int col=0; col<4; col++) {
        Coordination coordination = new Coordination(row, col);
        int value = Integer.parseInt(rowInput[col]);
        Tile tile = new Tile(coordination, value);
        gameBoard.setTile(coordination, tile);
      }
    }
  }

  public void executeMove(Direction direction) {
    gameBoard.executeMove(direction);
  }


  public static void main(String[] args) {
    Game game = null;
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      game = new Game();
      if(reader.ready()) {
        game.initializeGameBoard(reader);
        int moveInDirection = Integer.parseInt(reader.readLine());
        Direction direction = getDirection(moveInDirection);
        game.executeMove(direction);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    game.printGame();
  }

  private static Direction getDirection(int direction) {
    switch(direction) {
      case 0:
        return Direction.Left;
      case 1:
        return Direction.Up;
      case 2:
        return Direction.Right;
      case 3:
        return Direction.Down;
      default:
        return null;
    }
  }
}
