/**
 * Creates a new block that is the vertically flipped of an input block.
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */

public class VerticallyFlipped implements TextBlock {
  private TextBlock originalBlock;
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+


  /**
   * Build a new block by vertically flipping the original block.
   */
  public VerticallyFlipped(TextBlock originalBlock) {
  /**
   * The original block.
   */
    this.originalBlock = originalBlock;
  } // VerticallyFlipped

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
    
    // Ensure that the row number is within a valid range
    if (i >= 0 && i < numRows) {
      // Get the corresponding row from the original block in reverse order
      return originalBlock.row(numRows - 1 - i);
    } else {
      throw new Exception("Invalid row number: " + i);
    }
  }

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
    return originalBlock.width(); // The width remains the same after flipping
  } // width()
} // class VerticallyFlipped
