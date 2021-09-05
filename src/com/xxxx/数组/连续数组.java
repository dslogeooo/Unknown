package com.xxxx.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 连续数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = findMaxLength(nums);
        System.out.println(res);
    }

    private static int findMaxLength(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return 0;
        }
        int res = 0;
        int tempSum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(tempSum,-1);
        for (int i = 0; i < len; i++) {
            if(nums[i] == 0){
                tempSum -= 1;
            }else {
                tempSum += 1;
            }
            if(map.containsKey(tempSum)){
                res = Math.max(res,i-map.get(tempSum));
            }else{
                map.put(tempSum,i);
            }
        }
        return res;
    }
}
