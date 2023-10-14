package com.ari.games;

import com.ari.games.war.Card;
import com.ari.games.war.Deck;
import com.ari.games.war.Player;

/**
 * Main class for the WAR game.
 */
public class Main {

  /**
   * Main method for the WAR game.
   * Runs the game.
   *
   * @param args args
   */
  public static void main(String[] args) {
    // If I mess things up...I change fewer variables this way.
    int standardDeckSize = Card.getStandardCardValues().size();

    // Create & shuffle a new deck.
    Deck deck = new Deck();
    deck.shuffle();

    // Create two players
    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");

    // Deal all cards to the two players
    System.out.println("Dealing cards...");
    for (int i = 0; i < standardDeckSize; i++) {
      if (i % 2 == 0) { // even numbers; player 2 (goes second)
        player2.draw(deck);
      } else { // odd numbers; player 1 (goes first)
        player1.draw(deck);
      }
    }

    System.out.println("Let the game begin!\n\n");

    for (int i = 0; i < standardDeckSize / 2; i++) {
      System.out.println("***** ROUND " + (i + 1) + " *****");

      Card player1card = player1.flip();
      Card player2card = player2.flip();

      System.out.println("\t" + player1.getName() + " draws: " + player1card.describe());
      System.out.println("\t" + player2.getName() + " draws: " + player2card.describe());

      // Determine this round's winner
      String roundOutput;
      if (player1card.getFaceValue() > player2card.getFaceValue()) {
        roundOutput = String.format("\t%s wins the round! They have been awarded a point.",
            player1.getName());
        player1.incrementScore();
      } else if (player1card.getFaceValue() < player2card.getFaceValue()) {
        roundOutput = String.format("\t%s wins the round! They have been awarded a point.",
            player2.getName());
        player2.incrementScore();
      } else {
        roundOutput = "\tThis round is a tie! No point is awarded.";
      }
      System.out.println("\n" + roundOutput);

      // Output scores
      System.out.println(getCurrentScores(player1, player2));

    }

    // Determine the winner
    System.out.println("\n\nAnd the winner is...");
    System.out.println(getWinner(player1, player2));

  }

  /**
   * Determine the current scores of the game.
   *
   * @param player1 Player 1
   * @param player2 Player 2
   * @return the scores of the game as a String
   */
  private static String getCurrentScores(Player player1, Player player2) {
    String scoreOutput;
    if (player1.getScore() > player2.getScore()) {
      scoreOutput = String.format("\t%s is winning with %d points versus %s's %d points.",
          player1.getName(), player1.getScore(), player2.getName(), player2.getScore());
    } else if (player1.getScore() < player2.getScore()) {
      scoreOutput = String.format("\t%s is winning with %d points versus %s's %d points.",
          player2.getName(), player2.getScore(), player1.getName(), player1.getScore());
    } else {
      scoreOutput = "\tThe game is currently tied!";
    }

    return scoreOutput;
  }

  /**
   * Determine the winner of the game.
   *
   * @param player1 Player 1
   * @param player2 Player 2
   * @return the winner of the game as a String
   */
  private static String getWinner(Player player1, Player player2) {
    String winnerOutput;
    if (player1.getScore() > player2.getScore()) {
      winnerOutput = String.format("%s with %d points!", player1.getName(), player1.getScore());
    } else if (player1.getScore() < player2.getScore()) {
      winnerOutput = String.format("%s with %d points!", player2.getName(), player2.getScore());
    } else {
      winnerOutput = "It's a tie!";
    }
    return winnerOutput;
  }
}