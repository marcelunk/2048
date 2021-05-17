public enum Move {
  Left {

    private Tile[][] gameState;

    Tile[][] execute(Tile[][] gameState) {
      this.gameState = gameState;
      for(int row=0; row<4; row++) {
        for(int col=1; col<4; col++) {
          Tile tile = gameState[row][col];
          executeOneTile(tile, col, row);
        }
      }
      return gameState;
    }

    private void executeOneTile(Tile tile, int col, int row) {
      if(tile.getValue() > 0) {
        for(int left=col-1; left>=0; left--) {
          Tile nextTile = this.gameState[row][left];
          tile = moveTile(tile, nextTile);
          if(tile == null) {
            break;
          }
        }
      }
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
              tile = moveTile(tile, nextTile);
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
              tile = moveTile(tile, nextTile);
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
              tile = moveTile(tile, nextTile);
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

  private static Tile moveTile(Tile tile, Tile nextTile) {
    if(positionIsEmpty(nextTile)) {
      moveTileOneStep(tile, nextTile);
      return nextTile;
    } else if(areMergeable(tile, nextTile)) {
      mergeTiles(tile, nextTile);
      return null;
    } else {
      return null;
    }
  }

  private static boolean positionIsEmpty(Tile nextTile) {
    return nextTile.getValue() == 0;
  }

  private static void moveTileOneStep(Tile tile, Tile nextTile) {
    nextTile.setValue(tile.getValue());
    tile.setValue(0);
  }

  private static boolean areMergeable(Tile tile, Tile nextTile) {
    return (tile.equals(nextTile) && !nextTile.getMerged());
  }

  private static void mergeTiles(Tile tile, Tile nextTile) {
    nextTile.setValue(tile.getValue()*2);
    nextTile.setMerged(true);
    tile.setValue(0);
  }
}
