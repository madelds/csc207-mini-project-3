/**
 * Builds a new block that centers a block within a given width.
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */
public class Centered implements TextBlock {
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

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Center a block within a given width.
   */
  public Centered(TextBlock originalBlock, int width) {
    this.originalBlock = originalBlock;
    this.width = width;
  } // Centered(TextBlock, int)

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
    
    // Calculate the number of spaces to add before and after the row to center it
    int spacesToAdd = (width - originalWidth) / 2;
    
    // Create a centered row with spaces added
    String centeredRow = TBUtils.spaces(spacesToAdd) + originalRow + TBUtils.spaces(spacesToAdd);
    
    // If there are extra spaces due to odd width or alignment, add one more space at the end
    if ((width - originalWidth) % 2 == 1) {
      centeredRow += " ";
    } 
    
    return centeredRow;
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
    return width; // The width of the centered block is the specified width
  } // width()
} // class Centered
