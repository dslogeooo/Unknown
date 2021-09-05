package com.xxxx.数组;

import java.util.Scanner;


public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = maxProfit(nums);
        System.out.println(res);
    }

    private static int maxProfit(int[] nums) {
        int res = 0;
        int len = nums.length;
        if(len <= 1){
            return res;
        }
        for (int i = 1; i < len; i++) {
            if(nums[i] > nums[i-1]){
                res += (nums[i] - nums[i-1]);
            }
        }
        return res;
    }
}
