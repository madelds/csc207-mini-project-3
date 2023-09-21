/**
 * Builds a new block that right-justifies the input block within that width.
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */

public class RightJustified implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original block.
   */
  private TextBlock originalBlock;
  /**
   * The width of the new block.
   */
  private int width;

  /**
   * Build a new block by right-justifying a block within a given width.
   */
  public RightJustified(TextBlock originalBlock, int width) {
    this.originalBlock = originalBlock;
    this.width = width;
  } //RightJustified

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
    int originalWidth = originalRow.length();
    
    // Calculate the number of spaces to add before the row to right-justify it
    int spacesToAdd = width - originalWidth;
    
    // Create a right-justified row with spaces added before the row
    String rightJustifiedRow = TBUtils.spaces(spacesToAdd) + originalRow;
    
    return rightJustifiedRow;
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
    return width; // The width of the right-justified block is the specified width
  } // width()
} // class RightJustified
