package chess;

/** The interface Chess piece. */
public interface ChessPiece {
  /**
   * Gets row.
   *
   * @return the row
   */
  int getRow();

  /**
   * Gets column.
   *
   * @return the column
   */
  int getColumn();

  /**
   * Gets color.
   *
   * @return the color
   */
  Color getColor();

  /**
   * Can move boolean.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  boolean canMove(int row, int col);

  /**
   * Can kill boolean.
   *
   * @param piece the piece
   * @return the boolean
   */
  boolean canKill(ChessPiece piece);
}
