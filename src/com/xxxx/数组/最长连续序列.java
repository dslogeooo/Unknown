package com.xxxx.数组;

import java.util.Arrays;
import java.util.Scanner;

public class 最长连续序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.valueOf(ss[i]);
        }
        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    private static int longestConsecutive(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int res = 1;
        Arrays.sort(nums);
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                continue;
            }
            if((nums[i]-nums[i-1]) == 1){
                temp++;
                res = Math.max(res,temp);
            }else{
                temp = 1;
            }
        }
        return res;
    }
}
