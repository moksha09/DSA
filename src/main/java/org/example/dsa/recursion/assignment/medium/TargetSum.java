package org.example.dsa.recursion.assignment.medium;

public class TargetSum {

    /**
     * You are given an integer array nums and an integer target.
     * You want to build an expression out of nums by adding one
     * of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
     *
     * For example, if nums = [2, 1], you can add a '+' before 2
     * and a '-' before 1 and concatenate them to build the expression "+2-1".
     * Return the number of different expressions that you can build, which evaluates to target.
     *
     * Example 1:
     * Input: nums = [1,1,1,1,1], target = 3
     * Output: 5
     * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     *
     * Example 2:
     * Input: nums = [1], target = 1
     * Output: 1
     * @param nums
     * @param target
     * @return
     */
    static int findTargetSumWays(int[] nums, int target) {
        return find(nums, 0, target, 0);
    }

    static int find(int[] nums, int index,int target, int currentSum){
        // base case -
        if(index==nums.length){
            if(currentSum==target){
                return 1;
            }
            return 0;
        }

       int count = 0;
        // take the positive +nums[index]
        count = count + find(nums, index+1, target, currentSum+nums[index]);
        count = count+find(nums, index+1, target, currentSum-nums[index]);

        return count;

    }

    public static void main(String[] args){
        int[] nums = new int[] {43,1,49,22,41,1,11,1,24,10,26,49,33,4,20,19,44,42,2,37};
        System.out.println(find(nums, 0, 17, 0));
     }
}
