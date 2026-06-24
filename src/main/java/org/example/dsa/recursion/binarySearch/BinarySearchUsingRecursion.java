package org.example.dsa.recursion.binarySearch;

public class BinarySearchUsingRecursion {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearchUsingRecursion(arr,11,0,arr.length-1));

    }

    static int binarySearchUsingRecursion(int[] arr, int target, int start, int end){
        int mid = (start+end)/2;
        if(start>end){
            return -1;
        }
        if(arr[mid]==target) {
            return mid;
        }
        else if(arr[mid]<target){
            return binarySearchUsingRecursion(arr, target,mid+1, end);
        } else if(arr[mid]>target){
            return binarySearchUsingRecursion(arr, target,start, mid-1);
        }
        return -1;
    }

    /**
     *  WORKING WITH VARIABLES WITH RECURSION
     *  We have 3 variables types -
     *  a) variable present in argument
     *  b) in return type
     *  c) in body of function
     *
     *  Example - Binary Search -
     * a) checking if mid element is target or not - constant time complexity
     * b) dividing the array into 2 halves
     * c) then search in an array of size n/2
     *
     * Lets say F(n) is a function that performs BS
     * O(1) = constant time complexity for comparison
     * F(n/2) = dividing array in 2 halves.
     * [ F(n) = O(1) + F(n/2) ] => our recurrence relation
     *
     *  TYPES OF RECURRENCE RELATION -
     *  1) Linear recurrence relation - fibonacci number - Its subtracting it linearly hence our search space is reducing linearly
     *  2) divide and conquer recurrence relation - BS - Search space is reduced by a factor - hence faster
     */

    /**
     * 1) You will notice that in fib() when we were using recursion there were trees which were being repeated in LHS and RHS,
     * For example for fib(4) -> in LHS we had a subtree of f(2) , adn in RHS too we had a subtree of fib(2),
     * hence performing the same thing multiple time is just a waste of time and space -> fib() using recursion is not a efficient program
     *
     * HOW DO WE MAKE IS EFFICIENT ? -> DYNAMIC PROGRAMMING - if in the recursion calls 2 or more recursion calls are doing the same work dont
     * compute it again and again.
     *
     * important - WHENEVER YOU HAVE A FUNCTION THAT HAVE A RETURN TYPE - MAKE SURE YOU HAVE RETURN FOR THE FUNCTION
     *
     */
}
