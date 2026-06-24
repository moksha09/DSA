package org.example.dsa.recursion.assignment.easy;

public class SpecialFibonacci {

    static int specialFib(int a, int b, int n){
        if(n==0){
            return a;
        }
        if(n==1){
            return b;
        }
        return specialFib(a, b, n-1)^specialFib(a, b, n-2);
    }
    public static void main(String[] args){

    }
}
