package com.xxxx.数组.动态规划.背包问题;

import java.util.Scanner;

public class 分割等和子集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        boolean res= canPartition(nums);
        System.out.println(res);
    }

    private static boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return false;
        }
        if(len == 2){
            return nums[0] == nums[1];
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum/2;
        int[] dp = new int[target+1];
        dp[0] = 0;
        for(int i=0;i<len;i++){
            for(int j=target;j>0;j--){
                if(j >= nums[i]){
                    dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
//                    System.out.println(dp[j]);
                }
            }
        }
//        System.out.println(dp[target]);
        return dp[target] == target;
    }
}
