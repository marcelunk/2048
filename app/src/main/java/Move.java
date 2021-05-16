public enum Move {
  Left {
    Tile[][] execute(Tile[][] gameBoard) {
      for(int row=0; row<4; row++) {
        for(int col=1; col<4; col++) {
          Tile tile = gameBoard[row][col];
          if(tile.getValue() > 0) {
            for(int left=col-1; left>=0; left--) {
              Tile nextTile = gameBoard[row][left];
              tile = swapTiles(tile, nextTile);
              if(tile == null) {
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
              Tile nextTile = gameBoard[top][col];
              tile = swapTiles(tile, nextTile);
              if(tile == null) {
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
              Tile nextTile = gameBoard[row][right];
              tile = swapTiles(tile, nextTile);
              if(tile == null) {
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
              Tile nextTile = gameBoard[below][col];
              tile = swapTiles(tile, nextTile);
              if(tile == null) {
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

  private static Tile swapTiles(Tile tile, Tile nextTile) {
    if(nextTile.getValue() == 0) {
      nextTile.setValue(tile.getValue());
      tile.setValue(0);
      return nextTile;
    } else if(tile.getValue() == nextTile.getValue() && !nextTile.getMerged()) {
      nextTile.setValue(tile.getValue()*2);
      nextTile.setMerged(true);
      tile.setValue(0);
      return null;
    } else {
      return null;
    }
  }
}
