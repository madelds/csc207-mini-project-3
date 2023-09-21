/**
 * Creates a new block that is the horizontally flipped of an input block.
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */

 
public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original block.
   */
  private TextBlock originalBlock;

  /**
   * Build a new block by horizontally flipping the original block.
   */
  public HorizontallyFlipped(TextBlock originalBlock) {
    this.originalBlock = originalBlock;
  } //HorizontallyFlipped

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
    String originalRow = originalBlock.row(i);
    
    // Reverse the characters in the row to achieve horizontal flipping
    String flippedRow = new StringBuilder(originalRow).reverse().toString();
    
    return flippedRow;
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
} // class HorizontallyFlipped
