package com.xxxx.数组.动态规划;

import java.util.Scanner;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = maxSubArray(nums);
        System.out.println(res);
    }

    private static int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0]+nums[1],nums[1]);
        for(int i=2;i<len;i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
