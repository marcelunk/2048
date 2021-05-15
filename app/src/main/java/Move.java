public enum Move {
  Left {
    GameBoard move(GameBoard gameBoard) {
      for(int row=0; row<4; row++) {
        for(int col=1; col<4; col++) {
          Tile tile = gameBoard[row][col];
          if(tile.getValue() > 0) {
            for(int left=col-1; left>=0; left--) {
              Tile tileOnLeft = gameBoard[row][left];
              if(tileOnLeft.getValue() == 0) {
                tileOnLeft.setValue(tile.getValue());
                Tile tileTemp = tileOnLeft;
                tile.setValue(0);
                tile = tileTemp;
              } else if(tileOnLeft.getValue() == tile.getValue()) {
                tileOnLeft.setValue(tileOnLeft.getValue()*2);
                Tile tileTemp = tileOnLeft;
                tile.setValue(0);
                tile = tileTemp;
              }
            }
          }
        }
      }
      return gameBoard;
    }
  };
/*
  Up {
    Coordination move(Coordination coord) {
      int newRow = moveIsLegal(coord.getRow()-1) ? coord.getRow()-1 : coord.getRow();
      int newCol = coord.getCol();
      return new Coordination(newRow, newCol);
    }
  },
  Right {
    Coordination move(Coordination coord) {
      int newRow = coord.getRow();
      int newCol = moveIsLegal(coord.getCol()+1) ? coord.getCol()+1 : coord.getCol() ;
      return new Coordination(newRow, newCol);
    }
  },
  Down {
    Coordination move(Coordination coord) {
      int newRow = moveIsLegal(coord.getRow()+1) ? coord.getRow()+1 : coord.getRow();
      int newCol = coord.getCol();
      return new Coordination(newRow, newCol);
    }
  };
*/

  abstract GameBoard move(GameBoard gameBoard);
}
