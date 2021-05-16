// add compareTo method to the class

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
}
