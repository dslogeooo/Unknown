package com.xxxx.数组;

import java.util.Scanner;

public class 跳跃游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        boolean res = canJump(nums);
        System.out.println(res?"True":"False");
    }

    private static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return true;
        }
        for(int i=len-2;i>=0;i--){
            if(nums[i] == 0){
                System.out.println("i="+i);
                boolean flag = false;
                for(int j=i-1;j>=0;j--){
                    if(nums[j] + j > i){
                        flag = true;
                    }
                }
                if(flag == false){
                    return false;
                }
            }
        }
        return true;
    }
}
