import static org.junit.Assert.assertEquals;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

/**
 * Test class used for testing the controller.
 */
public class PyramidSolitaireTextualControllerTest {

  StringBuilder out;
  PyramidSolitaireModel<Card> model;
  Reader in;
  PyramidSolitaireController controller;



  // test for playing a game with basic model (not mock)
  @Test
  public void testPlayGameBasicModel() {

    in = new StringReader("rm1 5 3 rm2 5 1 5 5 rm2 5 2 5 4 ");
    out = new StringBuilder();
    model = new BasicPyramidSolitaire();
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 5, 0);
    assertEquals("        A♦\n"
        + "      2♦  3♦\n"
        + "    4♦  5♦  6♦\n"
        + "  7♦  8♦  9♦  10♦\n"
        + "J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw:\n"
        + "Score: 94\n"
        + "        A♦\n"
        + "      2♦  3♦\n"
        + "    4♦  5♦  6♦\n"
        + "  7♦  8♦  9♦  10♦\n"
        + "J♦  Q♦  .   A♥  2♥\n"
        + "Draw:\n"
        + "Score: 81\n"
        + "        A♦\n"
        + "      2♦  3♦\n"
        + "    4♦  5♦  6♦\n"
        + "  7♦  8♦  9♦  10♦\n"
        + ".   Q♦  .   A♥  .\n"
        + "Draw:\n"
        + "Score: 68\n"
        + "Game over. Score: 55", out.toString());
  }

  // test for playing a game with relaxed model (not mock)
  @Test
  public void testPlayGameRelaxedModel() {

    in = new StringReader("rm1 5 3 rm2 5 1 5 5 rm2 5 2 5 4 ");
    out = new StringBuilder();
    model = new RelaxedPyramidSolitaire();
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 5, 0);
    assertEquals("        A♦\n"
        + "      2♦  3♦\n"
        + "    4♦  5♦  6♦\n"
        + "  7♦  8♦  9♦  10♦\n"
        + "J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw:\n"
        + "Score: 94\n"
        + "        A♦\n"
        + "      2♦  3♦\n"
        + "    4♦  5♦  6♦\n"
        + "  7♦  8♦  9♦  10♦\n"
        + "J♦  Q♦  .   A♥  2♥\n"
        + "Draw:\n"
        + "Score: 81\n"
        + "        A♦\n"
        + "      2♦  3♦\n"
        + "    4♦  5♦  6♦\n"
        + "  7♦  8♦  9♦  10♦\n"
        + ".   Q♦  .   A♥  .\n"
        + "Draw:\n"
        + "Score: 68\n"
        + "Game over. Score: 55", out.toString());
  }

  // test for playing a game with multi model (not mock)
  @Test
  public void testPlayGameMultiModel() {

    in = new StringReader("rmwd 1 2 2 q");
    out = new StringBuilder();
    model = new MultiPyramidSolitaire();
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 2, 1);
    assertEquals("  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦\n"
        + "Draw: 8♦\n"
        + "Score: 28\n"
        + "  A♦  2♦  3♦\n"
        + "4♦  .   6♦  7♦\n"
        + "Draw: 9♦\n"
        + "Score: 23\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + "   A♦  2♦  3♦\n"
        + "4♦  .   6♦  7♦\n"
        + "Draw: 9♦\n"
        + "Score: 23", out.toString());
  }

  // test for winning a game with multi model (not mock)
  @Test
  public void testGameWonMultiModel() {

    in = new StringReader("rm2 2 3 2 4 rmwd 2 2 1 rmwd 1 2 2 rmwd 3 1 3 rmwd 5 1 1 rmwd 4 1 2 q");
    out = new StringBuilder();
    model = new MultiPyramidSolitaire();
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 2, 10);
    assertEquals("  A♦  2♦  3♦\n"
        + "4♦  5♦  6♦  7♦\n"
        + "Draw: 8♦, 9♦, 10♦, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥\n"
        + "Score: 28\n"
        + "  A♦  2♦  3♦\n"
        + "4♦  5♦  .   .\n"
        + "Draw: 8♦, 9♦, 10♦, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥\n"
        + "Score: 15\n"
        + "  A♦  2♦  3♦\n"
        + ".   5♦  .   .\n"
        + "Draw: 8♦, 5♥, 10♦, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥\n"
        + "Score: 11\n"
        + "  A♦  2♦  3♦\n"
        + ".   .   .   .\n"
        + "Draw: 6♥, 5♥, 10♦, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥\n"
        + "Score: 6\n"
        + "  A♦  2♦  .\n"
        + ".   .   .   .\n"
        + "Draw: 6♥, 5♥, 7♥, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥\n"
        + "Score: 3\n"
        + "  .   2♦  .\n"
        + ".   .   .   .\n"
        + "Draw: 6♥, 5♥, 7♥, J♦, 8♥, K♦, A♥, 2♥, 3♥, 4♥\n"
        + "Score: 2"
        + "\nYou win!\n"
        + "Score: 0\n", out.toString());
  }

  // test for when the game is won and inputting a 'q' or 'Q' is not necessary
  @Test
  public void testGameWonBasic() {
    int row = 1;
    int card = 1;
    int index = 11;
    in = new StringReader("rmwd " + index + " " + row + " " + card);
    out = new StringBuilder();
    model = new BasicPyramidSolitaire();
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 11);
    assertEquals("A♦\n"
        + "Draw: 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n"
        + "Score: 1\n"
        + "You win!"
        + "\nScore: 0\n", out.toString());
  }

  // test for when the game is won and inputting a 'q' or 'Q' is not necessary
  @Test
  public void testGameWonRelaxed() {
    int row = 1;
    int card = 1;
    int index = 11;
    in = new StringReader("rmwd " + index + " " + row + " " + card);
    out = new StringBuilder();
    model = new RelaxedPyramidSolitaire();
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 11);
    assertEquals("A♦\n"
        + "Draw: 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n"
        + "Score: 1\n"
        + "You win!"
        + "\nScore: 0\n", out.toString());
  }


  // test for when the game is lost and inputting a 'q' or 'Q' is not necessary
  @Test
  public void testGameLoss() {
    int row = 1;
    int card = 1;

    in = new StringReader("rm1 " + " " + row + " " + card);
    out = new StringBuilder();
    model = new BasicPyramidSolitaire();
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 0);
    assertEquals("Game over. Score: 1" + "\nScore: 1\n", out.toString());
  }




  // tests if state exception is thrown when the readable has nothing left to read
  @Test (expected = IllegalStateException.class)
  public void testInputsISException() {
    int row = 2;
    int card = 2;
    in = new StringReader(" ");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeOne: " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }



  // test for throwing IllegalStateException when IOException happens in this.out.append
  @Test(expected = IllegalStateException.class)
  public void testPlayGameFakeAppendable() {
    Appendable mockAppendable = new MockAppendable();
    PyramidSolitaireModel model = new BasicPyramidSolitaire();
    PyramidSolitaireController controller = new PyramidSolitaireTextualController(
        new StringReader("dd 1"), mockAppendable);

    controller.playGame(model, model.getDeck(), true, 7, 3);
  }


  // tests for controller constructor readable null
  @Test (expected = IllegalArgumentException.class)
  public void testCtrlConstructorReadableIsNull() {
    out = new StringBuilder();
    controller = new PyramidSolitaireTextualController(null, out);
  }


  // tests for controller constructor appendable null
  @Test (expected = IllegalArgumentException.class)
  public void testCtrlConstructorAppendableIsNull() {
    in = new StringReader("");
    controller = new PyramidSolitaireTextualController(in, null);
  }


  // tests for invalid row input on playgame
  @Test(expected = IllegalStateException.class)
  public void testPlayGameInvalidRow() {
    in = new StringReader("dd 1");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), true, -1, 3);
  }

  // tests for invalid drawCard input on playgame
  @Test(expected = IllegalStateException.class)
  public void testPlayGameInvalidDraw() {
    in = new StringReader("dd 1");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), true, 1, -3);
  }

  // tests for null model on playgame
  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameInvalidModel() {
    in = new StringReader("dd 1");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(null, model.getDeck(), true, 1, 3);
  }


  // tests for null deck on playgame
  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameInvalidDeck() {
    in = new StringReader("dd 1");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, null, true, 1, 3);
  }


  @Test(expected = IllegalStateException.class)
  public void testControllerOutEmptyString() {
    out = new StringBuilder("");
    in = new StringReader("string");
    PyramidSolitaireModel model = new BasicPyramidSolitaire();
    PyramidSolitaireController controller = new PyramidSolitaireTextualController(
        in, out);
    controller.playGame(model, model.getDeck(),
        false, 1, 3);
  }

  // tests for checking if the game quits by itself if Q or q is entered
  @Test
  public void testLowerCaseQ() {
    in = new StringReader("q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  @Test
  public void testUpperCaseQ() {
    in = new StringReader("Q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // test that ignores multiple qs but quits when only a single one is entered
  @Test
  public void testMultipleQ() {

    in = new StringReader("QQQQQ q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "A♦\n"
        + "Draw: 2♦\n"
        + "Invalid move. Play again. \n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // when string builder is given null
  @Test(expected = NullPointerException.class)
  public void testControllerOutNull() {
    out = new StringBuilder(null);
    in = new StringReader("string");
  }

  // when the readable is given null
  @Test(expected = NullPointerException.class)
  public void testControllerInNull() {
    out = new StringBuilder("string");
    in = new StringReader(null);
  }

  // tests for rm1 ----------------------------------------------------------------------------
  // tests for making sure it is receiving correct inputs (1)
  @Test
  public void testInputsRemoveOne() {
    int row = 2;
    int card = 2;
    in = new StringReader("rm1 " + row + " " + card + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeOne: " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }



  // tests for receiving correct inputs in rm1 when there are strings in between (2)
  @Test
  public void testInputsRemoveOneWithCharBetween() {
    int row = 2;
    int card = 2;
    in = new StringReader("rm1 " + row + " lebron " + "ad " + card + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeOne: " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests if game quits correctly when q is in between valid inputs (3)
  @Test
  public void testInputsRemoveOneWithQBetween() {
    int row = 2;
    int card = 2;
    in = new StringReader("rm1 " + row + " q " + "ad " + card);
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests if game quits correctly when q is in between valid inputs after valid move (4)
  @Test
  public void testInputsRemoveOneWithQBetween2() {
    int row = 2;
    int card = 2;
    in = new StringReader("rm1 " + row + " " + card +  " q " + "rm1 " + row + card);
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeOne: " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }


  // tests if rm1 still works after other moves have been called in between (5)
  @Test
  public void testInputsRemoveOneWithMoveBetween() {
    int row = 2;
    int card = 2;
    in = new StringReader("rm1 " + "dd " + row + " lebron " + "ad " + card + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeOne: " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }



  // -----------------------------------------------------------------------------------------

  //tests for rm2
  // tests for making sure it is receiving correct inputs (1)
  @Test
  public void testInputsRemoveTwo() {
    int row = 1;
    int card = 1;
    int row2 = 2;
    int card2 = 2;

    in = new StringReader("rm2 " + row + " " + card +  " " + row2 + " " + card2 + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeTwo: 1 1 2 2\n"
        + "A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests for receiving correct inputs in rm2 when there are strings in between (2)
  @Test
  public void testInputsRemoveTwoCharInBetween() {
    int row = 1;
    int card = 1;
    int row2 = 2;
    int card2 = 2;

    in = new StringReader(
        "rm2 lala " + row + " lulu " + card + " lele " + row2 + " lili " + card2 + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeTwo: 1 1 2 2\n"
        + "A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }


  // tests if game quits correctly when q is in between valid inputs (3)
  @Test
  public void testInputsRemoveTwoQBetween() {
    int row = 1;
    int card = 1;
    int row2 = 2;
    int card2 = 2;

    in = new StringReader("rm2 " + row + " q " + card +  " " + row2 + " " + card2 );
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }




  // tests if game quits correctly when q is in between valid inputs after valid move (4)
  @Test
  public void testInputsRemoveTwoQBetween2() {
    int row = 1;
    int card = 1;
    int row2 = 2;
    int card2 = 2;

    in = new StringReader("rm2 " + row + " " + card +  " " + row2 + " " + card2 + " q "
    + "rm2 " + row + " " + card +  " " + row2 + " " + card2);
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeTwo: 1 1 2 2\n"
        + "A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests if rm2 still works after other moves have been called in between (5)
  @Test
  public void testInputsRemoveTwoMoveInBetween() {
    int row = 1;
    int card = 1;
    int row2 = 2;
    int card2 = 2;

    in = new StringReader("rm2 " + "dd " + row + " " + card +  " " + row2 + " " + card2 + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeTwo: 1 1 2 2\n"
        + "A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }


  // ------------------------------------------------------------------------------------------

  // tests for discard draw (dd)
  // tests for making sure it is receiving correct inputs (1)
  @Test
  public void testInputsDiscardDraw() {
    int index = 1;
    in = new StringReader("dd " + index + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "discardDraw: " + index
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }



  // tests for receiving correct inputs in dd when there are strings in between (2)
  @Test
  public void testInputsDiscardDrawCharBetween() {
    int index = 1;
    in = new StringReader("dd " + "anthony davis " + index + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "discardDraw: " + index
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests if game quits correctly when q is in between valid inputs (3)
  @Test
  public void testInputsDiscardDrawQBetween() {
    int index = 1;
    in = new StringReader("dd " + " q " + index + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests if game quits correctly when q is in between valid inputs after valid move (4)
  @Test
  public void testInputsDiscardDrawQBetween2() {
    int index = 1;
    in = new StringReader("dd " + index + " q " + "dd " + index);
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "discardDraw: " + index
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }



  // tests if dd still works after other moves have been called in between (5)
  @Test
  public void testInputsDiscardDrawMoveBetween() {
    int index = 1;
    in = new StringReader("dd " + "rm1 dd rm2 " + index + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "discardDraw: " + index
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // -------------------------------------------------------------------------------

  // tests for removeUsingDraw (rmwd)

  // tests for making sure it is receiving correct inputs (1)
  @Test
  public void testInputsRemoveWDraw() {
    int row = 2;
    int card = 2;
    int index = 1;
    in = new StringReader("rmwd " + index + " " + row + " " + card + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeWDraw: " + index + " " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests for receiving correct inputs in rmwd when there are strings in between (2)
  @Test
  public void testInputsRemoveWDrawCharBetween() {
    int row = 2;
    int card = 2;
    int index = 1;
    in = new StringReader("rmwd " + index + " lebron " + row + " lalal " + card + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeWDraw: " + index + " " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }


  // tests if game quits correctly when q is in between valid inputs (3)
  @Test
  public void testInputsRemoveWDrawQBetween() {
    int row = 2;
    int card = 2;
    int index = 1;
    in = new StringReader("rmwd " + index + " q " + row + " " + card);
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }


  // tests if game quits correctly when q is in between valid inputs after valid move (4)
  @Test
  public void testInputsRemoveWDrawQBetween2() {
    int row = 2;
    int card = 2;
    int index = 1;
    in = new StringReader("rmwd " + index + " " + row + " " + card + " q " + "dd 1 ");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeWDraw: " + index + " " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // tests if rmwd still works after other moves have been called in between (5)
  @Test
  public void testInputsRemoveWDrawMoveBetween() {
    int row = 2;
    int card = 2;
    int index = 1;
    in = new StringReader("rmwd " + "dd " + index + " " + row + " " + card + " q");
    out = new StringBuilder();
    model = new MockModel(out);
    controller = new PyramidSolitaireTextualController(in, out);

    controller.playGame(model, model.getDeck(), false, 1, 1);
    assertEquals("A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "removeWDraw: " + index + " " + row + " " + card
        + "\nA♦\n"
        + "Draw: 2♦\n"
        + "Score: 1\n"
        + "\nGame quit!\n"
        + "State of game when quit:\n"
        + " A♦\n"
        + "Draw: 2♦\n"
        + "Score: 1", out.toString());
  }

  // ---------------------------------------------------------------



}
