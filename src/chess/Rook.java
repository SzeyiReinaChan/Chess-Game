package chess;

/** The type Rook. */
public class Rook extends AbstractPiece {

  /**
   * Instantiates a new Rook.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Rook(int row, int column, Color color) {
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

      if (this.row == row || this.column == col) {
        return true;
      }
    }
    return false;
  }
}
