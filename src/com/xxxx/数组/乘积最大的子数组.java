package com.xxxx.数组;

import java.util.Scanner;

public class 乘积最大的子数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = maxProduct(nums);
        System.out.println(res);
    }

    private static int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int maxLeft = 0;
        int tempLeft = 1;
        for (int i = 0; i < len; i++) {
            tempLeft = tempLeft * nums[i];
            if(tempLeft > maxLeft){
                maxLeft = tempLeft;
            }
            if(nums[i] == 0){
                tempLeft = 1;
            }
        }
        int maxRight = 0;
        int tempRight = 1;
        for(int i=len-1;i>=0;i--){
            tempRight = tempRight * nums[i];
            if(tempRight>maxRight){
                maxRight = tempRight;
            }
            if(nums[i] == 0){
                tempRight = 1;
            }
        }
        return Math.max(maxLeft,maxRight);
    }
}
