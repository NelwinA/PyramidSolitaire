
import static org.junit.Assert.assertTrue;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import org.junit.Test;


/**
 * Test class used for testing the creation of different pyramid solitaires.
 */
public class PyramidSolitaireCreatorTest {

  PyramidSolitaireCreator creator = new PyramidSolitaireCreator();


  // test for BASIC
  @Test
  public void testCreatorBasic() {
    assertTrue(new BasicPyramidSolitaire().sameModels(creator.create(GameType.BASIC)));
  }

  // test for MULTI
  @Test
  public void testCreatorMulti() {
    assertTrue(new MultiPyramidSolitaire().sameModels(creator.create(GameType.MULTIPYRAMID)));
  }

  // test for RELAXED
  @Test
  public void testCreatorRelaxed() {
    assertTrue(new RelaxedPyramidSolitaire().sameModels(creator.create(GameType.RELAXED)));
  }

}
