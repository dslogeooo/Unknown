package com.xxxx.数组.动态规划.背包问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
1,1,1,1,1
3
 * 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
 * 1
 */
public class 目标和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int target = Integer.parseInt(sc.nextLine());
        int res = findTargetSumWays2(nums, target);
        System.out.println(res);
    }

    private static int findTargetSumWays2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if(len == 1){
            return (nums[0] == target || nums[0] == -target)?1:0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target) {
            return 0;
        }
        sum = sum + target;
        if (sum % 2 == 1) {
            return 0;
        }
        sum = sum / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j-nums[i]];
                    System.out.println("dp["+j+"] = "+dp[j]);
                }
            }
        }
        return dp[sum];
    }

    //回溯超时!
    private static int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0] == target ? 1 : 0;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        int tempSum = 0;
        boolean[] visited = new boolean[len];
        backTrack(res, temp, nums, target, visited, tempSum, index);
        return res.size();
    }

    private static void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, boolean[] visited, int tempSum, int index) {
        int len = nums.length;
        if (index == len) {
            if (tempSum == target) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        tempSum -= nums[index];
        temp.add(nums[index]);
        visited[index] = true;
        backTrack(res, temp, nums, target, visited, tempSum, index + 1);
        visited[index] = false;
        tempSum += nums[index];
        temp.remove(temp.size() - 1);

        tempSum += nums[index];
        temp.add(nums[index]);
        visited[index] = true;
        backTrack(res, temp, nums, target, visited, tempSum, index + 1);
        visited[index] = false;
        tempSum -= nums[index];
        temp.remove(temp.size() - 1);

    }
}
