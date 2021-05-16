public class Tile {

  private Coordination coordination;
  private int value;
  private boolean merged = false;

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

  public void setValue(int value) {
    this.value = value;
  }

  public void merged() {
    this.merged = true;
  }

  public void notMerged() {
    this.merged = false;
  }

  public boolean getMerged() {
    return this.merged;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
