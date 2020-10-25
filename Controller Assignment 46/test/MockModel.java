import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.Objects;

/**
 * Represents a mock model for testing the correct inputs.
 */
public class MockModel extends BasicPyramidSolitaire implements PyramidSolitaireModel<Card> {
  final StringBuilder log;

  public MockModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }


  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    this.log.append(
        String.format("removeTwo: %d %d %d %d\n", row1 + 1, card1 + 1, row2 + 1, card2 + 1));
    // the controller will subtract 1 from each input since rows start at index 1 when playing the
    // game, I add that 1 in here.

  }

  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {
    this.log.append(String.format("removeOne: %d %d\n", row + 1, card + 1));
    // the controller will subtract 1 from each input since rows start at index 1 when playing the
    // game, I add that 1 in here.
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    this.log.append(String.format("removeWDraw: %d %d %d\n", drawIndex + 1, row + 1, card + 1));
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {
    this.log.append(String.format("discardDraw: %d\n", drawIndex + 1));
    // the controller will subtract 1 from each input since rows start at index 1 when playing the
    // game, I add that 1 in here.
  }

}