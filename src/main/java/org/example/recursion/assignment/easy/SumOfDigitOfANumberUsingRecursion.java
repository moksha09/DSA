package org.example.recursion.assignment.easy;

public class SumOfDigitOfANumberUsingRecursion {

    static int sumOfDigit(int num){
        // base condition
        if(num%10==0){
            return num;
        }

        return (num%10)+sumOfDigit(num/10);
    }

    static int productOfTwoNum(int a, int b){
        if(b==1){
            return a;
        }
        return a+productOfTwoNum(a, b-1);
    }

    public static void main(String[] args){
        System.out.println(sumOfDigit(1234));
        System.out.println(productOfTwoNum(4,4));
    }
}
