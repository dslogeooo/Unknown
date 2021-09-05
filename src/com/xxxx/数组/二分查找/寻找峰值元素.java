package com.xxxx.数组.二分查找;

import java.util.Scanner;

public class 寻找峰值元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");

        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.valueOf(ss[i]);
        }
        int res = findPeakElement(nums);
        System.out.println(res);
    }

    private static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int begin = 0;
        int end = len-1;
        while(begin<end){
            int mid = (begin+end)>>1;
            if(nums[mid]<nums[mid+1]){
                begin = mid+1;
            }else{
                end = mid;
            }
        }
        return begin;
    }
}
