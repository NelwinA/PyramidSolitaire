import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class used for testing methods in multi pyramid class.
 */
public class MultiPyramidSolitaireTest {
  List<Card> testDeck;
  List<Card> testDeckInvalid;
  List<Card> drawCards;
  List<Card> drawWithDiscarded;
  MultiPyramidSolitaire ex;


  @Before
  public void setUpTest() {

    this.ex = new MultiPyramidSolitaire();
    this.testDeck = new ArrayList<>();
    this.testDeckInvalid = new ArrayList<>();
    this.drawCards = new ArrayList<>();
    this.drawWithDiscarded = new ArrayList<>();


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




    drawCards.add(new Card(8, '♠', true));
    drawCards.add(new Card(9, '♠', true));
    drawCards.add(new Card(10, '♠', true));

    drawWithDiscarded.add(new Card(11, '♠', true));
    drawWithDiscarded.add(new Card(9, '♠', true));
    drawWithDiscarded.add(new Card(10, '♠', true));
    testDeckInvalid.add(new Card(6, '♥', true));
    testDeckInvalid.add(new Card(4, '♥', true));

  }


  //  Test for getDeck() ----------------------------------------------------------------
  @Test
  public void testGetDeck() {
    assertEquals(this.ex.getDeck(), this.testDeck);
  }

  //  Test for StartGame() ----------------------------------------------------------------

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionLessThan104() {
    //size of deck is less than 104
    this.ex.startGame(this.testDeckInvalid, false, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionThreeOfTheSameCard() {
    //size of deck is 104 but there 3 of the same card ( the 6♣ )
    this.testDeck.remove(0);
    this.testDeck.add(new Card(6, '♣', false));
    this.ex.startGame(this.testDeck, false, 5, 3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionRowsNegative() {
    this.ex.startGame(this.testDeck, false, -1, 3); // rows are negative
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionDrawNegative() {
    // Draw cards are negative.
    this.ex.startGame(this.testDeck, false, 1, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameExceptionNotEnoughToFill() {
    // Size of deck is 104 but there are not enough cards to fill the pyramid.
    this.ex.startGame(this.testDeck, false, 9, 0); // rows are negative
  }

  // Test for getCardAt() ----------------------------------------------------------------

  @Test
  public void testGetCardAt() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(new Card(4, '♦', true), this.ex.getCardAt(1, 0));
    assertEquals(new Card(5, '♦', true), this.ex.getCardAt(1, 1));
  }


  // Row is out of bounds exception
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtIException() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(new Card(2, '♦', true), this.ex.getCardAt(6, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtIException2() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    // Card is out of bounds
    assertEquals(new Card(2, '♦', true), this.ex.getCardAt(4, -3));
  }

  @Test(expected = IllegalStateException.class)
  public void testGetCardAtSException() {
    // Game has not started.
    assertEquals(new Card(2, '♦', true), this.ex.getCardAt(6, 7));
  }

  //Test for getDrawCards() --------------------------------------------------------------------

  // test to get the correct draw cards
  @Test
  public void testGetDrawCards() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(this.drawCards, this.ex.getDrawCards());
  }

  //Game has not started test.
  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardIException() {
    assertEquals(this.drawCards, this.ex.getDrawCards());
  }


  // Test for getRowWidth() --------------------------------------------------------------------


  // test to get correct number of spaces available in this row
  @Test
  public void testGetRowWidth() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(6, this.ex.getRowWidth(1));
  }

  // Game has not started test
  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthSException() {
    assertEquals(2, this.ex.getRowWidth(3));
  }

  // row is out of bounds
  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthIException() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(2, this.ex.getRowWidth(6)); // Row is out of bounds.
  }

  // Test for discardDraw() --------------------------------------------------------------------


  // tests discarding a card from a draw pile
  @Test
  public void testDiscardDraw() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    this.ex.discardDraw(0); // First card of draw pile is discarded.
    // This is new draw pile with replaced card from stock.
    assertEquals(this.drawWithDiscarded, this.ex.getDrawCards());
  }


  // Game has not started so test exception
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

  // test get correct number of draw cards
  @Test
  public void testGetNumDraw() {
    assertEquals(-1, this.ex.getNumDraw()); // Game has not started.
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(3, this.ex.getNumDraw());
  }

  // Test for getNumRows() --------------------------------------------------------------------

  // test get correct number of rows
  @Test
  public void testGetNumRows() {
    assertEquals(-1, this.ex.getNumRows()); // Game has not started.
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals(5, this.ex.getNumRows());
  }


  //Test for getScore() --------------------------------------------------------------------

  @Test
  public void testGetScore() {
    this.ex.startGame(this.testDeck, false, 7, 0);
    assertEquals(442, this.ex.getScore());
    this.ex.remove(6, 0); // I removed a K (value of 13).
    assertEquals(429, this.ex.getScore()); // 94 - 13 = 81
  }


  //Game has not started.
  @Test(expected = IllegalStateException.class)
  public void testGetScoreSException() {
    assertEquals(94, this.ex.getScore());
  }



  // Test for Remove() --------------------------------------------------------------------

  @Test
  public void testRemoveOneCard() {
    this.ex.startGame(this.testDeck, false, 7, 0);
    assertEquals("K♣", this.ex.getCardAt(6, 0).toString());
    this.ex.remove(6, 0);
    assertEquals(null, this.ex.getCardAt(6, 0));
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


  // test for removing two cards (valid move)
  @Test
  public void testRemoveTwoCard() {
    this.ex.startGame(this.testDeck, false, 7, 0);
    assertEquals("A♦", this.ex.getCardAt(6, 1).toString());
    assertEquals("Q♦", this.ex.getCardAt(6, 12).toString());
    this.ex.remove(6, 1, 6, 12);
    // Both cards got removed.
    assertEquals(null, this.ex.getCardAt(6, 1));
    assertEquals(null, this.ex.getCardAt(6, 12));
  }


  // The sum of both cards is greater than 13.
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveTwoCardIException() {
    this.ex.startGame(this.testDeck, false, 7, 0);
    assertEquals("A♦", this.ex.getCardAt(6, 1).toString());
    assertEquals("K♣", this.ex.getCardAt(6, 0).toString());
    this.ex.remove(6, 1, 6, 0);
  }


  // Row indexes are out of bounds.
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveTwoCardIExceptionRowIndex() {
    this.ex.startGame(this.testDeck, false, 7, 0);
    this.ex.remove(8, 3, 9, 4);
  }

  // Card indexes are out of bounds.
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveTwoCardIExceptionCardIndex() {
    this.ex.startGame(this.testDeck, false, 7, 0);
    this.ex.remove(3, 37, 2, 41);
  }

  // Game has not started.
  @Test(expected = IllegalStateException.class)
  public void testRemoveTwoCardSException() {
    this.ex.remove(6, 3, 6, 4);
  }

  // Test for RemoveUsingDraw() --------------------------------------------------------------------

  @Test
  public void testRemoveUsingDraw() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("3♠", this.ex.getCardAt(4, 4).toString());
    assertEquals("10♠", this.ex.getDrawCards().get(2).toString());
    this.ex.removeUsingDraw(2, 4, 4);
    // Card removed from pyramid:
    assertEquals(null, this.ex.getCardAt(4, 4));
    // Card replaced by stock card:
    assertEquals("J♠", this.ex.getDrawCards().get(2).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("3♠", this.ex.getCardAt(4, 4).toString());
    assertEquals("8♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(0, 4, 4); // Cards do not add up to 13.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException2() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("3♠", this.ex.getCardAt(4, 4).toString());
    assertEquals("8♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(7, 4, 4); // drawIndex is out of bounds.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException3() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("3♠", this.ex.getCardAt(4, 4).toString());
    assertEquals("8♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(0, 15, 1); // Row index is out of bounds.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIException4() {
    this.ex.startGame(this.testDeck, false, 5, 3);
    assertEquals("3♠", this.ex.getCardAt(4, 4).toString());
    assertEquals("8♠", this.ex.getDrawCards().get(0).toString());
    this.ex.removeUsingDraw(0, 4, 23); // Card index is out of bounds.
  }


  // Game has not started.
  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawSException() {
    this.ex.removeUsingDraw(0, 5, 1);
  }


  // tests for making sure the game starts again after it has started already
  @Test
  public void testStartAgain() {
    this.ex.startGame(this.testDeck, false, 1, 1);
    assertEquals(this.ex.isGameOver(), false);
    this.ex.startGame(this.testDeck, false, 1, 0);
    assertEquals(this.ex.isGameOver(), true);
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
