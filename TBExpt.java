import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Madel Sibal & Che Glenn
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("This is a test");

    // Boxed Block
    BoxedBlock boxBlock2 = new BoxedBlock(block2);

    // Boxed Box Block
    BoxedBlock boxedBoxBlock = new BoxedBlock(boxBlock2);

    // Boxed Empty Line
    TextBlock emptyBlock = new TextLine ("");
    BoxedBlock emptyBoxedBlock = new BoxedBlock(emptyBlock);

    TextBlock hello = new TextLine("Hello");
    TextBlock goodbye = new TextLine("Goodbye");

    // Vertical Boxed "Hello Goodbye" 1
    VComposition helloGoodbye2 = new VComposition(hello, goodbye);
    BoxedBlock boxedVert = new BoxedBlock(helloGoodbye2);

    // Vertical Boxed "Hello Goodbye" 2
    BoxedBlock boxHello = new BoxedBlock(hello);
    BoxedBlock boxGoodbye = new BoxedBlock(goodbye);

    VComposition helloGoodbye = new VComposition(boxHello, boxGoodbye);

    // Horizontal "Hello Goodbye" Right Side
    HComposition goodbyeRight = new HComposition(boxHello, goodbye);

    // Horizontal "Hello Goodbye" Left Side
    HComposition goodbyeLeft = new HComposition(goodbye, boxHello);

    // Printing out the blocks from the lab
    TBUtils.print(pen,block);
    TBUtils.print(pen,block2);
    TBUtils.print(pen,boxBlock2);
    TBUtils.print(pen,boxedBoxBlock);
    TBUtils.print(pen,emptyBoxedBlock);
    TBUtils.print(pen,boxedVert);
    TBUtils.print(pen,helloGoodbye);
    TBUtils.print(pen,goodbyeRight);
    TBUtils.print(pen,goodbyeLeft);

    // Printing out the blocks from the Mini Project

    // Truncated Blocks
    TextBlock truncatedText = new TextLine("Hello");
    BoxedBlock truncatedBox = new BoxedBlock(truncatedText);
    TextBlock truncated = new Truncated(truncatedBox, 2);
    TBUtils.print(pen, truncated);

    Truncated truncated2 = new Truncated(truncatedText, 20);
    BoxedBlock truncatedbox2 = new BoxedBlock(truncated2);
    TBUtils.print(pen, truncatedbox2);

    // Centered Blocks
    TextBlock centeredText = new TextLine("Hello");
    BoxedBlock centeredBox = new BoxedBlock(centeredText);
    TextBlock centeredBlock = new Centered(centeredBox, 100);
    TBUtils.print(pen, centeredBlock);

    Centered centered2 = new Centered(centeredText, 20);
    BoxedBlock centeredBox2 = new BoxedBlock(centered2);
    TBUtils.print(pen, centeredBox2);

    // Right Justified Blocks
    TextBlock rightJustifiedText = new TextLine("Hello");
    BoxedBlock rightJustifiedBox = new BoxedBlock(rightJustifiedText);
    TextBlock rightJustifedBlock = new Centered(rightJustifiedBox, 30);
    TBUtils.print(pen, rightJustifedBlock);

    RightJustified rightJustified2 = new RightJustified(rightJustifiedText, 20);
    BoxedBlock rightJustifiedBox2 = new BoxedBlock(rightJustified2);
    TBUtils.print(pen, rightJustifiedBox2);

    // Horizontally Flipped Block
    HorizontallyFlipped horizontallyFlippedBlock = new HorizontallyFlipped(helloGoodbye);
    TBUtils.print(pen, horizontallyFlippedBlock);

    // Vertically Flipped Block
    VerticallyFlipped verticallyFlippedBox = new VerticallyFlipped(helloGoodbye);
    TBUtils.print(pen, verticallyFlippedBox);

    // Rotated Text Block
    RotatedTextBlock rotatedBlock = new RotatedTextBlock(block);
    TBUtils.print(pen, rotatedBlock);


    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
