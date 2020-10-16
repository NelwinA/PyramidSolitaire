import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class in order to test PyPyramidSolitaireTextualViewTest.
 */
public class PyramidSolitaireTextualViewTest {

  PyramidSolitaireTextualView game;
  PyramidSolitaireModel<Card> model;
  List<Card> testDeck;


  @Before
  public void setUpTest() {

    this.testDeck = new ArrayList<>(52);

    testDeck.add(new Card(13, '♦', false));
    testDeck.add(new Card(2, '♦', false));
    testDeck.add(new Card(3, '♦', false));
    testDeck.add(new Card(4, '♦', false));
    testDeck.add(new Card(5, '♦', false));
    testDeck.add(new Card(6, '♦', false));
    testDeck.add(new Card(7, '♦', false));
    testDeck.add(new Card(8, '♦', false));
    testDeck.add(new Card(9, '♦', false));
    testDeck.add(new Card(10, '♦', false));
    testDeck.add(new Card(11, '♦', false));
    testDeck.add(new Card(12, '♦', false));
    testDeck.add(new Card(1, '♦', false));

    testDeck.add(new Card(1, '♥', false));
    testDeck.add(new Card(2, '♥', false));
    testDeck.add(new Card(3, '♥', false));
    testDeck.add(new Card(4, '♥', false));
    testDeck.add(new Card(5, '♥', false));
    testDeck.add(new Card(6, '♥', false));
    testDeck.add(new Card(7, '♥', false));
    testDeck.add(new Card(8, '♥', false));
    testDeck.add(new Card(9, '♥', false));
    testDeck.add(new Card(10, '♥', false));
    testDeck.add(new Card(11, '♥', false));
    testDeck.add(new Card(12, '♥', false));
    testDeck.add(new Card(13, '♥', false));

    testDeck.add(new Card(1, '♠', false));
    testDeck.add(new Card(2, '♠', false));
    testDeck.add(new Card(3, '♠', false));
    testDeck.add(new Card(4, '♠', false));
    testDeck.add(new Card(5, '♠', false));
    testDeck.add(new Card(6, '♠', false));
    testDeck.add(new Card(7, '♠', false));
    testDeck.add(new Card(8, '♠', false));
    testDeck.add(new Card(9, '♠', false));
    testDeck.add(new Card(10, '♠', false));
    testDeck.add(new Card(11, '♠', false));
    testDeck.add(new Card(12, '♠', false));
    testDeck.add(new Card(13, '♠', false));

    testDeck.add(new Card(1, '♣', false));
    testDeck.add(new Card(2, '♣', false));
    testDeck.add(new Card(3, '♣', false));
    testDeck.add(new Card(4, '♣', false));
    testDeck.add(new Card(5, '♣', false));
    testDeck.add(new Card(6, '♣', false));
    testDeck.add(new Card(7, '♣', false));
    testDeck.add(new Card(8, '♣', false));
    testDeck.add(new Card(9, '♣', false));
    testDeck.add(new Card(10, '♣', false));
    testDeck.add(new Card(11, '♣', false));
    testDeck.add(new Card(12, '♣', false));
    testDeck.add(new Card(13, '♣', false));

    this.model = new BasicPyramidSolitaire();
    this.game = new PyramidSolitaireTextualView(model);

  }

  // Test for rendering the pyramid
  @Test
  public void toStringTest() {
    model.startGame(model.getDeck(), false, 7, 2);
    String pyramid = ""
        + "            A♦\n"
        + "          2♦  3♦\n"
        + "        4♦  5♦  6♦\n"
        + "      7♦  8♦  9♦  10♦\n"
        + "    J♦  Q♦  K♦  A♥  2♥\n"
        + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
        + "9♥  10♥ J♥  Q♥  K♥  A♠  2♠\n"
        + "Draw: 3♠, 4♠";

    assertEquals(pyramid, this.game.toString());
  }

  // Test for rendering the pyramid before game starts
  @Test
  public void toStringTestBeforeStart() {
    assertEquals("", this.game.toString());
  }


  // Test for when the game is not over
  @Test
  public void toStringTestGameOver() {
    model.startGame(model.getDeck(), false, 4, 2);
    String pyramid = ""
        + "      A♦\n"
        + "    2♦  3♦\n"
        + "  4♦  5♦  6♦\n"
        + "7♦  8♦  9♦  10♦\n"
        + "Draw: J♦, Q♦";
    assertEquals(pyramid, this.game.toString());
    assertFalse(this.model.isGameOver());
  }

  // Test for when game is over and you won
  @Test
  public void toStringTestWin() {
    model.startGame(this.testDeck, false, 1, 0);
    String pyramid = "K♦\nDraw:";

    assertEquals(pyramid, this.game.toString());
    assertFalse(this.model.isGameOver());
    model.remove(0,0);
    assertEquals("You win!", this.game.toString());
  }


  // Test for when game is over and you lost
  @Test
  public void toStringTestLoss() {
    model.startGame(model.getDeck(), false, 7, 0);
    String pyramid = ""
        + "            A♦\n"
        + "          2♦  3♦\n"
        + "        4♦  5♦  6♦\n"
        + "      7♦  8♦  9♦  10♦\n"
        + "    J♦  Q♦  K♦  A♥  2♥\n"
        + "  3♥  4♥  5♥  6♥  7♥  8♥\n"
        + "9♥  10♥ J♥  Q♥  K♥  A♠  2♠\n"
        + "Draw:";


    String pyramid2 = ""
        + "            A♦\n"
        + "          2♦  3♦\n"
        + "        4♦  5♦  6♦\n"
        + "      7♦  8♦  9♦  10♦\n"
        + "    J♦  Q♦  K♦  A♥  2♥\n"
        + "  3♥  4♥  .   .   .   .\n"
        + "9♥  10♥ .   .   .   .   .\n"
        + "Draw:";
    assertEquals(pyramid, this.game.toString());
    assertFalse(this.model.isGameOver());
    model.remove(6,4);
    model.remove(6,5, 6, 3);
    model.remove(6,2, 6, 6);
    model.remove(5, 3, 5, 4);
    model.remove(5, 2, 5, 5);
    assertEquals(pyramid2, this.game.toString());
    model.remove(4,2);
    assertEquals("Game over. Score: 107", this.game.toString());
    assertEquals(true, this.model.isGameOver());
  }
}