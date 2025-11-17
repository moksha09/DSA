package org.example.recursion;

// RECURSION EASY QUESTIONS AND PATTERNS
public class RecursionProblems1 {
    public static void main(String[] args){
        System.out.println(numberOfSteps2(14));
    }

    // Print n numbers from n to 1
    // WE ARE PRINTING THE NUMBER FIRST AND THEN CALLING THE RECURSIVE FUNCTION TO PRINT THE REST OF THE NUMBERS
    static void printNumber(int n){
        if(n<1){
            return;
        }
        System.out.println(n);
        printNumber(n-1);
    }
    // SEE THE DIFFERENCE EIN FUNCTION CALL BETWEEN THESE 2 FUNCTIONS

    // Print n numbers from 1 to n -
    // here we want to call the function before printing it -

    /**
     * example f(5) -
     * f(5) will first call f(4) to print [4,3,2,1] before printing 5 ->
     * f(4) will call f(3) to print [3,2,1] before printing 4 ->
     * f(3) will call f(2) to print [2, 1] before printing 3 ->
     * f(2) will call f(1) to print [1] before printing 2 ->
     * f(1) which is the base case will print 1 and be removed from call stack
     * so the call will go back to f(2) -> f(3) -> f(4) -> f(5)
     *
     * DIFFERENCE - WE ARE CALLING THE RECURSIVE FUNCTION TO PRINT THE REST OF NUMBERS, BEFORE THE PRINTING THE NUMBER ITSELF
     * @param n
     */
    static void printOneToN(int n){
        if(n<1){
            return;
        }
        printOneToN(n-1);
        System.out.println(n);
    }

    // merging both questions into one -
    static void printNtoOnetoN(int n){
        if(n<1){
            return;
        }
        System.out.println(n);
        printNtoOnetoN(n-1);
        System.out.println(n);
    }

    // Factorial of a number - product of n to 1
    /**
     *  f(n) = n*(n-1)*(n-2)*....2*1
     *  f(n) = n*f(n-1)
     */

    static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    // Sum of n to 1
    /**
     * f(n) = n + (n-1) + (n-2) + .... 2 +1
     * f(n) = n + f(n-1)
     */

    static int sumOfN(int n){
        if (n==1){
            return 1;
        }
        return n+sumOfN(n-1);
    }

    // Sum of digits
    /**
     * f(n) = (n%10) + (n/10)%10 + (n/100)%10 + ... + 0
     * f(n) = f(n/10) + (n%10)
     * example - f(1234) = f(123) + 4 = f(12) + 3+4 = f(1) + 2+3+4 = 1+2+3+4
     * base condition - F(0) = 0
     *
     */
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return sumOfDigits(n/10) + (n%10);
    }

    // Product of digits -

    /**
     * f(n) = f(n/10)*(n%10)
     * base condition - f(0) = 1
     * @param n
     * @return
     */
    static int productOfDigits(int n){
        if(n==0){
            return 1;
        }
        return productOfDigits(n/10)*(n%10);

    }

    // Revere a number using recursion -
    /**
     * 1234 => 4321
     *      = "4" + f(123)
     *      = "4" + "3" f(12)
     *      = "4" +"3" +"2" +f(1)
     *      = "4" +"3" +"2" +"1"
     *
     * 1234 -> 4 -> (4*10)+3 = 43 -> (43*10)+2 = 432 -> (432*10)+1 = 4321
     *
     * f(n) = (n%10) + f(n/10)
     */
    static int sum = 0;
    static int reverseNumber(int n){
        if(n==0){
            return sum;
        }
        sum = (sum*10) + (n%10);
        return reverseNumber(n/10);
    }

    // another way where we are not using a variable outside the function -
    // sometimes you might need some additional variables in the argument in that case -
    // MAKE ANOTHER FUNCTION - HELPER FUNCTION
    // here the additional argument we need is the total number of digits = arg
    // = rem*(10)^(arg)


    static int reverseNumber2( int n){
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);

    }
    private static int helper(int n, int digits){
        if(digits ==1){
            return n;
        }
        return (int) ((n%10)*(Math.pow(10, digits-1)) + helper(n/10, digits-1));
    }

    // Palindrome or not -
    /**
     * 12321 - true
     */

    static boolean palindrome(int n){
        if(n == reverseNumber(n)){
            return true;
        }
        return false;
    }

    // count number of zeros are in a number
    /**
     * 30204 -> 2
     * 30204%10 == count++
     */

    static int count = 0;
    static int countZeros(int n){
        if(n==0){
            return count;
        }
        if(n%10 ==0){
            count++;
        }
        return countZeros(n/10);
    }

    // or taking count inside argument, special example to return same value to above function calls
    static int countZeros2(int n){
        int count = 0;
        return helper2(n, count);
    }

    // how to pass a value to above calls
    static int helper2(int n, int count){
        if(n == 0){
            return count;
        }
        if(n%10 == 0){
            count++;
        }
        return helper2(n/10, count);
    }

    // 1342. Number of Steps to Reduce a Number to Zero - EASY
    /**
     * Given an integer num, return the number of steps to reduce it to zero.
     * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
     * Input: num = 14
     * Output: 6
     * Explanation:
     * Step 1) 14 is even; divide by 2 and obtain 7.
     * Step 2) 7 is odd; subtract 1 and obtain 6.
     * Step 3) 6 is even; divide by 2 and obtain 3.
     * Step 4) 3 is odd; subtract 1 and obtain 2.
     * Step 5) 2 is even; divide by 2 and obtain 1.
     * Step 6) 1 is odd; subtract 1 and obtain 0.
     */

    static int steps=0;
    static int numberOfSteps(int num) {
        if(num == 0){
            return steps;
        }
        if(num%2==0){
            num = num/2;
        } else{
            num = num-1;
        }
        steps++;
        return numberOfSteps(num);
    }

    // OR

    static int numberOfSteps2(int num){
        int steps = 0;
        return helper3(num, steps);
    }

    private static int helper3(int num, int steps){
        if(num == 0){
            return steps;
        }
        if(num%2==0){
            num = num/2;
        } else{
            num = num-1;
        }
        steps++;
        return helper3(num, steps);
    }
}
