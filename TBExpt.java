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

    //boxed block
    BoxedBlock boxBlock2 = new BoxedBlock(block2);

    //boxed box block
    BoxedBlock boxedBoxBlock = new BoxedBlock(boxBlock2);

    //boxed empty line
    TextBlock emptyBlock = new TextLine ("");
    BoxedBlock emptyBoxedBlock = new BoxedBlock(emptyBlock);

    TextBlock hello = new TextLine("Hello");
    TextBlock goodbye = new TextLine("Goodbye");

    //vert hello goodbye 1 boxed
    VComposition helloGoodbye2 = new VComposition(hello, goodbye);
    BoxedBlock boxedVert = new BoxedBlock(helloGoodbye2);

    //vert hello goodbye 2 boxed

    BoxedBlock boxHello = new BoxedBlock(hello);
    BoxedBlock boxGoodbye = new BoxedBlock(goodbye);

    VComposition helloGoodbye = new VComposition(boxHello, boxGoodbye);

    //horizontal hello goodbye right side

    HComposition goodbyeRight = new HComposition(boxHello, goodbye);

    //horizontal hello goodbye right side

    HComposition goodbyeLeft = new HComposition(goodbye, boxHello);




    // Print out the block
    TBUtils.print(pen, block);
    TBUtils.print(pen,block2);
    TBUtils.print(pen,boxBlock2);
    TBUtils.print(pen,boxedBoxBlock);
    TBUtils.print(pen,emptyBoxedBlock);
    TBUtils.print(pen,boxedVert);
    TBUtils.print(pen,helloGoodbye);

    TBUtils.print(pen,goodbyeRight);
    TBUtils.print(pen,goodbyeLeft);

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
