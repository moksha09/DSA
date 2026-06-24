package org.example.dsa.recursion.assignment.easy;

public class Print1ToNWithoutLoop {

    static void print1ToN(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        print1ToN(n-1);
        System.out.println(n);
    }
    public static void main(String[] args){
        print1ToN(5);
    }
}
