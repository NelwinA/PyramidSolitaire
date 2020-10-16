package cs3500.pyramidsolitaire.model.hw02;

import java.util.Objects;

/**
 * Represents a card by its number/letter, suit, and if its face up or down.
 */
public class Card {

  private int value;
  private char suit;


  /**
   * Constructs a card that has its own suit and its own value.
   *
   * @param value  the value of the card
   * @param suit   the suit of the card
   * @throws IllegalArgumentException if value is above 13 or negative
   */
  public Card(int value, char suit, boolean faceUp) {
    if (value < 0 || value > 13) {
      throw new IllegalArgumentException();
    }
    this.value = value;
    this.suit = suit;
  }


  /**
   * Returns the value of this card.
   * @return value of card
   */
  public int getValue() {
    return this.value;
  }


  /**
   * Returns the card as a string. Determines what letter corresponds with each value.
   *
   * @return a string
   */
  @Override
  public String toString() {

    String toReturn = "";

    if (this.value == 1) {
      toReturn = "A" + this.suit;
    } else if (this.value == 10) {
      toReturn = "10" + this.suit;
    } else if (this.value < 10) {
      toReturn = Integer.toString(this.value) + this.suit;
    } else if (this.value == 11) {
      toReturn = "J" + this.suit;
    } else if (this.value == 12) {
      toReturn = "Q" + this.suit;
    } else if (this.value == 13) {
      toReturn = "K" + this.suit;
    } else {
      toReturn = ".";
    }
    return toReturn;
  }


  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Card)) {
      return false;
    }

    Card other = (Card) o;

    return this.value == other.value &&
        this.suit == other.suit;


  }

  @Override
  public int hashCode() {
    return Objects.hash(value, suit);
  }

}