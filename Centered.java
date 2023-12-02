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

  private final TextBlock originalBlock;
  private final int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Centered(TextBlock originalBlock, int width) {
    this.originalBlock = originalBlock;
    this.width = width;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String row(int i) throws Exception {
    if (i < 0 || i >= this.height()) {
      throw new IndexOutOfBoundsException("Invalid row index: " + i);
    }

    String originalRow = originalBlock.row(i);
    int originalWidth = originalRow.length();
    
    if (originalWidth >= width) {
      return originalRow;

    } else {
      int spacesToAdd = (width - originalWidth) / 2;
      
      String centeredRow = TBUtils.spaces(spacesToAdd) + originalRow + TBUtils.spaces(spacesToAdd);
      
      if ((width - originalWidth) % 2 == 1) {
        centeredRow += " ";
      } 
      
      return centeredRow;
    }
  } // row(int)

  public int height() {
    return originalBlock.height();
  } // height()

  public int width() {
    return width;
  } // width()
}
