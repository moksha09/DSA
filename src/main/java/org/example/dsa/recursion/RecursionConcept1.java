package org.example.dsa.recursion;

public class RecursionConcept1 {
    public static void main(String[] args){
    func(5);
    }

    static void func(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        func(n--);  // will give stack over flow
    }

    /**
     * n-- vs --n
     *
     * n-- -> pass the value of n first then subtracts it afterward.
     * so in func(5) -> sout(5) -> then func(5) ->sout(5) -> func(5) -> .....
     */

    static void func2(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        func(--n);  //works
    }
}
