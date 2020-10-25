import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class used for testing methods in relaxed pyramid class.
 */
public class RelaxedPyramidSolitaireTest {
  List<Card> testDeck;
  List<Card> testDeckInvalid;
  List<Card> drawCards;
  List<Card> drawWithDiscarded;
  RelaxedPyramidSolitaire ex;


  @Before
  public void setUpTest() {

    this.ex = new RelaxedPyramidSolitaire();
    this.testDeck = new ArrayList<>();
    this.testDeckInvalid = new ArrayList<>();
    this.drawCards = new ArrayList<>();
    this.drawWithDiscarded = new ArrayList<>();

    //Adds all 52 cards to testDeck.
    testDeck.add(new Card(1, '♦', false));
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
    testDeck.add(new Card(13, '♦', false));

    testDeck.add(new Card(1, '♥', false));
    testDeck.add(new Card(2, '♥', false));
    // All cards above are in the pyramid.
    testDeck.add(new Card(3, '♥', false));
    testDeck.add(new Card(4, '♥', false));
    testDeck.add(new Card(5, '♥', false));
    //These 3 cards above start in Draw pile.
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

    // Adds draw cards
    drawCards.add(new Card(3, '♥', true));
    drawCards.add(new Card(4, '♥', true));
    drawCards.add(new Card(5, '♥', true));

    // Same as drawList from above but the first element has been replaced by stock card
    drawWithDiscarded.add(new Card(6, '♥', true));
    drawWithDiscarded.add(new Card(4, '♥', true));
    drawWithDiscarded.add(new Card(5, '♥', true));

    // Sets an invalid deck with less than 52 cards
    testDeckInvalid.add(new Card(6, '♥', true));
    testDeckInvalid.add(new Card(4, '♥', true));

  }


  //  Test for getDeck() ----------------------------------------------------------------
  @Test
  public void testGetDeck() {
    assertEquals(this.ex.getDeck(), this.testDeck);
  }

  //  Test for StartGame() ----------------------------------------------------------------

  //size of deck is less than 52
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionLess52() {
    this.ex.startGame(this.testDeckInvalid, false, 5, 3);
  }

  //size of deck is 52 but there are duplicates
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionDuplicates() {
    this.testDeck.remove(0);
    this.testDeck.add(new Card(6, '♣', false));
    this.ex.startGame(this.testDeck, false, 5, 3);
  }


  // rows are negative
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionRowsNegative() {
    this.ex.startGame(this.testDeck, false, -1, 3);
  }


  // Draw cards are negative.
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionDrawNegative() {
    this.ex.startGame(this.testDeck, false, 1, -3);
  }


  // Size of deck is 52 but there are not enough cards to fill the pyramid.
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionNotEnoughToFill() {
    this.ex.startGame(this.testDeck, false, 100, 2);
  }


  // Test for getCardAt() ----------------------------------------------------------------


  // test to get correct card
  @Test
  public void testGetCardAt() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(new Card(2, '♦', true), this.ex.getCardAt(1, 0));
    assertEquals(new Card(3, '♦', true), this.ex.getCardAt(1, 1));
  }


  // Row is out of bounds in getCard
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtIException() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(new Card(2, '♦', true), this.ex.getCardAt(6, 1));
  }

  // Card is out of bounds in getCard
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtIException2() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(new Card(2, '♦', true), this.ex.getCardAt(4, 8));
  }


  // Game has not started.
  @Test(expected = IllegalStateException.class)
  public void testGetCardAtSException() {
    assertEquals(new Card(2, '♦', true), this.ex.getCardAt(6, 7));
  }

  //Test for getDrawCards() --------------------------------------------------------------------

  @Test
  public void testGetDrawCards() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(this.drawCards, this.ex.getDrawCards());
  }

  //Game has not started.
  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardIException() {
    assertEquals(this.drawCards, this.ex.getDrawCards());
  }

  // Test for getRowWidth() --------------------------------------------------------------------

  @Test
  public void testGetRowWidth() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(2, this.ex.getRowWidth(1));
  }


  // Game has not started.
  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthSException() {
    assertEquals(2, this.ex.getRowWidth(3));
  }


  // Row is out of bounds ni getRowWidth
  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthIException() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(2, this.ex.getRowWidth(6));
  }

  // Test for discardDraw() --------------------------------------------------------------------

  @Test
  public void testDiscardDraw() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    this.ex.discardDraw(0); // First card of draw pile is discarded.
    // This is new draw pile with replaced card from stock.
    assertEquals(this.drawWithDiscarded, this.ex.getDrawCards());
  }

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawSException() {
    this.ex.discardDraw(0);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawIException() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    this.ex.discardDraw(4); // drawIndex is out of bounds.
  }

  //Test for getNumDraw() --------------------------------------------------------------------

  @Test
  public void testGetNumDraw() {
    assertEquals(-1, this.ex.getNumDraw()); // Game has not started.
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(3, this.ex.getNumDraw());
  }

  // Test for getNumRows() --------------------------------------------------------------------


  @Test
  public void testGetNumRows() {
    assertEquals(-1, this.ex.getNumRows()); // Game has not started.
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(5, this.ex.getNumRows());
  }

  //Test for getScore() --------------------------------------------------------------------


  @Test
  public void testGetScore() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(94, this.ex.getScore());
    this.ex.remove(4, 2); // I removed a K (value of 13).
    assertEquals(81, this.ex.getScore()); // 94 - 13 = 81
  }

  @Test(expected = IllegalStateException.class)
  public void testGetScoreSException() {
    assertEquals(94, this.ex.getScore()); //Game has not started.
  }

  // Test for Remove() --------------------------------------------------------------------

  @Test
  public void testRemoveOneCard() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("K♦", this.ex.getCardAt(4, 2).toString());
    this.ex.remove(4, 2);
    assertEquals(null, this.ex.getCardAt(4, 2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveOneCardIException() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("A♦", this.ex.getCardAt(0, 0).toString());
    this.ex.remove(20, 20); // Row index is out of bounds.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveOneCardIException2() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("A♦", this.ex.getCardAt(0, 0).toString());
    this.ex.remove(2, 20); // Card index is out of bounds.
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveOneCardSException() {
    this.ex.remove(20, 20); // Game has not started.

  }

  // Test for RemoveTwo() --------------------------------------------------------------------


  // test to remove two exposed cards
  @Test
  public void testRemoveTwoCardBothExposed() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    assertEquals("Q♥", this.ex.getCardAt(6, 3).toString());
    assertEquals("A♠", this.ex.getCardAt(6, 5).toString());
    this.ex.remove(6, 3, 6, 5);
    // Both cards got removed.
    assertEquals(null, this.ex.getCardAt(6, 3));
    assertEquals(null, this.ex.getCardAt(6, 5));
  }

  // test to remove one hald exposed and one exposed (both on top of each other)
  @Test
  public void testRemoveTwoCardOneHalfExposed() {
    this.ex.startGame(this.testDeck, false, 8, 0);
    assertEquals("3♠", this.ex.getCardAt(7, 0).toString());
    assertEquals("10♠", this.ex.getCardAt(7, 7).toString());
    this.ex.remove(7, 0, 7, 7);
    // Both cards got removed
    assertEquals(null, this.ex.getCardAt(7, 0));
    assertEquals(null, this.ex.getCardAt(7, 7));
    // the cards removed above made it possible for a relaxed remove with the 9♥ being half exposed
    assertEquals("9♥", this.ex.getCardAt(6, 0).toString());
    assertEquals("4♠", this.ex.getCardAt(7, 1).toString());
    this.ex.remove(6, 0, 7, 1);
    // cards got removed and no exception was thrown
  }

  // test to remove two half exposed cards
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveTwoCardTwoHalfExposed() {
    this.ex.startGame(this.testDeck, false, 8, 0);
    assertEquals("6♠", this.ex.getCardAt(7, 3).toString());
    assertEquals("7♠", this.ex.getCardAt(7, 4).toString());
    this.ex.remove(7, 3, 7, 4);
    assertEquals("4♠", this.ex.getCardAt(7, 1).toString());
    assertEquals("9♠", this.ex.getCardAt(7, 6).toString());
    this.ex.remove(7, 1, 7, 6);

    // as you can see the card below are half exposed and add up to 13
    assertEquals("J♥", this.ex.getCardAt(6, 2).toString());
    assertEquals("2♠", this.ex.getCardAt(6, 6).toString());
    this.ex.remove(6, 2, 6, 6);
    // Both attempted to be removed but invalid because both are half exposed
  }

  // test to remove two half exposed card with an exposed but are not on top of each other
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveTwoCardOneHalfExposedInvalid() {
    this.ex.startGame(this.testDeck, false, 8, 0);
    this.ex.remove(7, 2, 7, 5);
    // Both cards got removed and made the 10♥ half exposed
    // the cards removed above made it possible for a relaxed remove with the 9♥ being half exposed
    //  one is half exposed but arent on top of each other
    this.ex.remove(7, 4, 6, 1);
  }




  // The sum of both cards is greater than 13.
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveTwoCardIExceptionSumNot13() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    assertEquals("K♥", this.ex.getCardAt(6, 4).toString());
    assertEquals("A♠", this.ex.getCardAt(6, 5).toString());
    this.ex.remove(6, 3, 6, 4);
  }

  // Row indexes are out of bounds.
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveTwoCardIExceptionRowIndex() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    this.ex.remove(8, 3, 9, 4);
  }

  // Game has not started.
  @Test(expected = IllegalStateException.class)
  public void testRemoveTwoCardSException() {
    this.ex.remove(6, 3, 6, 4);
  }


  // Test for RemoveUsingDraw() --------------------------------------------------------------------

  @Test
  public void testRemoveUsingDraw() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    assertEquals("10♥", this.ex.getCardAt(6, 1).toString());
    assertEquals("3♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(0, 6, 1);
    // Card removed from pyramid:
    assertEquals(null, this.ex.getCardAt(6, 1));
    // Card replaced by stock card:
    assertEquals("5♠", this.ex.getDrawCards().get(0).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    assertEquals("4♥", this.ex.getCardAt(5, 1).toString());
    assertEquals("3♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(0, 5, 1); // Cards do not add up to 13.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException2() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    assertEquals("10♥", this.ex.getCardAt(6, 1).toString());
    assertEquals("3♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(7, 6, 1); // drawIndex is out of bounds.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException3() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    assertEquals("10♥", this.ex.getCardAt(6, 1).toString());
    assertEquals("3♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(0, 8, 1); // Row index is out of bounds.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException4() {
    this.ex.startGame(this.testDeck, false, 7, 2);
    assertEquals("10♥", this.ex.getCardAt(6, 1).toString());
    assertEquals("3♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(0, 6, 10); // Card index is out of bounds.
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawSException() {
    this.ex.removeUsingDraw(0, 5, 1); // Game has not started.
  }

  // ------------------------------------------------------------



  // tests for making sure the game starts again after it has started already
  @Test
  public void testStartAgain() {
    this.ex.startGame(this.testDeck, false, 1, 1);
    assertEquals(this.ex.isGameOver(), false);
    this.ex.startGame(this.testDeck, false, 1, 0);
    assertEquals(this.ex.isGameOver(), true);
  }


  // Test for isGameOver() --------------------------------------------------------------
  @Test
  public void testGameOverTrue() {
    this.ex.startGame(this.testDeck, false, 1, 0);
    assertEquals(this.ex.isGameOver(), true);
  }

  @Test
  public void testGameOverFalse() {
    this.ex.startGame(this.testDeck, false, 1, 3);
    assertEquals(this.ex.isGameOver(), false);
  }


  // test for shuffling deck
  @Test
  public void testShuffle() {
    this.ex.startGame(this.testDeck, false, 1, 1);
    assertEquals(this.ex.getCurrentDeck(), this.testDeck);
    this.ex.startGame(this.testDeck, true, 1, 1);
    assertNotEquals(this.testDeck, this.ex.getCurrentDeck());

  }

}
