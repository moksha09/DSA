package org.example.recursion.subsetsAndSubsequence.stringsSubsequenceQuestions;

public class PrintASCIIValueOfACharacter {

    static void printASCII(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        // taking the ch in processed
        printASCII(p+ch,up.substring(1));
        // ignoring the ch in processed
        printASCII(p,up.substring(1));
        printASCII(p+(ch+0), up.substring(1));


    }
    public static void main(String[] arg){
        printASCII("","abc");
    }
}
