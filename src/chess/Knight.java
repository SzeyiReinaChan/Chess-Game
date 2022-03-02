package chess;

/** The type Knight. */
public class Knight extends AbstractPiece {
  private final int VALIDDISTANCE1;
  private final int VALIDDISTANCE2;

  /**
   * Instantiates a new Knight.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Knight(int row, int column, Color color) {
    super(row, column, color);
    this.VALIDDISTANCE1 = 1;
    this.VALIDDISTANCE2 = 2;
  }

  /**
   * This method overrides canMove of Parent.
   *
   * @param row the row
   * @param col the column
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row == this.row && col == this.column) {
      return false;
    }
    if (row <= this.BOARDMAX
        && row >= this.BOARDMIN
        && col <= this.BOARDMAX
        && col >= this.BOARDMIN) {

      int rowDistance = Math.abs(this.row - row);
      int colDistance = Math.abs(this.column - col);

      if ((rowDistance == this.VALIDDISTANCE1 && colDistance == this.VALIDDISTANCE2)
          || (rowDistance == this.VALIDDISTANCE2 && colDistance == this.VALIDDISTANCE1)) {
        return true;
      }
    }
    return false;
  }
}
