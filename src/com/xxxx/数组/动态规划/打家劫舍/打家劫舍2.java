package com.xxxx.数组.动态规划.打家劫舍;

import java.util.Scanner;

public class 打家劫舍2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = rob(nums);
        System.out.println(res);
    }
//1,2,3,4,5,1,2,3,4,5
    private static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] nums1 = new int[len-1];
        for (int i = 0; i < len - 1; i++) {
            nums1[i] = nums[i];
            System.out.print(nums1[i] +" ");
        }
        System.out.println();
        int[] nums2 = new int[len-1];
        for (int i = 0; i < len-1; i++) {
            nums2[i] = nums[i+1];
            System.out.print(nums2[i] +" ");
        }
        int res1 = real_rob(nums1);
        int res2 = real_rob(nums2);
        return Math.max(res1,res2);
    }

    private static int real_rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }
}
