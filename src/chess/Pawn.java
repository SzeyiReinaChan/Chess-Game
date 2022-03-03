package chess;

/** The type Pawn. */
public class Pawn extends AbstractPiece {
  private final int WHITESTARTROW;
  private final int BLACKSTARTROW;
  private final int SAMEDISTANCE;
  private final int WHITEONESTEP;
  private final int BLACKONESTEP;
  private final int WHITETWOSTEP;
  private final int BLACKTWOSTEP;

  /**
   * Instantiates a new Pawn.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Pawn(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
    this.WHITESTARTROW = 1;
    this.BLACKSTARTROW = 6;
    this.SAMEDISTANCE = 0;
    this.WHITEONESTEP = 1;
    this.BLACKONESTEP = -1;
    this.WHITETWOSTEP = 2;
    this.BLACKTWOSTEP = -2;

    if (this.color == Color.WHITE) {
      if (this.row < this.WHITESTARTROW || this.row > this.BOARDMAX) {
        throw new IllegalArgumentException("Invalid WHITE chess row input");
      }
    }

    if (this.color == Color.BLACK) {
      if (this.row > this.BLACKSTARTROW || this.row < this.BOARDMIN) {
        throw new IllegalArgumentException("Invalid BLACK chess row input");
      }
    }
  }

  /**
   * Check board range boolean.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  private boolean checkBoardRange(int row, int col) {
    return row <= this.BOARDMAX
        && row >= this.BOARDMIN
        && col <= this.BOARDMAX
        && col >= this.BOARDMIN;
  }

  /**
   * Check white piece boolean.
   *
   * @param rowDis the row distance
   * @param colDis the col distance
   * @return the boolean
   */
  private boolean checkWhitePiece(int rowDis, int colDis) {
    if (this.row == this.WHITESTARTROW
        && colDis == this.SAMEDISTANCE) { // if chess in the starting row
      if (rowDis == this.WHITEONESTEP
          || rowDis == this.WHITETWOSTEP) { // one or two moves are allowed
        return true;
      }
    } else if (this.row != this.WHITESTARTROW
        && colDis == this.SAMEDISTANCE) { // if chess not in the starting row
      if (rowDis == this.WHITEONESTEP) { // only one move allowed
        return true;
      }
    }
    return false;
  }

  /**
   * Check black piece boolean.
   *
   * @param rowDis the row distance
   * @param colDis the col distance
   * @return the boolean
   */
  private boolean checkBlackPiece(int rowDis, int colDis) {
    if (this.row == this.BLACKSTARTROW
        && colDis == this.SAMEDISTANCE) { // if chess in the starting row
      if (rowDis == this.BLACKONESTEP
          || rowDis == this.BLACKTWOSTEP) { // one or two moves are allowed
        return true;
      }
    } else if (this.row != this.BLACKSTARTROW
        && colDis == this.SAMEDISTANCE) { // if chess not in the starting row
      if (rowDis == this.BLACKONESTEP) { // only one move allowed
        return true;
      }
    }
    return false;
  }

  /**
   * This method overrides canMove of Parent.
   *
   * @param row the row
   * @param col the col
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row == this.row && col == this.column) {
      return false;
    }
    int rowDistance = row - this.row;
    int colDistance = col - this.column;

    if (checkBoardRange(row, col)) {
      if (this.color == Color.WHITE) {
        return checkWhitePiece(rowDistance, colDistance);
      } else if (this.color == Color.BLACK) {
        return checkBlackPiece(rowDistance, colDistance);
      }
    }
    return false;
  }

  /**
   * This method overrides canKill of Parent.
   *
   * @param piece the chess piece
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece.getColor() == this.color) {
      return false;
    }

    if (piece.getRow() <= this.BLACKSTARTROW
        && piece.getRow() >= this.WHITESTARTROW
        && piece.getColumn() <= this.BOARDMAX
        && piece.getColumn() >= this.BOARDMIN) {

      int rowDistance = piece.getRow() - this.row;
      int colDistance = piece.getColumn() - this.column;

      if (colDistance == this.BLACKONESTEP || colDistance == this.WHITEONESTEP) {
        if (rowDistance == this.BLACKONESTEP && this.color == Color.BLACK) {
          return true;
        } else if (rowDistance == this.WHITEONESTEP && this.color == Color.WHITE) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
}
