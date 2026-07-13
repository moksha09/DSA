package org.example.dsa.karpRabin;

public class KarpRabin {
    private final int PRIME = 101;

    private double calculateHash(String str){
        double hash = 0;
        for(int i=0; i<str.length(); i++){
            hash =  (hash + str.charAt(i)*Math.pow(PRIME, i));
        }
        return hash;
    }

    private double updateHash(double previousHash, char oldChar, char newChar, int patternLength){
        double newHash = (previousHash - oldChar)/PRIME;
        newHash =  (newHash + newChar*Math.pow(PRIME, patternLength-1));
        return newHash;
    }

    public void search(String text, String pattern){
        int patternLength = pattern.length(); // 5
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));

        // checking for evey i -
        for(int i=0; i<=text.length()-patternLength; i++){
            if(textHash == patternHash){
                if(text.substring(i, i+patternLength).equals(pattern)){
                    System.out.println("There is a match!!! Pattern found at index i - " + i);
                    break;
                }
            }
            if(i<text.length()-patternLength){
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i+patternLength), patternLength);
            }
        }
    }

    public static void main(String[] args){
        KarpRabin algo = new KarpRabin();
        algo.search("Hi Kunal, how are you?", "Kunal");
    }

}
