package org.example.dsa.classes_objects.exercises;

// Write a class whose instances represent a single playing card from a deck of cards.
// Playing cards have two distinguishing properties: rank and suit.

public class Card {

   private final int rank;
   private final int suit;

   // SUITS -
    private final static int DIAMONDS = 1;
    private final static int HEARTS = 2;
    private final static int SPADES = 3;
    private final static int CLUBS = 4;

    // RANKS -
    private static final int ACE = 1;
    private static final int DEUCE = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
