package cs3500.pyramidsolitaire.model.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Pyramid Solitaire game. The game is played with a deck of
 * 52 cards and you win once the score is 0, or you lose if no moves are left.
 */
public class BasicPyramidSolitaire implements PyramidSolitaireModel<Card> {


  private final List<Card> deck = new ArrayList<>();
  private final List<Card> stock = new ArrayList<>();
  private final List<Card> drawList = new ArrayList<>();
  private ArrayList<ArrayList<Card>> pyramid = new ArrayList<>();
  private StateOfGame s;


  public BasicPyramidSolitaire() {
    this.s = StateOfGame.GameNotStart;
  }

  @Override
  public List<Card> getDeck() {

    List<Card> diamonds = fillSuit('♦');
    List<Card> hearts = fillSuit('♥');
    List<Card> spades = fillSuit('♠');
    List<Card> clubs = fillSuit('♣');

    diamonds.addAll(hearts);
    spades.addAll(clubs);
    diamonds.addAll(spades);

    return diamonds;
  }
  /**
   * Fills a list of cards with the given suit.
   *
   * @param suit  row of the desired card (0-indexed from the top.
   * @return a list of cards with the same suit.
   */

  private List<Card> fillSuit(char suit) {

    ArrayList<Card> toFill = new ArrayList<>();
    for (int i = 0; i < 13; i++) {
      toFill.add(new Card(i + 1, suit, true));
    }
    return toFill;
  }


  /**
   * Determines if the given card is exposed or not.
   *
   * @param row  row of the desired card (0-indexed from the top)
   * @param card column of the desired card (0-indexed from the left)
   * @return a boolean, true if it is Exposed, false otherwise.
   */

  private boolean isExposed(int row, int card) {

    if (row > getNumRows() || card > row) {
      throw new IllegalArgumentException("Out of Bounds");
    }
    if (this.pyramid.get(row).get(card) == null) {
      return false;
    }
    if (row == this.getNumRows() - 1) {
      return true;
    }
    return ((this.pyramid.get(row + 1).get(card) == null) && (this.pyramid.get(row + 1)
        .get(card + 1) == null));
  }


  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numRows, int numDraw)
      throws IllegalArgumentException {

    // check if the deck has
    if ((deck == null) || (deck.size() != 52)) {
      throw new IllegalArgumentException("Invalid Deck: size is not 52");
    }

    // checks if there are any duplicates in the deck
    for (int i = 0; i < deck.size(); i++) {
      for (int j = i + 1; j < deck.size(); j++) {
        if (deck.get(i).equals(deck.get(j))) {
          throw new IllegalArgumentException("Invalid Deck: contains duplicates");
        }
      }
    }

    this.deck.addAll(deck);

    if (shuffle) {
      Collections.shuffle(this.deck);   //shuffles deck
    }

    int start = (numRows * (numRows + 1)) / 2; // cards needed for a full pyramid

    if ((numRows <= 0)) {
      throw new IllegalArgumentException("Number of rows is invalid");
    }

    if ((numDraw < 0)) {
      throw new IllegalArgumentException("Number of draw cards is invalid");
    }

    if ((this.deck.size() < numDraw + start)) {
      throw new IllegalArgumentException("Unable to deal a full pyramid with 52 cards.");
    }



    //creates pyramid
    int pointer = 0;
    for (int i = 0; i < numRows; i++) {
      this.pyramid.add(new ArrayList<>(i + 1));
      for (int j = 0; j < i + 1; j++) {
        this.pyramid.get(i).add(this.deck.get(pointer));
        pointer++;
      }
    }

    this.drawList.addAll(this.deck.subList(start, start + numDraw)); //adds draw pile

    this.stock.addAll(
        (this.deck.subList(start + numDraw, this.deck.size()))); //adds rest of cards to stock

    this.s = StateOfGame.GameStart; // start the game after everything is dealt

  }

  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {

    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }
    if ((row1 < 0) || (row1 > getNumRows()) || (row2 < 0) || (row2 > getNumRows())) {
      throw new IllegalArgumentException("Row out of bounds.");
    }

    if ((card1 < 0) || (card2 < 0) || (card1 > row1) || (card2 > row2)) {
      throw new IllegalArgumentException("Card is out of bounds.");
    }

    if ((!isExposed(row1, card1)) || (!isExposed(row2, card2))) {
      throw new IllegalArgumentException("At least one of the cards is not exposed.");
    }

    if ((this.pyramid.get(row1).get(card1).getValue()
        +
        this.pyramid.get(row2).get(card2).getValue() != 13)) {
      throw new IllegalArgumentException("Cards do not sum to 13.");
    } else {
      this.pyramid.get(row1).set(card1, null);
      this.pyramid.get(row2).set(card2, null);
    }
  }

  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {

    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }
    if ((row < 0 || row > getNumRows())) {
      throw new IllegalArgumentException("Row is out of bounds.");
    }

    if ((card > row) || (card < 0)) {
      throw new IllegalArgumentException("Card is out of bounds.");
    }

    try {
      this.pyramid.get(row).get(card);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("out of bounds");
    }

    if (this.pyramid.get(row).get(card) == null) {
      throw new IllegalArgumentException("No card here");
    }

    if (getCardAt(row, card).getValue() != 13) {
      throw new IllegalArgumentException("Not a King.");
    }

    if (!isExposed(row, card)) {
      throw new IllegalArgumentException("Card is not exposed.");
    } else {
      this.pyramid.get(row).set(card, null);
    }
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {

    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }

    if (drawIndex >= this.drawList.size()) {
      throw new IllegalArgumentException("Draw index is out of bounds.");
    }

    if ((getNumRows() < row) || (row < 0)) {
      throw new IllegalArgumentException("Row is out of bounds");
    }

    if ((card < 0) || (card > row)) {
      throw new IllegalArgumentException("Card is out of bounds.");
    }

    if (!isExposed(row, card)) {
      throw new IllegalArgumentException("Card is not exposed.");
    }

    if ((this.pyramid.get(row).get(card).getValue() + this.drawList.get(drawIndex).getValue()
        != 13)) {
      throw new IllegalArgumentException("Cards do not sum to 13.");
    } else {
      this.pyramid.get(row).set(card, null);
      discardDraw(drawIndex);
    }
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {

    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }
    if (drawIndex >= this.drawList.size() || drawIndex < 0) {
      throw new IllegalArgumentException("Draw index is out of bounds.");
    }

    if (this.drawList.size() == 0) {
      throw new IllegalArgumentException("Draw index is out of bounds.");
    }

    if (this.stock.size() == 0) {
      this.drawList.set(drawIndex, null);
    } else {
      this.drawList.set(drawIndex, this.stock.remove(0));
    }

  }

  @Override
  public int getNumRows() {
    if (this.s == StateOfGame.GameNotStart) {
      return -1;
    } else {
      return this.pyramid.size();
    }
  }

  @Override
  public int getNumDraw() {
    if (this.s == StateOfGame.GameNotStart) {
      return -1;
    }

    else {
      int visible = 0;
      for (Card c : this.drawList) {
        if (c != null) {
          visible += 1;
        }
      }
      return visible;
    }
  }

  @Override
  public int getRowWidth(int row) {
    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }

    if (row < 0 || row > this.getNumRows()) {
      throw new IllegalArgumentException();
    } else {
      return row + 1;
    }
  }


  @Override
  public boolean isGameOver() throws IllegalStateException {
    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }

    List<Card> draw = new ArrayList<>();
    draw.addAll(this.drawList);
    boolean anyNonNull = false;

    for (Card c : draw) {
      if (c != null) {
        anyNonNull = true;
      }
    }

    if (!anyNonNull) {

      ArrayList<Card> exposed = new ArrayList<>();  // get all exposed cards in a list

      for (int i = 0; i < getNumRows(); i++) {
        for (int j = 0; j <= i; j++) {
          if (isExposed(i, j)) {
            exposed.add(getCardAt(i, j));
          }
        }
      }

      boolean removeTwoPossible = false;


      // Checks if there is a possible move with one card.
      for (int i = 0; i < exposed.size(); i++) {
        for (Card card : exposed) {
          if (exposed.get(i).getValue() == 13
              || exposed.get(i).getValue() + card.getValue() == 13) {
            removeTwoPossible = true; //this works because 13 is odd
          }
        }
      }

      return !removeTwoPossible;
    }

    return false;

  }



  @Override
  public int getScore() throws IllegalStateException {

    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    } else {

      int score = 0;
      for (int i = 0; i < getNumRows(); i++) {
        for (int j = 0; j < this.pyramid.get(i).size(); j++) {
          if (this.pyramid.get(i).get(j) != null) {
            score += this.pyramid.get(i).get(j).getValue();
          }
        }
      }
      return score;
    }
  }

  @Override
  public Card getCardAt(int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }

    if ((row < 0) || (row > getNumRows())) {
      throw new IllegalArgumentException("Row is out of bounds.");
    }

    if ((card < 0) || (card > getRowWidth(row))) {
      throw new IllegalArgumentException("Card is out of bounds.");
    }

    try {
      return this.pyramid.get(row).get(card);

    } catch (NullPointerException n) {
      throw new IllegalArgumentException("No card here.");
    }
  }

  @Override
  public List<Card> getDrawCards() throws IllegalStateException {
    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }
    return new ArrayList(this.drawList);
  }

  /**
   * Represents the state of the game.
   */
  enum StateOfGame { GameStart, GameNotStart }
}

