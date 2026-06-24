package org.example.dsa.recursion.subsetsAndSubsequence.stringsSubsequenceQuestions;

public class SkipACharInString {

    // Remove 'a' from a string -
    // 1) NORMAL WAY - Using for loop and string builder.
    static String removeAs(String input){
        StringBuilder builder = new StringBuilder();
        char[] chars = input.toCharArray();
        for(char c: chars){
            if(c=='a'||c=='A'){
                continue;
            }else{
                builder.append(c);

            }
        }
        return builder.toString();
    }

    //2) Using recursion - VERY IMPORTANT

    //2.1) - Passing the "answer" variable in argument of function

    /**
     * Here answer would be the "processed" string which initially would be empty.
     * @return
     */
    static String skip(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return processed;
        }

        char ch = unprocessed.charAt(0);
        if(ch=='a'){
            return skip(processed,unprocessed.substring(1));
        } else{
            return skip(processed+ch, unprocessed.substring(1));
        }
    }

    //2.2) Creating the "answer" variable inside the function body

    /**
     * So the input argument will only be unprocessed string
     */
    static String skip3(String unprocessed){
        String processed = "";
        // base condition
        if(unprocessed.isEmpty()){
            return processed;
        }
        char ch = unprocessed.charAt(0);
        if(ch=='a'){
            return skip3(unprocessed.substring(1));
        }else{
            return ch + skip3(unprocessed.substring(1));
        }

    }

    public static void main(String[] args){
        String input = "baccad";
        System.out.println(skip3(input));
    }
}
