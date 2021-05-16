import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GameTest {

  private String boardResource;
  private String moveResource;
  private String solutionResource;
  private Game game;
  private Game gameSolution;
  private Move move;

  @Parameterized.Parameters
  public static Collection resources() {
     return Arrays.asList(new Object[][] {
        { "1.in", "1-Move.in", "1-Solution.in" },
        { "2.in", "2-Move.in", "2-Solution.in" },
        { "3.in", "3-Move.in", "3-Solution.in" },
        { "4.in", "4-Move.in", "4-Solution.in" },
        { "5.in", "5-Move.in", "5-Solution.in" },
        { "6.in", "6-Move.in", "6-Solution.in" }
     });
  }

  public GameTest(String board, String move, String solution) {
    this.boardResource = board;
    this.moveResource = move;
    this.solutionResource = solution;
  }

  @Before
  public void initGame() {
    this.game = new Game();
    try {
      BufferedReader boardReader = readResourceFile(boardResource);
      BufferedReader moveReader = readResourceFile(moveResource);
      this.move = getMove(Integer.parseInt(moveReader.readLine()));
      game.initializeGameBoard(boardReader);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  @Before
  public void initGameSolution() {
    this.gameSolution = new Game();
    try {
      BufferedReader reader = readResourceFile(solutionResource);
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

  private Move getMove(int move) {
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

  @Test
  public void testGame() {
    this.game.executeMove(this.move);
    assertEquals(this.gameSolution.getGameBoard().toString(), this.game.getGameBoard().toString());
  }
}
