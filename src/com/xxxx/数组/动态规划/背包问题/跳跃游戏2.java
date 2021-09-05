package com.xxxx.数组.动态规划.背包问题;

import java.util.Arrays;
import java.util.Scanner;

public class 跳跃游戏2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = jump(nums);
        System.out.println(res);
    }

    private static int jump(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(j<=i+nums[i]){
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
//                    System.out.print("dp["+j+"] = "+dp[j] + " ");
                }
            }
            System.out.println();
        }
        return dp[len - 1];
    }
}
