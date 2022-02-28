package chess;

/** The type Abstract piece. */
public class AbstractPiece implements ChessPiece {
  /** The Row. */
  protected int row;

  /** The Column. */
  protected int column;

  /** The Color. */
  protected final Color color;

  /** The Board max. */
  protected final int BOARDMAX = 7;

  /** The Board min. */
  protected final int BOARDMIN = 0;

  /**
   * Instantiates a new Abstract piece.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractPiece(int row, int column, Color color) throws IllegalArgumentException {
    this.row = row;
    this.column = column;
    this.color = color;

    if (this.row > this.BOARDMAX || this.row < this.BOARDMIN) {
      throw new IllegalArgumentException("Invalid row input");
    }

    if (this.column > this.BOARDMAX || this.column < this.BOARDMIN) {
      throw new IllegalArgumentException("Invalid column input");
    }
  }

  /** This method overrides getRow() of Parent. */
  @Override
  public int getRow() {
    return this.row;
  }

  /** This method overrides getColumn() of Parent. */
  @Override
  public int getColumn() {
    return this.column;
  }

  /** This method overrides getColor() of Parent. */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * This method overrides canMove of Parent.
   *
   * @param row the row
   * @param col the column
   */
  @Override
  public boolean canMove(int row, int col) {
    return false;
  }

  /**
   * This method overrides canKill of Parent.
   *
   * @param piece piece from ChessPiece
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece.getColor() != this.color) {
      return canMove(piece.getRow(), piece.getColumn());
    }
    return false;
  }
}
