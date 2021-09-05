package com.xxxx.数组.回溯;

import java.util.List;
import java.util.Scanner;

/***
1,1,1
2
1
0
-1,-1,1
0
 */
public class 和为K的子数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int k = Integer.parseInt(sc.nextLine());
        int res = subarraySum(nums, k);
        System.out.println(res);
    }

    private static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                if(preSum[j] - preSum[i] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
