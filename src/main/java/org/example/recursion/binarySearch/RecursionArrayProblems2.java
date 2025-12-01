package org.example.recursion.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class RecursionArrayProblems2 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 1, 5, 6, 7, 1, 1};
        int[] arr2 = { 3, 4, 5, 6, 0, 1, 2};
        System.out.println(findAllIndex(arr, 1));
        System.out.println(rotatedBS2(arr2, 0,arr2.length-1, 9));
    }

    // Find whether the given array is sorted in ascending order or not -

    /**
     * Normally without recursion we can solve using a pointer at start
     * compare if that is smaller that its next number move the pointer forward
     * if the pointer reaches the end successfully then its sorted
     * else its not sorted
     *
     *
     * @param arr
     * @return
     */
    static boolean isSorted(int[] arr){
        int start = 0;
        return helper(arr, start);
    }

    private static boolean helper(int[] arr, int start){
        if(start == arr.length-1){
            return true;
        }
        if(arr[start]<arr[start+1]){
            return helper(arr, start+1);
        }
        else return false;
    }

    // Linear Search in an array -
    /**
     *
     */
    static int linearSearch(int[] arr, int target){
        int index = 0;
        return helper2(arr, index, target);
    }
    private static int helper2(int[] arr, int index, int target){
        if(index==arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        } else{
            return helper2(arr, index+1, target);
        }
    }

    // Linear Search for multiple occurrences

    static List<Integer> findAllIndex(int[] arr, int target){
        int index=0;
        List<Integer> result = new ArrayList<>();
        return helper3(arr, index, target, result);
    }

    private static List<Integer> helper3(int[] arr, int index, int target, List<Integer> result){
        if(index==arr.length){
            return result;
        }
        if(arr[index] == target){
            result.add(index);
        }
        return helper3(arr, index+1, target, result);

    }

    // when you have to return an array list without passing it as an argument - not that optimized since we are creating a lot of objects again and again

    static List<Integer> listAllIndex2(int[] arr, int index, int target){
        List<Integer> result = new ArrayList<>();
        if(index==arr.length){
            return result;
        }
        if(arr[index] == target){
            result.add(index);
        }
        List<Integer> ansFromBelowCalls = listAllIndex2(arr, index+1, target);
        result.addAll(ansFromBelowCalls);
        return result;
    }

    // ROTATED BINARY SEARCH USING RECURSION
    /**
     * target = 1, output = 5
     * Rotated array = [5,6,7,8,9,1,2,3]
     */
    // First lets do rotated BS normally . In order to do BS in the array we need to first rotate in k times

    static int rotatedBS(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int middle = (start+end)/2;

            if(arr[middle] == target){
                return middle;
            }
            // checking whether the first half is sorted or not
            else if(arr[start]<=arr[middle]){
                // first half is sorted
                if(target>=arr[start] && target<arr[middle]){
                    // target lies in first half
                    end = middle-1;
                }
                else{
                    // target is not inside the first sorted half
                    start = middle+1;
                }
            } else{
                // The first half is not sorted -> that means the other half would be sorted so first check if the target is present in second half or not
                if(target>arr[middle] && target<=arr[end]){
                    // if target is found in second sorted half
                    start = middle+1;
                }
                else {
                    // else we will just reduce the search size my one(middle element and redo the search operation)
                    end = middle-1;
                }
            }
        }
        return -1;
    }

    // logic -
    /**
     * 1) checking if arr[middle] == target or not
     * 2) is arr[start]<=arr[mid] -> if yes(that means this half is sorted) -> check if target>=arr[start] && target<=ar[mid] -> if yes -> end = mid-1
     *                                                                                        -> if not -> start = mid+1
     * 3) when arr[start]>arr[mid] -> which means this half is not sorted so we can check if the target is in the other half which is sorted.
     *                             -> if( target>=arr[mid] && target<=arr[end]) -> if yes that means target is in sorted array -> start = mid+1
     *
     *                             -> else(i.e. target element is not present in the other sorted half) -> end = mid-1
     *
     */

    // using recursion -
    static int rotatedBS2(int[] arr, int start, int end, int target){
        if(start>end){
            return -1;
        }

        int mid = (start+end)/2;

        if(target == arr[mid]) return mid;

        else if (arr[start] < arr[mid]) {
            if(target>=arr[start] && target<arr[mid]){
                return rotatedBS2(arr, start, mid-1, target);
            } else{
                return rotatedBS2(arr,mid+1, end, target);
            }
        } else {
            if(target>arr[mid] && target<=arr[end]){
                return rotatedBS2(arr, mid+1,end,target);
            }
            else{
                return rotatedBS2(arr,start,mid-1,target);
            }
        }
    }
}
