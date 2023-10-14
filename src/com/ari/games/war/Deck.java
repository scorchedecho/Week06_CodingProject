package com.ari.games.war;

import com.ari.games.war.Card.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a deck of {@link Card}s.
 *
 * @author Ari Schwartz
 * @since 2023-09-27
 */
public class Deck {

  private final List<Card> deck = new ArrayList<>();

  /**
   * Constructor for the Deck class.
   */
  public Deck() {
    // Create a deck of cards
    for (int i = 0; i < Suit.values().length; i++) {
      for (int j = 2; j <= Card.getStandardCardValues().size() + 1; j++) {
        deck.add(new Card(j, Suit.values()[i]));
      }
    }
  }

  /**
   * Simple toString method to print out the deck of card's information.
   *
   * @return a String representation of the deck of cards
   */
  @SuppressWarnings("unused")
  public String describe() {
    StringBuilder result = new StringBuilder();

    // Add each card in the deck
    for (Card card : deck) {
      result.append(card.describe()).append("\n");
    }

    return result.toString();
  }

  /* ******************* */
  /* GETTERS AND SETTERS */
  /* ******************* */

  /**
   * Retrieves the deck of cards.
   *
   * @return the deck of cards
   */
  @SuppressWarnings("unused")
  public List<Card> getDeck() {
    return deck;
  }

  /* ******************* */
  /*       UTILITY       */
  /* ******************* */

  /**
   * Shuffle the deck.
   */
  public void shuffle() {
    // Shuffle the deck
    Collections.shuffle(deck);
  }

  /**
   * Draw a card from the deck.
   *
   * @return the drawn card
   */
  public Card draw() {
    // Draw a card from the deck
    return deck.remove(0);
  }

}
