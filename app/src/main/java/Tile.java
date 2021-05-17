public class Tile {

  private int value;
  private boolean merged = false;

  public Tile(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setMerged(boolean merged) {
    this.merged = merged;
  }

  public boolean getMerged() {
    return this.merged;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }

  @Override
  public boolean equals(Object other) {
    if(!(other instanceof Tile)) {
      return false;
    }
    Tile otherTile = (Tile) other;
    return (this.value == otherTile.getValue());
  }

  @Override
  public int hashCode() {
    String value = String.valueOf(this.value);
    return value.hashCode();
  }
}
