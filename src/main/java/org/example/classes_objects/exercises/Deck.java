package org.example.classes_objects.exercises;

import java.util.Arrays;

// Write a class whose instances represents a full deck of cards.
public class Deck {

    private final static int numRanks = 13;
    private static final int numSuits = 4;

    private Card[][] deck = new Card[numSuits][numRanks];

    public Deck(){
        for(int i = 0; i<numSuits; i++){
            for(int j=0; j<numRanks; j++){
                deck[i][j] = new Card(j+1,i+1);
            }
        }
    }

    public static void main(String[] args){
        Deck deck1 = new Deck();
        for(int i = 0; i<numSuits; i++){
            for(int j=0; j<numRanks; j++){
                System.out.print(deck1.deck[i][j]);
            }
            System.out.println();
        }

    }


}
