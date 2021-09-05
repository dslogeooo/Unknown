package com.xxxx.数组;

import java.util.Arrays;
import java.util.Scanner;

public class 扑克牌中的顺子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        boolean res = isStraight(nums);
        System.out.println(res);
    }

    private static boolean isStraight(int[] nums) {
        int len = nums.length;
        if(len < 5){
            return false;
        }
        int zeroNum = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroNum++;
            }
        }
        Arrays.sort(nums);
        return nums[len - 1] - nums[zeroNum] <= 4;
    }
}
