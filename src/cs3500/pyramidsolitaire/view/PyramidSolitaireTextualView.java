package cs3500.pyramidsolitaire.view;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.IOException;
import java.util.List;


/**
 * Class used for representing the model of the game.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {

  private final PyramidSolitaireModel<?> model;
  private Appendable out;



  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
  }

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable out) {
    this.model = model;
    this.out = out;
  }



  /**
   * Renders all the present draw cards in draw pile.
   *
   * @return a string containing all draw cards present.
   */

  private String renderDraw() {

    String drawList = "";
    List<?> drawRender = model.getDrawCards();

    for (int i = 0; i < model.getDrawCards().size(); i++) {
      {
        Object card = drawRender.get(i);

        if (card == null) {
          drawList = drawList + "  " + "." + ",";
        } else {
          drawList = drawList + " " + card.toString() + ",";
        }
      }
    }

    if (model.getNumDraw() != 0) {
      drawList = (drawList.substring(0, drawList.length() - 1)).trim();
      return drawList;
    }
    return "";
  }

  /**
   * Renders the current pyramid if the game as a string.
   *
   * @return a string containing all cards that are visible in the game.
   */
  @Override
  public String toString() {

    try {
      model.getScore();
    } catch (IllegalStateException e) {
      return "";
    }

    if (model.getScore() == 0) {
      return "You win!";
    }

    if (model.isGameOver()) {
      return "Game over. Score: " + model.getScore();
    }

    String pyramid = "";
    String drawList = renderDraw();

    for (int i = 0; i < model.getNumRows(); i++) {
      for (int s = 0; s < (model.getNumRows() - 1) - i; s++) {
        pyramid += "  ";
      }
      for (int j = 0; j < (model.getRowWidth(i)); j++) {
        Object card = model.getCardAt(i, j);

        if (card == null) {

          pyramid = pyramid + "." + "  ";

        } else if (card.toString().length() == 2) {

          pyramid = pyramid + card.toString() + " ";
        } else {

          pyramid = pyramid + card.toString();
        }

        pyramid = pyramid + " ";
      }
      pyramid = pyramid.replaceAll("\\s+$", "");
      pyramid = pyramid + "\n";
    }

    if (drawList.length() == 0) {
      return pyramid + "Draw:";
    } else {
      return pyramid + "Draw: " + drawList;
    }
  }

  @Override
  public void render() throws IOException {
    this.out.append(this.toString());
  }
}