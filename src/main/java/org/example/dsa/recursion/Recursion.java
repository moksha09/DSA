package org.example.dsa.recursion;

public class Recursion {

    public static void main(String[] args){
        // print result "3" 5 times -
        print1(3);
    }

    static void print1(int n){
        System.out.println(n);
        print2(n);
    }

    static void print2(int n){
        System.out.println(n);
        print3(n);
    }

    static void print3(int n){
        System.out.println(n);
        print4(n);
    }

    static void print4(int n){
        System.out.println(n);
        print5(n);
    }

    static void print5(int n){
        System.out.println(n);
    }

    /**
     *  Notes -
     *  1) All the function calls that happen in java happens in stack memory.
     *  2) How function calls work in languages -
     *  First main function is called -
     *  while the function is not finished executing, it will remain in stack.
     *  since main function is the first function that is called in any application, hence we can say that main function is
     *  the first function that goes in stack and last function to come out of stack.
     *  4) When a function is staying inside a stack that means the function call is currently going on.
     *
     *  5) after main(), print1() function will be called hence put in stack.
     *  6) print1() function will print n, then call print2() function
     *  7) so print2() will enter the stack memory, print "n" and call print3()
     *  8) similarily print3() will enter the stack memory and call print4()
     *  9) every function that is ongoing will be present in stack memory.
     *  10) At end we will have -
     *          print5(), print4(), print3(), print2(), print1() and main() in stack memory
     *  11) In print5(), after printing "n", since we dont have any other function call ->
     *  i.e. when a function finished executing it is removed from the stack and the flow of program is restored
     *  to where that function was called.(important)
     *
     *  12) Hence print5() will removed form the stack and call will go back inside the prin4() method where print5() method
     *  was called, and since there is nothing more to execute in print4() method , it will also be removed from the stack
     *  13) Similarly print4(), print3()m print2(), print1() and at end when we are finish executing the main function
     *  will also be removed from stack.
     *
     */

    /**
     *  RECURSION
     *
     *  1)
     */
}
