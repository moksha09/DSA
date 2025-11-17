package org.example.recursion;

public class RecursionExample {

    public static void main(String[] args){
        // print  -
//        print(1);

        int ans = fib(50);
        System.out.println(ans);
    }

    static void print(int n){
        if(n==5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        // This is called tailed recursion - i.e. when you have the last statement in the function call
        //.
        print(n+1); // since this is the last function call
    }

    /**
     *  RECURSION - Function calling itself
     *  1) Recursive call - recursive condition for the same-
     *  2) first main() function will go in stack.
     *  3) then print() function is called hence it will into stack and "1" wil be printed
     *  4) then we call the same function again with argument "2"
     *  5) hence print() function will again go in stack with argument "3" and "2" will be printed
     *  6) Similarly print() will again be called with argument"3" and it will be printed
     *  7) It will keep going until when we do a check when n=5,
     *  8) when n=5, it will print 5, and it will end
     *  9) BASE CONDITION IN RECURSION - It is a condition where our recursion will stop making new calls.(n==5)
     *  10) When n = 5, In the stack we will have ->
     *      print(5), print(4), print(3), print(2), print(1), main()
     *
     *  11) When n=5, it will print 5 and then return to the function call i.e from where it was first called
     *  i.e. print(4) methods -> print(n+1) line
     *  12) Hence all the print() method will be removed by stack one by ane and at end main will be removed too.
     *  13) If you are calling a function again and again, you can treat it as a separate call in stack, its not like its the same memory,
     *  each function call will take separate memory.
     *  14) You need to be careful with base condition else too many function call will make the memory of computer will exceed the limit and you will
     *  get the Stackoverflow error.
     *  15) a) cae condition, b) body of function, c) function call()
     *
     *  WHY DO WE NEED RECURSION ? -
     *  1) It helps us in solving bigger complex problems in a simple way. (eg - DP etc.)
     *  2) You can convert the recursion solutions into iterations(loops) and vice-versa.
     *  3) First -> solve using recursion -> then convert it into iteration to get a more simplified and efficient solution.
     *  as solving directly using iteration for complex problems is tough
     *  4) Space complexity for recursion is not constant because of recursive function calls.
     *  5) Helps us in breaking down bigger problems into smaller problems
     *
     *  VISUALIZING RECURSION(imp) - recursive tree
     *  1) main -> print(1) ->print(2) -> print(3) -> print(4) -> print(5)
     *      main <- print(1) <- print(2) <- print(3) <- print(4) <- print(5)
     *
     *
     *
     */

    /**
     * HOW TO IDENTIFY WHETHER A PROBLEM CAN BE SOLVED USING RECURSION OR NOT? -
     * 1) Practise
     * 2) Try to see if there is a smaller version of that problem that you can sole-
     * i.e break it down into smaller problem
     */

    // find nth fibonacci number -(sum of last 2 elements)

    /**
     * 0->0
     * 1->1
     * 2->1
     * 3->2
     * 4->3
     * 5->5
     * 6->8
     * 7->13
     * @param n
     * @return
     */
    // USING RECURSION
    static int fib(int n){

        // STEP1 - Break it down into smaller problems
        // [ fib(nth) = fib(n-1)+fib(n-2) ]  -> Is called RECURRENCE RELATION i.e. when you write recursion in a formula
        // as you can see one big problem = fib(n) is divided into 2 smaller problem = fib(n-1) and fib(n-2)
        // similarly fib(n-1) again can be divided into 2 more problem - fib(n-2)+ dib(n-3)
        // fib(4)  = fib(3) + fib(2)  [recursive tree you can draw)
        // fib(3) = fib(2) +fib(1)
        // fib(2) = fob(1) + fib(0)
        // fib(1) = 1
        // fib(0) = 0 (base case)

        // The base condition is represented by answers we already have provided - 0th fib = 0 and 1st fib = 1
        // Any recursive solution you can convert it into a formula

        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2); // this is not tailed recursion because fib(n-1) is not the last function call,
        // Rather the addition of [fib(n-1) and fib(n-1) ] is the last statement, which is not a function call but an addition expression,
        // , hence it's not a tailed recursion.

    }


    /**
     * NOTE - Try to build or draw the tree in paper or debug to get a clear picture
     * HOW TO UNDERSTAND AND APPROACH A PROBLEM -(IMP)
     * 1) Identify if you can break down the problem into smaller problems.
     * 2) From the recurrence relation if needed.
     * 3) Draw the recursive tree.
     * 4) About the tree:-
     *      a) See the flow of function how they are getting in stack.
     *      b) Identify and focus on left tree calls and right tree calls.
     *      c) Draw the tree and pointers again and again using pen and paper,
     *      use a debugger to see the flow.
     * 5) See how the values and what type of value are returned at each step. See where the function was coming out of?
     *    In the end you will be coming out of the main function.
     *
     *
     *
     *
     *
     *
     *
     */


}
