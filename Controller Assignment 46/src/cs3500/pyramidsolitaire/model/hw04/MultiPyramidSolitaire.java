package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Represents a Multi Pyramid Solitaire game. The game is played with a deck of
 * 104 cards and you win once the score is 0, or you lose if no moves are left.
 */
public class MultiPyramidSolitaire extends BasicPyramidSolitaire
    implements PyramidSolitaireModel<Card> {

  public MultiPyramidSolitaire() {
    super();
  }

  @Override
  public List<Card> getDeck() {

    List<Card> firstHalf = super.getDeck();
    List<Card> secondHalf = super.getDeck();

    firstHalf.addAll(secondHalf);

    return firstHalf;
  }

  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numRows, int numDraw)
      throws IllegalArgumentException {

    // check if the deck has
    if ((deck == null) || (deck.size() != 104)) {
      throw new IllegalArgumentException("Invalid Deck: size is not 104");
    }

    // checks if there are any duplicates in the deck

    for (Card c : deck) {
      if (Collections.frequency(deck, c) != 2) {
        throw new IllegalArgumentException("Invalid Deck: contains extra duplicates.");
      }
    }

    // start the game again
    this.pyramid.clear();
    this.stock.clear();
    this.drawList.clear();

    this.deck.addAll(deck);

    if (shuffle) {
      Collections.shuffle(this.deck);   //shuffles deck
    }

    if ((numRows <= 0)) {
      throw new IllegalArgumentException("Number of rows is invalid");
    }

    if ((numDraw < 0)) {
      throw new IllegalArgumentException("Number of draw cards is invalid");
    }


    int numSpacesFirstRow;   // available spaces in first row
    int numLastRowSpaces;  // available spaces in last row
    int numRowsOverlap;    // rows that overlap

    int numIndependentRows; // rows that do not overlap

    if (numRows % 2 == 0) {
      numLastRowSpaces = numRows * 2;
      numSpacesFirstRow = numRows + 1;
      numRowsOverlap = (numRows / 2);
    } else {
      numLastRowSpaces = (numRows * 2) - 1;
      numSpacesFirstRow = numRows;
      numRowsOverlap = (numRows / 2) + 1;
    }

    numIndependentRows = numRows - numRowsOverlap;

    int totalCardsInOverlap = 0;

    for (int numO = 0; numO < numRowsOverlap; numO++) {
      totalCardsInOverlap += (numLastRowSpaces - numO);
    }

    int start = 3 * (((numRows - numRowsOverlap) * ((numRows - numRowsOverlap) + 1)) / 2);
    // cards needed for a full pyramid

    int numCardsForFull = start + totalCardsInOverlap;

    if (104 < numCardsForFull + numDraw) {
      throw new IllegalArgumentException("Do not have enough cards to deal a game, unlucky.");
    }


    for (int i = 0; i < numRows; i++) {
      this.pyramid.add(new ArrayList<>(numSpacesFirstRow + i));
    }

    int pointer = 0;
    for (int r = 0; r < numIndependentRows; r ++) {

      int numCardsToAddPerPyramid = r + 1;
      int numNullsToAddPerPyramid = ((numSpacesFirstRow + r) - (numCardsToAddPerPyramid * 3)) / 2;

      // do three times for each pyramid
      for (int i = 0; i < 3; i++) {

        // add a card(s) depending on the row
        for (int c = 0; c < numCardsToAddPerPyramid; c++) {
          this.pyramid.get(r).add(this.deck.get(pointer));
          pointer++;
        }

        // add the nulls but never add nulls after the last card has been added (the break)
        for (int n = 0; n < numNullsToAddPerPyramid; n++) {

          if (i == 2) {
            break;
          } else {
            this.pyramid.get(r).add(null);
          }
        }
      }
    }


    // add the rest of the rows that overlap with each other
    for (int ir = numIndependentRows; ir < numRows; ir++ ) {
      for (int s = 0; s < numSpacesFirstRow + ir; s++) {
        this.pyramid.get(ir).add(this.deck.get(pointer));
        pointer++;
      }
    }

    //adds draw pile
    this.drawList.addAll(this.deck.subList(numCardsForFull, numCardsForFull + numDraw));

    //adds rest of cards to stock
    this.stock.addAll(
        (this.deck.subList(numCardsForFull + numDraw, this.deck.size())));

    this.s = StateOfGame.GameStart; // start the game after everything is dealt
  }


}
