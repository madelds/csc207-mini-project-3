/**
 * Creates a new block that is the truncated version of an input block.
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */

public class Truncated implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original block.
   */
  private TextBlock originalBlock;
  /**
   * The width the new block would be truncated to.
   */
  private int maxWidth;

  /**
   * Build a new block by truncating the original block.
   */
  public Truncated(TextBlock originalBlock, int maxWidth) {
    this.originalBlock = originalBlock;
    this.maxWidth = maxWidth;
  } // Truncated(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   */
  public String row(int i) throws Exception {
    String originalRow = originalBlock.row(i);
    if (originalRow.length() > maxWidth) {
      // Truncate the row if it exceeds the maxWidth
      return originalRow.substring(0, maxWidth);
    } else {
      // If the row doesn't exceed maxWidth, return it as is
      return originalRow;
    }
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return originalBlock.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return maxWidth; // The width of the truncated block is the specified maxWidth
  } // width()
} // class Truncated
