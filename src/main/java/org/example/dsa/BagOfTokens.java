package org.example.dsa;

import java.util.Arrays;

public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int faceUp = 0;
        int faceDown = n-1;
        int score = 0;

        Arrays.sort(tokens);

        while(faceUp<=faceDown){
            if(power>=tokens[faceUp]){
                power = power - tokens[faceUp];
                faceUp++;
                score++;
            }else if(score>=1 && faceDown>faceUp+1){
                power = power + tokens[faceDown];
                faceDown--;
                score--;
            }else{
                return score;
            }
        }
        return score;
    }

    public static void main(String[] args){
        int[] tokens = new int[] {100, 200, 300, 400};
        int power = 200;
        System.out.println(bagOfTokensScore(tokens, power));
    }
}
