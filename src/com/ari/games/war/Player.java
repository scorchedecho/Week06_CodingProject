package com.ari.games.war;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a player.
 *
 * @author Ari Schwartz
 * @since 2023-09-27
 */
public class Player {

  private final List<Card> hand;
  private int score;
  private String name;

  /**
   * Constructor for the Player class.
   *
   * @param name the name of the player
   */
  public Player(String name) {
    this.name = name;

    score = 0;
    hand = new ArrayList<>();
  }

  /**
   * Simple toString method to print out the player's information.
   *
   * @return a String representation of the player
   */
  @SuppressWarnings("unused")
  public String describe() {
    StringBuilder result = new StringBuilder();

    result.append(name).append(" has ").append(score).append(" points.\n");
    // Add each card in the player's hand
    result.append("Current Hand: ");
    for (Card card : hand) {
      result.append(card.describe()).append(", ");
    }

    // Clean up the trailing comma and space
    result.delete(result.length() - 2, result.length() - 1);

    return result.toString();
  }

  /* ******************* */
  /* GETTERS AND SETTERS */
  /* ******************* */

  /**
   * Retrieves the player's hand.
   *
   * @return the player's hand
   */
  @SuppressWarnings("unused")
  public List<Card> getHand() {
    return hand;
  }

  /**
   * Retrieves the player's name.
   *
   * @return the player's name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets a new name for the player.
   *
   * @param name new name for the player
   */
  @SuppressWarnings("unused")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retrieves the player's score.
   *
   * @return the player's score
   */
  public int getScore() {
    return score;
  }

  /**
   * Sets a new score for the player.
   */
  public void resetScore() {
    score = 0;
  }

  /* ******************* */
  /*       UTILITY       */
  /* ******************* */

  /**
   * Increment the player's score by 1.
   */
  public void incrementScore() {
    score++;
  }

  /**
   * Flip the top card of the player's hand.
   *
   * @return the top card of the player's hand
   */
  public Card flip() {
    return hand.remove(0);
  }

  /**
   * Add a card to the player's hand.
   *
   * @param deck the deck to draw from
   */
  public void draw(Deck deck) {
    hand.add(deck.draw());
  }
}
