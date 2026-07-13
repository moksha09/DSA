package org.example.dsa.karpRabin;

public class FindTheIndexOfFirstOccurence {

    // EASY -
    /**
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     *
     * Example 1:
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     *
     * Constraints:
     * 1 <= haystack.length, needle.length <= 104
     * haystack and needle consist of only lowercase English characters.
     */

    private static final int PRIME = 101;

    public static int strStr(String haystack, String needle) {
        int patternLength = needle.length();
        double needleHash = calculateHash(needle);
        double haystackHash = calculateHash(haystack.substring(0, patternLength));

        for(int i=0; i<=haystack.length()-patternLength; i++){
            if(needleHash == haystackHash){
                if(haystack.substring(i, i+patternLength).equals(needle)){
                    return i;
                }
            }
            haystackHash = updateHash(haystack.charAt(i), haystack.charAt(i+patternLength), haystackHash, patternLength);
        }
        return -1;
    }

    public static double calculateHash(String text){
        double hash = 0;
        for(int i=0; i<text.length(); i++){
            hash = hash + text.charAt(i)*Math.pow(PRIME, i);
        }
        return hash;
    }

    public static double updateHash(char oldChar, char newChar, double oldHash, int patternLength){
        double newHash = (oldHash-oldChar)/PRIME;
        newHash = newHash + newChar*Math.pow(PRIME, patternLength-1);
        return newHash;
    }

    public static void main(String[] args){
        System.out.println(strStr("a", "a"));
    }


}
