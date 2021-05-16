public enum Move {
  Left {
    Tile[][] execute(Tile[][] gameBoard) {
      for(int row=0; row<4; row++) {
        for(int col=1; col<4; col++) {
          Tile tile = gameBoard[row][col];
          if(tile.getValue() > 0) {
            for(int left=col-1; left>=0; left--) {
              Tile tileOnLeft = gameBoard[row][left];
              boolean breakLoop = swapTiles(tile, tileOnLeft);
              if(breakLoop) {
                break;
              }
            }
          }
        }
      }
      return gameBoard;
    }
  },
  Up {
    Tile[][] execute(Tile[][] gameBoard) {
      for(int col=0; col<4; col++) {
        for(int row=1; row<4; row++) {
          Tile tile = gameBoard[row][col];
          if(tile.getValue() > 0) {
            for(int top=row-1; top>=0; top--) {
              Tile tileOnTop = gameBoard[top][col];
              if(tileOnTop.getValue() == 0) {
                tileOnTop.setValue(tile.getValue());
                Tile tileTemp = tileOnTop;
                tile.setValue(0);
                tile = tileTemp;
              } else if(tileOnTop.getValue() == tile.getValue() && !tileOnTop.getMerged()) {
                tileOnTop.setValue(tileOnTop.getValue()*2);
                Tile tileTemp = tileOnTop;
                tile.setValue(0);
                tile = tileTemp;
                tile.setMerged(true);
                break;
              } else {
                break;
              }
            }
          }
        }
      }
      return gameBoard;
    }
  },
  Right {
    Tile[][] execute(Tile[][] gameBoard) {
      for(int row=3; row>=0; row--) {
        for(int col=2; col>=0; col--) {
          Tile tile = gameBoard[row][col];
          if(tile.getValue() > 0) {
            for(int right=col+1; right<4; right++) {
              Tile tileOnRight = gameBoard[row][right];
              if(tileOnRight.getValue() == 0) {
                tileOnRight.setValue(tile.getValue());
                Tile tileTemp = tileOnRight;
                tile.setValue(0);
                tile = tileTemp;
              } else if(tileOnRight.getValue() == tile.getValue() && !tileOnRight.getMerged()) {
                tileOnRight.setValue(tileOnRight.getValue()*2);
                Tile tileTemp = tileOnRight;
                tile.setValue(0);
                tile = tileTemp;
                tile.setMerged(true);
                break;
              } else {
                break;
              }
            }
          }
        }
      }
      return gameBoard;
    }
  },
  Down {
    Tile[][] execute(Tile[][] gameBoard) {
      for(int col=0; col<4; col++) {
        for(int row=2; row>=0; row--) {
          Tile tile = gameBoard[row][col];
          if(tile.getValue() > 0) {
            for(int below=row+1; below<4; below++) {
              Tile tileBelow = gameBoard[below][col];
              if(tileBelow.getValue() == 0) {
                tileBelow.setValue(tile.getValue());
                Tile tileTemp = tileBelow;
                tile.setValue(0);
                tile = tileTemp;
              } else if(tileBelow.getValue() == tile.getValue()&& !tileBelow.getMerged()) {
                tileBelow.setValue(tileBelow.getValue()*2);
                Tile tileTemp = tileBelow;
                tile.setValue(0);
                tile = tileTemp;
                tile.setMerged(true);
                break;
              } else {
                break;
              }
            }
          }
        }
      }
      return gameBoard;
    }
  };

  abstract Tile[][] execute(Tile[][] gameBoard);

  private static boolean swapTiles(Tile tile, Tile nextTile) {
    if(nextTile.getValue() == 0) {
      Tile tempTile = tile;
      tile = nextTile;
      tile.setValue(tempTile.getValue());
      tempTile.setValue(0);
      return false;
    } else if(tile.getValue() == nextTile.getValue() && !nextTile.getMerged()) {
      Tile tempTile = tile;
      tile = nextTile;
      tile.setValue(tempTile.getValue()*2);
      tempTile.setValue(0);
      tile.setMerged(true);
      return false;
    } else {
      return true;
    }
  }

}
