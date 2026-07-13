package org.example.dsa.hashmap.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequence {

    /**
     * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
     * For example, "ACGAATTCCG" is a DNA sequence.
     * When studying DNA, it is useful to identify repeated sequences within the DNA.
     * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
     * that occur more than once in a DNA molecule. You may return the answer in any order.
     * Example 1:
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * Output: ["AAAAACCCCC","CCCCCAAAAA"]
     */

    /**
     * The idea is very simple:
     *
     * 1) Slide a window of size 10 across the string.
     * 2) Extract the current 10-letter substring.
     * 3) Store it in a HashMap (or HashSet).
     * 4) If you've seen it before, add it to the result.
     */

    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<=s.length()-10; i++){
            String text = s.substring(i, i+10);
            if(map.containsKey(text)){
                set.add(text);
            }else{
                map.put(text, 1);
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args){
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
