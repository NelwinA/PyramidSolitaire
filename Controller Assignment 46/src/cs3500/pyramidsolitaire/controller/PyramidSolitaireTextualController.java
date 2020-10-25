package cs3500.pyramidsolitaire.controller;

import static java.util.Objects.isNull;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Represents the controller used for reading inputs and outputting game states.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {

  private Readable in;
  private Appendable out;
  private boolean gameNotEnded;



  /**
   * Constructs a controller that can write to the appendable and read from the readable.
   *
   * @param in    is the readable that the controller reads from
   * @param out   is the appendable that the controller writes to
   * @throws IllegalArgumentException if either in or out are null
   */
  public PyramidSolitaireTextualController(Readable in, Appendable out)
      throws IllegalArgumentException {

    if (isNull(in) || isNull(out)) {
      throw new IllegalArgumentException();
    }
    this.in = in;
    this.out = out;
  }


  /**
   * Renders the state of the game and appends to view.
   *
   * @throws IllegalArgumentException if IOException is thrown
   */
  private void renderPrint(PyramidSolitaireTextualView print) throws IllegalStateException {
    try {
      print.render();
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }

  /**
   * Appends the given string to the appendable.
   * @param str string being appended
   * @throws IllegalArgumentException if IOException is thrown from append method
   */
  private void appendS(String str) throws IllegalStateException {
    try {
      this.out.append(str);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }


  /**
   * Appends the the quit message to the appendable.
   */
  private void appendQuit() {
    appendS("\nGame quit!\n" + "State of game when quit:\n ");
  }


  /**
   * Keeps reading the input until user decided to quit or input a number.
   * @param scan the scanner being used by the controller
   * @return boolean that determines if a 'q' or 'Q' has been entered
   */
  private boolean readHelper(Scanner scan) {
    if (!scan.hasNextInt()) {
      while (!scan.hasNextInt()) {
        String some = scan.next();
        if (some.equalsIgnoreCase("q")) {
          appendQuit();
          gameNotEnded = false;
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck, boolean shuffle,
      int numRows, int numDraw) throws IllegalArgumentException, IllegalStateException {


    if ((model == null)) {
      throw new IllegalArgumentException("Model is null"); }
    if ((deck == null)) {
      throw new IllegalArgumentException("Deck is null"); }

    try {
      model.startGame(deck, shuffle, numRows, numDraw); }
    catch (IllegalArgumentException e) {
      throw new IllegalStateException("Game can not be started");
    }

    gameNotEnded = !model.isGameOver();


    int row1;
    int col1;
    int row2;
    int col2;
    int index;
    String move;
    PyramidSolitaireTextualView print = new PyramidSolitaireTextualView(model, this.out);
    Scanner scan = new Scanner(this.in);
    String state = "";
    boolean quit = false;

    renderPrint(print);
    appendS("\nScore: " + model.getScore() + "\n");

    loop:
    while (gameNotEnded) {

      if (model.getScore() == 0 || model.isGameOver()) {
        gameNotEnded = false;
        break loop;
      }

      try {
        move = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException();
      }

      switch (move) {

        // case for remove 1 card -----------------------------------------
        case "rm1":
          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          row1 = scan.nextInt() - 1;

          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          col1 = scan.nextInt() - 1;

          if (gameNotEnded) {
            state = "";
            try {
              model.remove(row1, col1);
            } catch (IllegalArgumentException e) {
              state = "Invalid move. Play again. " + e.getMessage() + "\n";
            }
          }
          break;

        case "rm2":
          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          row1 = scan.nextInt() - 1;

          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          col1 = scan.nextInt() - 1;

          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          row2 = scan.nextInt() - 1;

          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          col2 = scan.nextInt() - 1;

          if (gameNotEnded) {
            state = "";
            try {
              model.remove(row1, col1, row2, col2);
            } catch (IllegalArgumentException e) {
              state = "Invalid move. Play again. " + e.getMessage() + "\n";
            }
          }
          break;

        // case for discard draw -------------------------------------------
        case "dd":
          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          index = scan.nextInt() - 1;

          if (gameNotEnded) {
            state = "";
            try {
              model.discardDraw(index);
            } catch (IllegalArgumentException e) {
              state = "Invalid move. Play again. " + e.getMessage() + "\n";
            }
          }
          break;

        case "rmwd":
          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          index = scan.nextInt() - 1;

          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          row1 = scan.nextInt() - 1;

          if (readHelper(scan)) {
            quit = true;
            break loop;
          }
          col1 = scan.nextInt() - 1;

          if (gameNotEnded) {
            state = "";
            try {
              model.removeUsingDraw(index, row1, col1);
            } catch (IllegalArgumentException e) {
              state = "Invalid move. Play again. " + e.getMessage() + "\n";
            }
          }
          break;

        // case for quit -------------------------------------------
        case "Q":
        case "q":
          appendQuit();
          gameNotEnded = false;
          quit = true;
          break loop;

        default:
          state = "Invalid move. Play again. \n";

      }

      renderPrint(print);

      if (!model.isGameOver()) {
        appendS("\n" + state + "Score: " + model.getScore() + "\n"); }
      else {
        appendS(state);
      }
    }

    if (quit) {
      renderPrint(print);
      appendS("\nScore: " + model.getScore());
    }
  }
}