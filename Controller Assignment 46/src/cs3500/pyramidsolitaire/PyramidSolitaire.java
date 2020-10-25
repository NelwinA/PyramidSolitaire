package cs3500.pyramidsolitaire;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;
import java.io.InputStreamReader;

/**
 * Class used for playing the game using the keyboard as input.
 */
public final class PyramidSolitaire {

  // Feel free to play the game to see if it works.

  /**
   * Main method that calls the controller to play the game.
   *
   * @param args the array of strings
   */
  public static void main(String[] args) {

    PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
    PyramidSolitaireModel<Card> model;

    switch (args[0]) {

      case "relaxed":
        model = creator.create(GameType.RELAXED);
        break;
      case "multi":
        model = creator.create(GameType.MULTIPYRAMID);
        break;
      case "basic":
        model = creator.create(GameType.BASIC);
        break;

      default:
        throw new IllegalStateException("Unexpected GameType: " + args[0]);
    }
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(
        new InputStreamReader(System.in), System.out);

    controller.playGame(model, model.getDeck(), false, 2, 10);
  }

}
