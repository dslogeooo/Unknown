package com.xxxx.数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最小的k个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strlen = sc.nextLine();
        int k = Integer.parseInt(strlen);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int[] res = getLeastNumbers(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static int[] getLeastNumbers3(int[] arr, int k) {
        int[] res = new int[k];
        sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void sort(int[] nums) {
        int len = nums.length;
        int heapSize = len;
        for(int i=(heapSize>>1)-1;i>=0;i--){
            shiftDown(nums,i,heapSize);
        }
        heapSize--;
        while(heapSize>1){
            swap(nums,0,heapSize);
            heapSize--;
            shiftDown(nums,0,heapSize);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void shiftDown(int[] nums,int index, int heapSize) {
        int half = heapSize>>1;
        int v = nums[index];
        while(index<half){
            int childIndex = (index<<1)+1;
            int child = nums[childIndex];
            int rightchild = childIndex+1;
            if(rightchild<heapSize && nums[rightchild]>child){
                childIndex = rightchild;
                child = nums[childIndex];
            }
            if(v >= child){
                break;
            }
            nums[index] = child;
            index = childIndex;
        }
        nums[index] = v;
    }

    private static int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
