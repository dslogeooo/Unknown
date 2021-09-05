package com.xxxx.数组;

import java.util.Scanner;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = majorityElement(nums);
        System.out.println(res);
    }

    private static int majorityElement(int[] nums) {
        int len = nums.length;
        if(len == 1 || len == 2){
            return nums[0];
        }
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(nums[i] == res){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                res = nums[i];
                count = 1;
//                System.out.println(res);
            }
        }
        return res;
    }
}
