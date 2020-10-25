package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Factory class used for choosing and game type and creating a pyramid solitaire game
 * corresponding to that game type.
 */

public class PyramidSolitaireCreator {


  /**
   * Constructor for PyramidSolitaireCreator.
   */

  public PyramidSolitaireCreator() {
    // empty constructor because it does not have any fields.
  }

  /**
   * Enum that represents the three pyramid solitaire game types.
   */
  public enum GameType { BASIC, MULTIPYRAMID, RELAXED; }


  /**
   * Creates a pyramid solitaire game specified by the given GameType.
   * @param gt GameType given.
   * @return a new pyramid solitaire game.
   * @throws IllegalArgumentException if the given GameType does not exist.
   */
  public static PyramidSolitaireModel<Card> create(GameType gt) {

    switch (gt) {
      case BASIC:
        return new BasicPyramidSolitaire();

      case RELAXED:
        return new RelaxedPyramidSolitaire();

      case MULTIPYRAMID:
        return new MultiPyramidSolitaire();

      default:
        throw new IllegalArgumentException("Invalid game type.");
    }
  }
}
