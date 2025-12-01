package org.example.recursion.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationViaRecursion {

    static void permutations(String p, String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i=0; i<=p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permutations(first+ch+second, up.substring(1));
        }
    }

    // Returning the list of permutations -
    static List<String> permutationsList(String p, String up){

        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        // local to this call
        List<String> ans = new ArrayList<>();

        for(int i=0; i<=p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            ans.addAll(permutationsList(first+ch+second, up.substring(1)));
        }

        return ans;

    }

    // Counting number of permutation -
    static int permutationsCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);

        int count = 0;
        for(int i=0; i<=p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            count = count + permutationsCount(first+ch+second, up.substring(1));
        }

        return count;
    }

    // Counting number of permutation - by passing count argument -
    static int permutationsCount(String p, String up, int count){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);

        for(int i=0; i<=p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            count = count + permutationsCount(first+ch+second, up.substring(1));
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(permutationsCount("","abc",0));
    }
}
