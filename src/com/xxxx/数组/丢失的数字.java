package com.xxxx.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 丢失的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = missingNumber(nums);
        System.out.println(res);
    }

    private static int missingNumber(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i],i);
        }
        for(int i=0;i<len;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return len;
    }
}
