import org.junit.Test;
import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void testLeft() {
      Coordination coord = null;
      coord = Direction.Left.move(new Coordination(0, 0));
      assertEquals(0, coord.getRow());
      assertEquals(0, coord.getCol());
      coord = Direction.Left.move(new Coordination(0,3));
      assertEquals(0, coord.getRow());
      assertEquals(2, coord.getCol());
    }

    @Test
    public void testUp() {
      Coordination coord = null;
      coord = Direction.Up.move(new Coordination(0, 0));
      assertEquals(coord.getRow(), 0);
      assertEquals(coord.getCol(), 0);
      coord = Direction.Up.move(new Coordination(3, 0));
      assertEquals(coord.getRow(), 2);
      assertEquals(coord.getCol(), 0);
    }

    @Test
    public void testRight() {
      Coordination coord = null;
      coord = Direction.Right.move(new Coordination(0, 0));
      assertEquals(coord.getRow(), 0);
      assertEquals(coord.getCol(), 1);
      coord = Direction.Right.move(new Coordination(0, 3));
      assertEquals(coord.getRow(), 0);
      assertEquals(coord.getCol(), 3);
    }

    @Test
    public void testDown() {
      Coordination coord = null;
      coord = Direction.Down.move(new Coordination(0, 0));
      assertEquals(coord.getRow(), 1);
      assertEquals(coord.getCol(), 0);
      coord = Direction.Down.move(new Coordination(3, 0));
      assertEquals(coord.getRow(), 3);
      assertEquals(coord.getCol(), 0);
    }
}
