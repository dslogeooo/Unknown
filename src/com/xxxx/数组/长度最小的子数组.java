package com.xxxx.数组;

import java.util.Scanner;

/**
 * 7
 * 2,3,1,2,4,3
 * 11
 * 1,2,3,4,5
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strtarget = sc.nextLine();
        int target = Integer.parseInt(strtarget);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < target) {
            return 0;
        }
        int begin = 0;
        int end = 0;
        int tempSum = 0;
        int res = Integer.MAX_VALUE;
        while (begin < nums.length || end < nums.length) {
            // tempSum += nums[end];
            if (end < nums.length && tempSum < target) {
                System.out.println("begin = " + begin + ", end = " + end + ", tempSum = " + tempSum);
                tempSum += nums[end];
                end++;
            } else if (begin < nums.length && tempSum > target) {
                System.out.println("begin = " + begin + ", end = " + end + ", tempSum = " + tempSum);
                res = Math.min(end - begin, res);
                tempSum -= nums[begin];
                begin++;
            }
            //
            else if (begin <= nums.length && end <= nums.length && tempSum == target) {
                System.out.println("begin = " + begin + ", end = " + end + ", tempSum = " + tempSum);
                res = Math.min(end - begin, res);
                tempSum -= nums[begin];
                begin++;
            } else {
                break;
            }
        }
        return res;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum < target) {
            return 0;
        }
        int end = 0;
        int begin = 0;
        int temp = 0;
        int res = len;
        while (end < len) {
            temp += nums[end];
            end++;
            while (temp >= target) {
                res = Math.min(res, end - begin);
                temp = temp - nums[begin];
                begin++;
            }
        }
        return res;
    }
}
