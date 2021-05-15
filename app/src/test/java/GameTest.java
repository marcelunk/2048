import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class GameTest {

  private Game game;
  private Game gameSolution;

  @Before
  public void initGame() {
    this.game = new Game();
    String resourceName = "1.in";
    try {
      BufferedReader reader = readResourceFile(resourceName);
      game.initializeGameBoard(reader);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  @Before
  public void initGameSolution () {
    this.gameSolution = new Game();
    String resourceName = "1-Solution.in";
    try {
      BufferedReader reader = readResourceFile(resourceName);
      gameSolution.initializeGameBoard(reader);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  private BufferedReader readResourceFile(String resourceName) throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(resourceName).getFile());
    String absolutePath = file.getAbsolutePath();
    BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
    return reader;
  }

  @Test
  public void testGame() {
    this.game.executeMove(Move.Left);
    Tile[][] gameBoard = this.game.getGameBoard().getGameBoard();
    Tile[][] gameBoardSolution = this.gameSolution.getGameBoard().getGameBoard();
    for(int row=0; row<4; row++) {
      for(int col=0; col<4; col++) {
        Tile gameTile = gameBoard[row][col];
        Tile solutionTile = gameBoardSolution[row][col];
        assertEquals(gameTile.getValue(), solutionTile.getValue());
      }
    }
  }
}
