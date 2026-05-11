package org.example.linked_list.problems;

public class HappyNumber_LC202 {
    /**
     * Write an algorithm to determine if a number 'n' is happy.
     * A happy number is a number defined by the following process.
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     * Return true if n is a happy number, and false if not.
     * @param n
     * @return
     */

    // Since there is a cycle - SLOW-FAST POINTER
    public static boolean isHappy(int n) {
       int slow = sumOfSquares(n);
       int fast = sumOfSquares(slow);

       if(slow==1 || fast==1){
           return true;
       }

       while(slow!=fast){
           if(slow == 1 || fast == 1){
               return true;
           }
           slow = sumOfSquares(slow);
           fast = sumOfSquares(sumOfSquares(fast));
       }
       return false;
    }

    private static int sumOfSquares(int n){
        int sum = 0;
        while(n!=0){
            sum = (int) (Math.pow(n%10,2) + sum);
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(isHappy(19));
    }
}
