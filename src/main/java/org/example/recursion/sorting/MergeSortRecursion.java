package org.example.recursion.sorting;

import java.util.Arrays;

public class MergeSortRecursion {
    public static void main(String[] args){
        int[] arr = {8,3,4,12,5,6};
        System.out.println(Arrays.toString(mergeSort(arr)));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int middle = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr,0,middle));
        int[] right = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] left, int[] right){
        int index1 = 0;  // for left array
        int index2 = 0;  // for right array
        int index3 = 0;  // for the result or merged array
        int[] result = new int[left.length+ right.length];

        while(index1<left.length && index2<right.length){
            if(left[index1]<right[index2]){
                result[index3] = left[index1];
                index1++;
            } else{
                result[index3] = right[index2];
                index2++;
            }
            index3++;
        }

        // it may be possible that one of the array is not complete - we need to copy the remaining elements to the result -
        while(index1<left.length){
            result[index3] = left[index1];
            index1++;
            index3++;
        }

        while(index2< right.length){
            result[index3] = right[index2];
            index2++;
            index3++;
        }

        return result;

    }


    // ALGORITHM FOR in place merge sort - here we wont be creating an extra copy of array and objects like we did in previous code -
    // Logic - if you don't want to create a copy of array in sub parts, then you can just pass the index values - start, middle and end to the next function call

    static void mergeSortInPlace(int[] arr, int start, int end){
        if(end-start==1){
            return;
        }
        int middle = (start+end)/2;

        mergeSortInPlace(arr, start, middle);
        mergeSortInPlace(arr, middle, end);

        mergeInPlace(arr, start, middle, end);
    }

    static void mergeInPlace(int[] arr, int start, int middle, int end){
        int index1 = start;  // for left array
        int index2 = middle;  // for right array
        int index3 = 0;  // for the result or merged array
        int[] result = new int[end-start];

        while(index1<middle && index2<end){
            if(arr[index1]<arr[index2]){
                result[index3] = arr[index1];
                index1++;
            } else{
                result[index3] = arr[index2];
                index2++;
            }
            index3++;
        }

        // it may be possible that one of the array is not complete - we need to copy the remaining elements to the result -
        while(index1<middle){
            result[index3] = arr[index1];
            index1++;
            index3++;
        }

        while(index2< end){
            result[index3] = arr[index2];
            index2++;
            index3++;
        }

        for(int l=0; l< result.length; l++){
            arr[start+l] = result[l];
        }
    }
}
