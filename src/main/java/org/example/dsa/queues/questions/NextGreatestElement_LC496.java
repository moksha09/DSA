package org.example.dsa.queues.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreatestElement_LC496 {

    // first lets try to find the next greatest element of a simple array - [4,1,2,5,9]

    public static HashMap<Integer, Integer> findNextGreatestElement(int[] nums2){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        stack.push(0);

        for(int i=1; i< nums2.length; i++){
            while(!stack.empty() && nums2[i]>nums2[stack.peek()]){
                int popped = stack.pop();
                map.put(nums2[popped], nums2[i]);
            }
            stack.push(i);
        }

        while(!stack.empty()){
            int popped = stack.pop();
            map.put(nums2[popped], -1 );
        }
        return map;
    }

    // then the apply that to the lc question -
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> result = findNextGreatestElement(nums2);
        int[] answer = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            answer[i] = result.get(nums1[i]);
        }

        return answer;
    }

    public static void main(String[] args){
        int[] nums1 = new int[] {4,1,2};
        int[] nums2 = new int[] {1,3,4,2};
//        HashMap<Integer, Integer> result = findNextGreatestElement(nums2);
//        System.out.println(result);

        int[] answer = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(answer));
    }
}
