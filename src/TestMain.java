import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.InputStreamReader;

/**
 * Class used for playing the game using the keyboard as input.
 */
public class TestMain {


  // Feel free to play the game to see if it works.


  /**
   * Main method that calls the controller to play the game.
   *
   * @param args the array of strings
   */
  public static void main(String[] args) {

    PyramidSolitaireModel<Card> model = new BasicPyramidSolitaire();
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(
        new InputStreamReader(System.in), System.out);

    controller.playGame(model, model.getDeck(), false, 5, 0);

  }

}
