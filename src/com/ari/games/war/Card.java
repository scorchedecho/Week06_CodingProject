package com.ari.games.war;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a card.
 *
 * @author Ari Schwartz
 * @since 2023-09-27
 */
public class Card {

  /**
   * Enum representing the suit of a card.
   * This is created to standardize all the cards.
   */
  public enum Suit {
    // An enum is sort of like a special "class" that is basically a group of constants.
    // Since Suits are unchanging, we can define them as constants for use in the Deck.
    // It would be possible to do this also with our standardCardValues, but instead
    // I used a Map to store the values to demonstrate an understanding of the actual
    // curriculum.

    // We define our suits here with their corresponding String name.
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    /**
     * Constructor for the Suit enum.
     * Create our standardized suits using the String name.
     */
    Suit(String suitName) {
      this.suitName = suitName;
    }

    /**
     * Private field to hold the String name of the suit.
     */
    private final String suitName;

    /**
     * Getter method for the suit name.
     *
     * @return the suit name
     */
    public String getSuitName() {
      return suitName;
    }
  }

  /**
   * All card values assigned to their String name.
   */
  private static final Map<Integer, String> standardCardValues = initializeStandardCardValues();

  private Suit suit;
  private int faceValue;

  /**
   * Constructor for the Card class.
   *
   * @param faceValue the face value of the card
   * @param suit the suit of the card
   * @throws IllegalArgumentException if the face value is not between 2 and 14 (inclusive)
   */
  public Card(int faceValue, Suit suit) throws IllegalArgumentException {

    // Card values cannot leave the range of 2-14 (inclusive).
    if (faceValue < 2 || faceValue > 14) {
      throw new IllegalArgumentException("Invalid face value.");
    }

    // Set our variables
    this.suit = suit;
    this.faceValue = faceValue;
  }

  /**
   * Simple toString method to print out the card's information.
   *
   * @return a String representation of the card
   */
  public String describe() {
    // Format a string as follows:
    // "Ace of Spades"
    // [rank] of [suit]; [standardCardValues.get(faceValue)] of [suit.getSuitName()]
    return String.format("%s of %s", getStandardCardValues().get(faceValue), suit.getSuitName());
  }

  /* ******************* */
  /* GETTERS AND SETTERS */
  /* ******************* */

  /**
   * Retrieves suit of the card, as {@link Suit}.
   *
   * @return the suit of the card
   */
  @SuppressWarnings("unused")
  public Suit getSuit() {
    return suit;
  }

  /**
   * Sets a new {@link Suit} for the card.
   *
   * @param suit new suit for the card
   */
  @SuppressWarnings("unused")
  public void setSuit(Suit suit) {
    this.suit = suit;
  }

  /**
   * Retrieves the rank of the card from its face value.
   *
   * @return rank of the card
   */
  @SuppressWarnings("unused")
  public String getRank() {
    return standardCardValues.get(faceValue);
  }

  public int getFaceValue() {
    return faceValue;
  }

  /**
   * Sets a new face value for the card.
   *
   * @param faceValue new face value for the card
   */
  @SuppressWarnings("unused")
  public void setFaceValue(int faceValue) {
    this.faceValue = faceValue;
  }

  // There is no setter for rank as it is derived from the face value.
  // This simplifies the class and prevents the rank from being set incorrectly.

  /* ******************* */
  /*       UTILITY       */
  /* ******************* */

  /**
   * Initializes set of standard face values and their String names.
   * Static method: does not change between instances of Card.
   *
   * @return the standard card values
   */
  private static Map<Integer, String> initializeStandardCardValues() {
    Map<Integer, String> values = new HashMap<>();

    values.put(2, "Two");
    values.put(3, "Three");
    values.put(4, "Four");
    values.put(5, "Five");
    values.put(6, "Six");
    values.put(7, "Seven");
    values.put(8, "Eight");
    values.put(9, "Nine");
    values.put(10, "Ten");
    values.put(11, "Jack");
    values.put(12, "Queen");
    values.put(13, "King");
    values.put(14, "Ace");

    return values;
  }

  /**
   * Retrieves set of standard face values and their String names.
   * Static method: does not change between instances of Card.
   *
   * @return the standard card values
   */
  public static Map<Integer, String> getStandardCardValues() {
    return standardCardValues;
  }

}
