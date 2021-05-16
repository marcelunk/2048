import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

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
        Tile tile = new Tile(value);
        gameBoard.setTile(coordination, tile);
      }
    }
  }

  public void executeMove(Direction move) {
    gameBoard.executeMove(move);
  }

  public GameBoard getGameBoard() {
    return this.gameBoard;
  }


  public static void main(String[] args) {
    Game game = null;
    try {
      //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\marce\\Documents\\Programming\\Java\\Kattis\\2048\\app\\src\\main\\java\\8.in"));
      game = new Game();
      if(reader.ready()) {
        game.initializeGameBoard(reader);
        game.printGame();
        System.out.println("-----");
        Direction direction = getDirection(Integer.parseInt(reader.readLine()));
        game.executeMove(direction);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    game.printGame();
  }

  private static Direction getDirection(int move) {
    switch(move) {
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
