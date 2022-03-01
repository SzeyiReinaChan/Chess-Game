package chess;

/** The type Queen. */
public class Queen extends AbstractPiece {

  /**
   * Instantiates a new Queen.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Queen(int row, int column, Color color) {
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
      if (rowDistance == colDistance || this.row == row || this.column == col) {
        return true;
      }
    }
    return false;
  }
}
