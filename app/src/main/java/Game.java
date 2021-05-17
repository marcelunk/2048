import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Game {

  private GameState gameState;

  public Game() {
    gameState = new GameState();
  }

  public void printGame() {
    System.out.println(this.gameState);
  }

  public void initializeGameBoard(BufferedReader reader) throws IOException {
    for(int row=0; row<4; row++) {
      String[] rowInput = reader.readLine().split(" ");
      for(int col=0; col<4; col++) {
        Coordination coordination = new Coordination(row, col);
        int value = Integer.parseInt(rowInput[col]);
        Tile tile = new Tile(value);
        gameState.setTile(coordination, tile);
      }
    }
  }

  public void executeMove(Move move) {
    gameState.executeMove(move);
  }

  public GameState getGameBoard() {
    return this.gameState;
  }


  public static void main(String[] args) {
    Game game = null;
    try {
      //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\marce\\Documents\\Programming\\Java\\Kattis\\2048\\app\\src\\main\\java\\8.in"));
      game = new Game();
      if(reader.ready()) {
        game.initializeGameBoard(reader);
        int moveInMove = Integer.parseInt(reader.readLine());
        Move move = getMove(moveInMove);
        game.executeMove(move);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    game.printGame();
  }

  private static Move getMove(int move) {
    switch(move) {
      case 0:
        return Move.Left;
      case 1:
        return Move.Up;
      case 2:
        return Move.Right;
      case 3:
        return Move.Down;
      default:
        return null;
    }
  }
}
