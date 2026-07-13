package org.example.dsa.range_query;

public class RangeSumQueryMutable {

    // LC - 307 - Medium -
    /**
     * Given an integer array nums, handle multiple queries of the following types:
     *
     * Update the value of an element in nums.
     * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
     * Implement the NumArray class:
     *
     * NumArray(int[] nums) Initializes the object with the integer array nums.
     * void update(int index, int val) Updates the value of nums[index] to be val.
     * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
     *
     */

    int[] nums;
    int[] blocks;
    int n;
    int sqrt;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.sqrt = (int) Math.sqrt(n);
        this.blocks = new int[sqrt+1];

        int blocks_id = -1;
        // create blocks -
        for(int i=0; i<n; i++){
            if(i%sqrt == 0){
                // new block started -
                blocks_id++;
            }
            blocks[blocks_id] += nums[i];
        }
    }

    public void update(int index, int val) {
        int block_id = index/sqrt;
        blocks[block_id] = blocks[block_id] + (val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        // left -
        int ans = 0;
        while(left<right && left%sqrt!=0 ){
            ans = ans + nums[left];
            left++;
        }
        // middle -
        while(left+sqrt <= right){
            ans = ans + blocks[left/sqrt];
            left += left + sqrt;
        }
        // right -
        while(left <= right){
            ans = ans +nums[left];
            left++;
        }

        return ans;
    }

}
