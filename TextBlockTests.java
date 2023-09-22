import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for each procedure in Mini Project 3
 * 
 * @author Madel Sibal
 * @version 1.2 of February 2019
 */

public class TextBlockTests {
    private TextBlock originalBlock;

    @BeforeEach
    void setUp() {
        // Create a sample original block for testing
        originalBlock = new TextBlock() {
            public String row(int i) throws Exception {
                switch (i) {
                    case 0:
                        return "Row 1";
                    case 1:
                        return "Row 2";
                    default:
                        throw new Exception("Invalid row");
                }
            }

            public int height() {
                return 2;
            }

            public int width() {
                return 6; // Width of the original block
            }
        };
    }

  /**
   * A test that should succeed for the procedure in Centered.java.
   */
    @Test
    void testCenteredBlockWithWidthLessThanOriginal() throws Exception {
        // Create a centered block with a width less than the original block's width
        Centered centeredBlock = new Centered(originalBlock, 4);

        // In this case, no centering should occur, so the rows should remain the same
        assertEquals("Row 1", centeredBlock.row(0));
        assertEquals("Row 2", centeredBlock.row(1));
    }

  /**
   * A test that should succeed for the procedure in Truncated.java.
   */
    @Test
    void testTruncatedLongRow() throws Exception {
        // Create a truncated block with a maximum width of 10
        Truncated truncatedBlock = new Truncated(originalBlock, 10);

        assertEquals("Row 1", truncatedBlock.row(0));
        assertEquals("Row 2", truncatedBlock.row(1));
    }
  /**
   * Another  test that should succeed for the procedure in Truncated.java.
   */
    @Test
    void testNoTruncationNeeded() throws Exception {
        // Create a truncated block with a maximum width larger than the original block's width
        Truncated truncatedBlock = new Truncated(originalBlock, 50);

        assertEquals("Row 1", truncatedBlock.row(0));
        assertEquals("Row 2", truncatedBlock.row(1));
    }

  /**
   * A test that should succeed for the procedure in RightJustified.java.
   */
    @Test
    void testRightJustifiedRows() throws Exception {
        // Create a right-justified block with a width of 10
        RightJustified justifiedBlock = new RightJustified(originalBlock, 10);

        assertEquals("     Row 1", justifiedBlock.row(0));
        assertEquals("     Row 2", justifiedBlock.row(1));
    }

  /**
   * A test that should succeed for the procedure in HorizontallyFlipped.java.
   */
    @Test
    void testHorizontallyFlippedRows() throws Exception {
        // Create a horizontally flipped block
        HorizontallyFlipped flippedBlock = new HorizontallyFlipped(originalBlock);

        assertEquals("1 woR", flippedBlock.row(0));
        assertEquals("2 woR", flippedBlock.row(1));
    }

  /**
   * A test that should succeed for the procedure in VerticallyFlipped.java.
   */
    @Test
    void testVerticallyFlippedRows() throws Exception {
        // Create a vertically flipped block
        VerticallyFlipped flippedBlock = new VerticallyFlipped(originalBlock);

        assertEquals("Row 2", flippedBlock.row(0));
        assertEquals("Row 1", flippedBlock.row(1));
    }

    /**
     * A test for the `equal` method in TBUtils.
     */
    @Test
    void testEqualMethod() {
        TextBlock block1 = originalBlock;
        TextBlock block2 = originalBlock;

        assertTrue(TBUtils.equal(block1, block2));
    }

    /**
     * A test for the `eqv` method in TBUtils.
     */
    @Test
    void testEqvMethod() {
        TextBlock block1 = new Centered(originalBlock, 4);
        TextBlock block2 = new Centered(originalBlock, 4);

        assertTrue(TBUtils.eqv(block1, block2));
    }

    /**
     * A test for the `eq` method in TBUtils.
     */
    @Test
    void testEqMethod() {
        TextBlock block1 = originalBlock;
        TextBlock block2 = originalBlock;

        assertTrue(TBUtils.eq(block1, block2));
    }



}
