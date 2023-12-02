/**
 * Builds a new block that centers a block within a given width.
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */

public class Centered implements TextBlock {
  // +---------+-----------------------------------------------------------
  // | Fields  |
  // +---------+

  // The text block to be centered
  private TextBlock block;

  // The width of the centered block
  private int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new centered block.
   */
  public Centered(TextBlock block, int width) {
    this.block = block;
    this.width = width;
  } // Centered(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the centered block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    int offset = calculateOffset();
    int blockWidth = block.width();

    if (i < block.height()) {
      // Center the row by adding leading spaces
      String rowContent = block.row(i);
      return " ".repeat(offset) + rowContent + " ".repeat(Math.max(0, width - blockWidth - offset));
    } else {
      throw new Exception("Invalid row number");
    }
  } // row(int)

  /**
   * Determine how many rows are in the centered block.
   */
  public int height() {
    return block.height();
  } // height()

  /**
   * Determine how many columns are in the centered block.
   */
  public int width() {
    return width;
  } // width()

  /**
   * Calculate the offset needed for centering.
   */
  private int calculateOffset() {
    int blockWidth = block.width();
    return Math.max(0, (width - blockWidth) / 2);
  } // calculateOffset()

} // class Centered