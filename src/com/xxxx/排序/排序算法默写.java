package com.xxxx.排序;

import com.xxxx.排序.InsertionSort;


public class 排序算法默写 {

    public static void selectionsort(int[] nums) {
        int len = nums.length;
        for (int end = len - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin] > nums[maxIndex]) {
                    maxIndex = begin;
                }
            }
            swap(nums, maxIndex, end);
        }
    }

    private static int search(int[] nums, int index) {
        int begin = 0;
        int end = index;
        while(begin<end){
            int mid = (begin+end)>>1;
            if(nums[index] < nums[mid]){
                end = mid;
            }else{
                begin = mid+1;
            }
        }
        return begin;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 23, 6, 32, 7, 4, 87, 27, 43, 98, 65, 423, 7};
//        InsertionSort.insertionsort03(nums);
//        HeapSort.heapsort(nums);
//        MergeSort.mergesort(nums);
//        QuickSort.quicksort(nums);
//        BubbleSort.bubblesort(nums);
        System.out.println(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }


    }
}
