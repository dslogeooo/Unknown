package com.xxxx.排序;

public class BubbleSort {
    public static void bubblesort(int[] nums){
        int len = nums.length;
        for(int end = len-1;end>0;end--){
            for(int begin = 1;begin<=end;begin++){
                if(nums[begin-1]>nums[begin]){
                    swap(nums,begin-1,begin);
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
