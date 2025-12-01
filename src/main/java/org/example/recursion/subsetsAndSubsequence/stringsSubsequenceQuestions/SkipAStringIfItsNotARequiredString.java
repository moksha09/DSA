package org.example.recursion.subsetsAndSubsequence.stringsSubsequenceQuestions;

public class SkipAStringIfItsNotARequiredString {

    /**
     * Only skip app when its not equal to apple
     * @param unprocessed
     * @return
     */
    // 1) When we take the answer in out argument. - Time complexity - O(n) since every char is being checked once the recursion call is being called only once for each character

    static String skipAppNotApple(String unprocessed, String processed){
        if(unprocessed.isEmpty()){
            return  processed;
        }
        char ch = unprocessed.charAt(0);
        if(unprocessed.startsWith("app") && !unprocessed.startsWith("apple")){
            return skipAppNotApple(unprocessed.substring(3),processed);
        }else{
            return skipAppNotApple(unprocessed.substring(1),processed+ch);
        }

    }

    // 2) When we create new answer inside the function body -
    static String skipAppNotApple2(String unprocessed){
        String processed = "";
        if(unprocessed.isEmpty()){
            return processed;
        }
        char ch = unprocessed.charAt(0);
        if(unprocessed.startsWith("app") && !unprocessed.startsWith("apple")){
            return skipAppNotApple2(unprocessed.substring(3));
        }else{
            return ch + skipAppNotApple2(unprocessed.substring(1));
        }

    }
    public static void main(String[] args){
        String input = "dfgtappleghapplot";
        System.out.println(skipAppNotApple2(input));

    }
}
