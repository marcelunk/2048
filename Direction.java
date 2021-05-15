public enum Direction {
  Left {
    Coordination move(Coordination coord) {
      int newRow = moveIsLegal(coord.getRow()-1) ? coord.getRow()-1 : coord.getRow();
      int newCol = coord.getCol();
      return new Coordination(newRow, newCol);
    }
  },
  Up {
    Coordination move(Coordination coord) {
      int newRow = coord.getRow();
      int newCol = moveIsLegal(coord.getCol()-1) ? coord.getCol()-1 : coord.getCol();
      return new Coordination(newRow, newCol);
    }
  },
  Right {
    Coordination move(Coordination coord) {
      int newRow = moveIsLegal(coord.getRow()+1) ? coord.getRow()+1 : coord.getRow() ;
      int newCol = coord.getCol();
      return new Coordination(newRow, newCol);
    }
  },
  Down {
    Coordination move(Coordination coord) {
      int newRow = coord.getRow();
      int newCol = moveIsLegal(coord.getCol()+1) ? coord.getCol()+1 : coord.getCol();
      return new Coordination(newRow, newCol);
    }
  };

  abstract Coordination move(Coordination coord);

  private static boolean moveIsLegal(int coordination) {
    return (coordination >= 0 && coordination < 4);
  }
}
