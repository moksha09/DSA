package org.example.dsa.slidingWindow;

public class MaximumSumOfSubArray {

    public int maxSum(int[] nums, int k){
        int n = nums.length;
        if(n<k) return -1;

        // get the sum of first window -
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        int maxSum = sum;

        // sliding window from k -> n-1
        for(int i=k; i<n; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
