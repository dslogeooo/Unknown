package com.xxxx.排序;

public class InsertionSort {
    public static void insertionsort01(int[] nums) {
        int len = nums.length;
        for (int begin = 1; begin < len; begin++) {
            int cur = begin;
            while (cur > 0 && nums[cur - 1] > nums[cur]) {
                swap(nums, cur - 1, cur);
                cur--;
            }
        }
    }

    public static void insertionsort02(int[] nums) {
        int len = nums.length;
        for (int begin = 1; begin < len; begin++) {
            int cur = begin;
            int v = nums[begin];
            while (cur > 0 && nums[cur - 1] > v) {
                nums[cur] = nums[cur - 1];
                cur--;
            }
            nums[cur] = v;
        }
    }

    public static void insertionsort03(int[] nums) {
        int len = nums.length;
        for (int begin = 1; begin < len; begin++) {
            int cur = begin;
            int v = nums[begin];
            int index = search(nums, begin);
            for (int i = begin; i > index; i--) {
                nums[i] = nums[i - 1];
            }
            nums[index] = v;
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
}
