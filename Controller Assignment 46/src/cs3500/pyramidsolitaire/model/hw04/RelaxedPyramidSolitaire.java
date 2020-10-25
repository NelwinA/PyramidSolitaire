package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Relaxed Pyramid Solitaire game. The game is played with a deck of
 * 52 cards and you win once the score is 0, or you lose if no moves are left.
 */

public class RelaxedPyramidSolitaire extends BasicPyramidSolitaire implements
    PyramidSolitaireModel<Card> {

  public RelaxedPyramidSolitaire() {
    super();
  }


  private boolean validRelaxedPair(int row1, int card1, int row2, int card2) throws
      IllegalArgumentException, IllegalStateException {

    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }

    if ((row1 < 0) || (row1 > getNumRows()) || (row2 < 0) || (row2 > getNumRows())) {
      throw new IllegalArgumentException("Row out of bounds.");
    }

    if ((card1 < 0) || (card2 < 0) || (card1 > row1) || (card2 > row2)) {
      throw new IllegalArgumentException("Card is out of bounds.");
    }

    if ((!isExposed(row1, card1)) && (!isExposed(row2, card2))) {
      throw new IllegalArgumentException("At least one of the cards is not exposed.");
    }

    if ((this.pyramid.get(row1).get(card1).getValue()
        +
        this.pyramid.get(row2).get(card2).getValue() != 13)) {
      throw new IllegalArgumentException("Cards do not sum to 13.");
    }

    // both cards need to be on top of each other, no rows in between
    if (Math.abs(row1 - row2) != 1) {
      return false;
    }

    if (row2 < row1) {
      if (isExposed(row1, card1)) {
        if ((card2 == card1 + 1) || (card2 == card1)) {
          return true;
        }
      }
    }

    if (row1 < row2) {
      if (isExposed(row2, card2)) {
        if ((card1 == card2 + 1) || (card1 == card2)) {
          return true;
        }
      }
    }
    return false;
  }


  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {

    if (this.s == StateOfGame.GameNotStart) {
      throw new IllegalStateException();
    }

    if (validRelaxedPair(row1, card1, row2, card2)) {
      this.pyramid.get(row1).set(card1, null);
      this.pyramid.get(row2).set(card2, null);
      return;
    } else {
      if ((row1 < 0) || (row1 > getNumRows()) || (row2 < 0) || (row2 > getNumRows())) {
        throw new IllegalArgumentException("Row out of bounds.");
      }

      if ((card1 < 0) || (card2 < 0)) {
        throw new IllegalArgumentException("Card is out of bounds.");
      }

      isValidValueAndSet(card1, card2, this.pyramid.get(row1), this.pyramid.get(row2));
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

    // checks if there are card in the draw, true if there is
    for (Card c : draw) {
      if (c != null) {
        anyNonNull = true;
      }
    }

    // if no cards in draw then check for other possible moves
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
      boolean anyValidPairs = false;

      for (int i = 0; i < getNumRows() - 1; i++) {
        for (int j = 0; j <= i; j++) {
          if ((!isExposed(i, j)) &&
              ((this.pyramid.get(i + 1).get(j) == null) ^
                  (this.pyramid.get(i + 1).get(j + 1) == null))) {
            if (isExposed(i + 1, j)) {
              anyValidPairs = (
                  this.pyramid.get(i).get(j).getValue() + this.pyramid.get(i + 1).get(j).getValue()
                      == 13);
            } else if (isExposed(i + 1, j + 1)) {

              anyValidPairs = (
                  this.pyramid.get(i).get(j).getValue() + this.pyramid.get(i + 1).get(j + 1)
                      .getValue() == 13);

            }
          }
        }
      }

      // Checks if there is a possible move with one card.
      removeTwoPossible = isRemoveTwoPossible(exposed, false);

      return !removeTwoPossible && !anyValidPairs;
    }
    return false;
  }

  /**
   *  Determines if there is a possible move with one card.
   *
   * @param exposed list of exposed cards.
   * @param removeTwoPossible returns if its possible.
   * @return boolean
   */

  public static boolean isRemoveTwoPossible(ArrayList<Card> exposed, boolean removeTwoPossible) {
    for (int i = 0; i < exposed.size(); i++) {
      for (Card card : exposed) {
        if (exposed.get(i).getValue() == 13
            || exposed.get(i).getValue() + card.getValue() == 13) {
          removeTwoPossible = true; //this works because 13 is odd
        }
      }
    }
    return removeTwoPossible;
  }

}
