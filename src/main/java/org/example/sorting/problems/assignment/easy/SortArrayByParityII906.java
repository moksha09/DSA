package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;

public class SortArrayByParityII906 {
    static int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int even = 0;
        int odd = 1;

        for(int i=0; i<nums.length;i++){
            if(nums[i]%2 ==0){
                result[even] = nums[i];
                even = even+2;
            } else{
                result[odd] = nums[i];
                odd = odd+2;
            }
        }
        return result;

    }

    public static void main(String[] args){
        int[] nums = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
}
