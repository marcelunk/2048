public class Tile {

  private Coordination coordination;
  private int value;

  public Tile(Coordination coordination, int value) {
    this.coordination = coordination;
    this.value = value;
  }

  public Coordination getCoordination() {
    return this.coordination;
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
