package com.xxxx.数组.利用归并排序;

import java.util.Scanner;

public class 数组中的逆序对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(" ");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = reversePairs(nums);
        System.out.println(res);
    }
    private static int res = 0;
    private static int[] leftArr;
    private static int reversePairs(int[] nums) {
        int len = nums.length;
        if(len<=1){
            return len;
        }
        leftArr = new int[len>>1];
        int begin = 0;
        int end = len;
        mergesort(nums,begin,end);
        return res;
    }

    private static void mergesort(int[] nums, int begin, int end) {
        if(end - begin < 2){
            return;
        }
        int mid = (begin + end)>>1;
        mergesort(nums,begin,mid);
        mergesort(nums,mid,end);
        merge(nums,begin,mid,end);
    }

    private static void merge(int[] nums, int begin, int mid, int end) {
        int li = 0;
        int le = mid-begin;
        int ri = mid;
        int re = end;
        int ai = begin;
        for (int i = li; i < le; i++) {
            leftArr[i] = nums[begin + i];
        }
        while(li<le){
            if(ri<re && nums[ri] < leftArr[li]){
                nums[ai] = nums[ri];
                ai ++;
                ri ++;
                res += (le-li);
            }else{
                nums[ai] = leftArr[li];
                ai++;
                li++;
            }
        }
    }
}
