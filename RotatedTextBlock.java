/**
 * Rotates the text inside the box by 90 degrees.
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */

public class RotatedTextBlock implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original block.
   */
  private TextBlock originalBlock;

  /**
   * Rotates the text inside the original block by 90 degrees.
   */
  public RotatedTextBlock(TextBlock originalBlock) {
    this.originalBlock = originalBlock;
  } // RotatedTextBlock

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    int numRows = originalBlock.height();
    int numCols = originalBlock.width();

    // Ensure that the row number is within a valid range
    if (i >= 0 && i < numCols) {
      StringBuilder rotatedRow = new StringBuilder();
      for (int j = numRows - 1; j >= 0; j--) {
        rotatedRow.append(originalBlock.row(j).charAt(i));
      }
      return rotatedRow.toString();
    } else {
      throw new Exception("Invalid row number: " + i);
    }
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return originalBlock.width(); // Height becomes the original width
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return originalBlock.height(); // Width becomes the original height
  } // width()
} // class RotatedTextBlock
