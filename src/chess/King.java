package chess;

/** The type King. */
public class King extends AbstractPiece {
  private final int SAMEDISTANCE;
  private final int VALIDDISTANCE;

  /**
   * Instantiates a new King.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public King(int row, int column, Color color) {
    super(row, column, color);
    this.SAMEDISTANCE = 0;
    this.VALIDDISTANCE = 1;
  }

  /**
   * This method overrides canMove of Parent.
   *
   * @param row the row
   * @param col the column
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row == getRow() && col == this.column) {
      return false;
    }
    if (row <= this.BOARDMAX
        && row >= this.BOARDMIN
        && col <= this.BOARDMAX
        && col >= this.BOARDMIN) {
      int rowDistance = Math.abs(this.row - row);
      int colDistance = Math.abs(this.column - col);
      if (rowDistance == this.VALIDDISTANCE && colDistance == this.VALIDDISTANCE
          || rowDistance == this.VALIDDISTANCE && colDistance == this.SAMEDISTANCE
          || colDistance == this.VALIDDISTANCE && rowDistance == this.SAMEDISTANCE) {
        return true;
      }
    }
    return false;
  }
}
