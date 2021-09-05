package com.xxxx.排序;


public class HeapSort {
    public static void heapsort(int[] nums) {
        int heapSize = nums.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            shiftDown(nums, i, heapSize);
        }
        while (heapSize > 1) {
            heapSize--;
            swap(nums, 0, heapSize);
            shiftDown(nums, 0, heapSize);
        }
    }

    private static void shiftDown(int[] nums, int index, int heapSize) {
        int v = nums[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = nums[childIndex];
            int rightIndex = childIndex + 1;
            if (rightIndex < heapSize && nums[rightIndex] > child) {
                childIndex = rightIndex;
                child = nums[rightIndex];
            }
            if (v >= child) {
                break;
            }
            nums[index] = child;
            index = childIndex;
        }
        nums[index] = v;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
