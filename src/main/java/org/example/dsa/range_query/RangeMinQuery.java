package org.example.dsa.range_query;

public class RangeMinQuery {

    static int[] nums;
    static int[] blocks;
    static int n;
    static int sqrt;

    public  RangeMinQuery(int[] nums){
        this.nums = nums;
        this.n = nums.length;;
        this.sqrt = (int) Math.sqrt(n);

        if(sqrt==0) sqrt = 1;
        this.blocks = new int[(n/sqrt) + 1];

        int blocks_id = -1;
        // create blocks -
        for(int i=0; i<n; i++){
            if(i%sqrt == 0){
                // new block started -
                blocks_id++;
                blocks[blocks_id] = nums[i];
            }
            blocks[blocks_id] = Math.min(nums[i], blocks[blocks_id]);
        }
    }

    public static int minRange(int left, int right){
        int min = nums[left];
        // left -
        while(left%sqrt!=0 && left<right){
            min = Math.min(min, nums[left]);
            left++;
        }
        // middle -
        while(left+sqrt <= right){
            min = Math.min(min, blocks[left/sqrt]);
            left = left + sqrt;
        }
        // right -
        while(left <= right){
            min = Math.min(min, nums[left]);
            left++;
        }
        return min;
    }

    public static void update(int index, int val){
        int block_index = index/sqrt;
        blocks[block_index] = Math.min(blocks[block_index], val);
        nums[index] = val;
    }

    public static void main(String[] args){
        RangeMinQuery obj = new RangeMinQuery(new int[] {1, 3, 5, 2, 7, 6, 3, 1, 4, 8});
        System.out.println(minRange(2, 7));

    }
}
