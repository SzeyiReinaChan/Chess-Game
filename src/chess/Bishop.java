package chess;

/** The type Bishop. */
public class Bishop extends AbstractPiece {

  /**
   * Instantiates a new Bishop.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Bishop(int row, int column, Color color) {
    super(row, column, color);
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
      if (rowDistance == colDistance) {
        return true;
      }
    }
    return false;
  }
}
