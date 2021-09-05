package com.xxxx.排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class 数组中最大的k个元素 {


    public static int findKthLargest(int[] nums, int k) {
        heapsort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return nums[k - 1];
    }

    private static void heapsort(int[] nums) {
        int heapSize = nums.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            shiftdown(nums, i, heapSize);
        }
        while (heapSize > 1) {
            heapSize--;
            swap(nums, heapSize, 0);
            shiftdown(nums, 0, heapSize);
        }
    }

    private static void shiftdown(int[] nums, int index, int heapSize) {
        int half = heapSize >> 1;
        int v = nums[index];
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = nums[childIndex];
            int rightChild = childIndex + 1;
            if (rightChild < heapSize && nums[rightChild] > child) {
                childIndex = rightChild;
                child = nums[childIndex];
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


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = findKthLargest(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

