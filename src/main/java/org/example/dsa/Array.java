package org.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Array <T> implements Iterable <T> {

    private T[] arr; // internal stack array
    private int len = 0; // length user thinks array is
    private  int capacity = 0; // Actual array size

    public Array(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }
    public Array() { this(16); }

    public int size() { return len; }
    public boolean isEmpty() {return size() == 0;}

    public T get(int index){ return arr[index];}
    public void set(int index, T elem) { arr[index] = elem;}

    public void clear() {
        for(int i= 0; i<capacity; i++){
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem){
        if(len+1 >= capacity){
            if(capacity==0) capacity=1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for(int i=0; i<len; i++){
                new_arr[i] = arr[i];
            }
            arr= new_arr;
        }
        arr[len+1] = elem;
    }

    public T removeAt(int rm_index) {
        if(rm_index >= len && rm_index<0) throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T[] new_arr = (T[]) new Object[len-1];
        for(int i=0, j=0; i<len; i++, j++){
            if(i==rm_index) j--;
            else new_arr[j] = arr[i];
        }
        arr= new_arr;
        capacity = len-1;
        return data;
    }

    public boolean remove(Object obj){
        for(int i=0; i<len; i++) {
            if(arr[i].equals(obj)) {
                removeAt(i); return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        for(int i=0; i<len; i++){
            if(arr[i] == obj){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    // Iterator for the array - iterator is still fats but not as fast as iterative for loop
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            public boolean hasNext() {
                return index<len;
            }
            public T next() {
                return arr[index++];
            }
        };
    }

    //Swapping values in arrays -
    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // maximum value of array -
    public int max(int[] arr){
//        int maxValue = Arrays.stream(arr).max().getAsInt();
//        return maxValue;
        int max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max) max = arr[i];
        }
        return max;
    }

    // reversing an array -
    public void reverse(int[] arr){
//        int[] reverse = new int[arr.length];
//        for(int i=0; i< arr.length; i++){
//            reverse[arr.length-1-i] = arr[i];
//        }
//        int length = arr.length;
//        for(int i=0, j=length-1; i<length/2; i++, j--){
//            swap(arr, i, j);
//        }

        // 2 pointer method
        int start = 0;
        int end = arr.length;
        while(start<end){
            swap(arr, start, end);
            start++; end--;
        }
    }

    // 1295. Find Numbers with Even Number of Digits
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            char[] element = Integer.toString(nums[i]).toCharArray();
            if (element.length % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int findNumbers2(int[] nums) {  // { 12, 345, 2, 4, 7689 }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numberOfDigits(nums[i]) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int numberOfDigits(int number){
        int digits = 0;
        while(number!=0){
            number = number/10;
            digits++;
        }
        return digits;
    }

    public int numberOfDigits2(int number){
        return (int) Math.log10(number) + 1;
    }

    public int findNumbers3(int[] nums) {  // { 12, 345, 2, 4, 7689 }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numberOfDigits2(nums[i]) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 1672. Richest Customer Wealth
    public int maximumWealth(int[][] accounts) {
    int maxWealth = 0;
    for(int[] row : accounts){
        int sum = 0;
        for(int elem : row){
            sum = sum+elem;
        }
        if(sum>maxWealth) maxWealth = sum;
    }
    return maxWealth;
    }


    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length*2];
        for(int i=0; i <nums.length; i++){
            arr[i] = nums[i];
            arr[i+nums.length] = nums[i];
        }
        return arr;
    }


    // Shuffle the array
//    Input: nums = [2,5,1,3,4,7], n = 3
//    Output: [2,3,5,4,1,7]
    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[2*n];

        for(int i=0; i <n; i++){
            arr[i*2] = nums[i];
            arr[(i*2)+1] = nums[n+i];
        }
        return arr;
    }


//    Kids with max candles -
//    Input: candies = [2,3,5,1,3], extraCandies = 3
//    Output: [true,true,true,false,true]

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(Arrays.stream(candies).toArray()).max().getAsInt();
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies>=max){
                result.add(true);
            }
            else result.add(false);
        }
        return result;
    }


    // Number of good pairs.
    // A pair (i, j) is called good if nums[i] == nums[j] and i < j.
    public int numIdenticalPairs(int[] nums) {
        int count =0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]) count++;
            }
        }
        return count;
    }

    public int numIdenticalPairs2(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int count=0;
        for(int num : nums){
            count = count+countMap.getOrDefault(num, 0);
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        return count;
    }


    // nums = [8,1,2,2,3] output - [4,0,1,1,3]
    // brute force - O(n*n)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int count =0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i]>nums[j]) count++;
            }
            result[i] = count;
            count = 0;
        }
        return result;
    }

    // create target array in given order -

    /**
    Given two arrays of integers nums and index. Your task is to create target array under the following rules:
    Initially target array is empty.
    From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
    Repeat the previous step until there are no elements to read in nums and index.
    Return the target array.
    It is guaranteed that the insertion operations will be valid.
     Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
     Output: [0,4,1,3,2]
     nums       index     target
     0            0        [0]
     1            1        [0,1]
     2            2        [0,1,2]
     3            2        [0,1,3,2]
     4            1        [0,4,1,3,2]
     **/
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            target.add(index[i], nums[i]);
        }

        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = target.get(i);
        }

        return result;
    }

    // check if sentance is panagram - the sentance should have atleadt one alphabet from a-z;

    //my approac -
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char c: sentence.toCharArray()){
            set.add(c);
        }
        if(set.size()==26) return true;
        return false;
    }

    //more efficient -
    public boolean checkIfPangram2(String sentence) {
        for(char i = 'a'; i<='z'; i++){
            if(sentence.indexOf(i)==-1) return false;
        }
        return true;
    }

    /*
     * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item.
     *  You are also given a rule represented by two strings, ruleKey and ruleValue.
     *
     * The ith item is said to match the rule if one of the following is true:
     *
     * ruleKey == "type" and ruleValue == typei.
     * ruleKey == "color" and ruleValue == colori.
     * ruleKey == "name" and ruleValue == namei.
     * Return the number of items that match the given rule.
     *
     * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]],
     *  ruleKey = "color",
     *  ruleValue = "silver"
           Output: 1
           Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int result=0;

        if(Objects.equals(ruleKey, "type")){
            for(List<String> elem: items){
                if(Objects.equals(elem.get(0), ruleValue)) result++;
            }

        }
        else if(Objects.equals(ruleKey, "color")){
            for(List<String> elem: items){
                if(Objects.equals(elem.get(1), ruleValue)) result++;
            }
        }
        else if(Objects.equals(ruleKey, "name")){
            for(List<String> elem: items){
                if(Objects.equals(elem.get(2), ruleValue)) result++;
            }
        }
        return result;

    }

    /* There is a biker going on a road trip.
    The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

     You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
       i and i + 1 for all (0 <= i < n) for all (0 <= i < n). Return the highest altitude of a point.

Input: gain = [-5,1,5,0,-7] - n = 5
Output: 1
Elevation gain - [0, -5, -4, 1, 1, -6] - n+1 = 6 - return 1
     */

    public int largestAltitude(int[] gain) {
        int result = 0;
        List<Integer> elev = new ArrayList<>();
        int current = 0;

        for(int i=0; i< gain.length; i++){
            current  = gain[i] + current;
            result = Math.max(result, current);
        }
        return result;

    }

    /**
     * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
     * To flip an image horizontally means that each row of the image is reversed
     * For example, flipping [1,1,0] horizontally results in [0,1,1].
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
     * For example, inverting [0,1,1] results in [1,0,0].
     *
     * Input: image = [[1,1,0],[1,0,1],[0,0,0]] -> [[0,1,1],[1,0,1],[0,0,0]] ->
     * Output: [[1,0,0],[0,1,0],[1,1,1]] -
     * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     */

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                result[i][j] = image[i][n-1-j]; // flip
                result[i][j] = result[i][j]^1; // reverse
            }
        }
        return result;
    }


    // Medium - Spiral matrix

    public List<Integer> spiralOrder(int[][] matrix) {   // mxn
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while(top<=bottom && left<=right){

            for(int i = left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;

    }

    // spiral matrix 2 - Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
    // Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

    public int[][] generateMatrix(int n) {

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int elem =1;

        int[][] result = new int[n][n];

        while(top<=bottom && left<=right){

            for(int i=left; i<=right; i++){
                result[top][i] = elem;
                elem++;
            }
            top++;
            for(int i=top; i<=bottom; i++){
                result[i][right] = elem;
                elem++;
            }
            right--;
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    result[bottom][i] = elem;
                    elem++;
                }
                bottom--;
            }
            if(left<=right){
                for(int i= bottom; i>=top; i--){
                    result[i][left] = elem;
                    elem++;
                }
                left++;
            }
        }
        return result;
    }

    /** Given an array of integers nums sorted in non-decreasing order,
     *  find the starting and ending position of a given target value.
     If target is not found in the array, return [-1, -1].
     You must write an algorithm with O(log n) runtime complexity.
     **/
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length==0) return new int[] {-1,-1};

        for(int i=0; i<nums.length;i++){
            if(nums[i] == target){
                result[0] = i;
                break;
            }
            if(i==nums.length-1) return new int[] {-1, -1};
        }

        for(int i=nums.length-1; i>=0;i--){
            if(nums[i] == target){
                result[1] = i;
                break;
            }
        }
        return result;
    }

    // product of array except self -
    public int[] productExceptSelf(int[] nums) {  // nums = { 1, 2, 3, 4, 5 }  n = 5
        int n = nums.length;
        int[] answer = new int[nums.length];
        int prefixProduct =1;
        int suffixProduct =1;

        for(int i=0; i<n; i++){
            answer[i] = 1;   // ans = {1, 1, 1, 1, 1,}
        }

        for(int i=0; i<n; i++){
            answer[i] = answer[i]*suffixProduct;    // answer = {1, 1, 2, 6, 24}  24*5
            suffixProduct = suffixProduct*nums[i];
        }
        for(int i=n-1; i>=0; i--){
            answer[i] = answer[i]*prefixProduct;   // answer = {,6*24*5,24}
            prefixProduct = prefixProduct*nums[i];
        }
        return answer;

    }

    // Hard

    // Max value of equation -










}
