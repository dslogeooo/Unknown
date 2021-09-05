package com.xxxx.数组.二分查找;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int len = ss.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.valueOf(ss[i]);
        }
        int res = findMin(nums);
        System.out.println(res);
    }

    private static int findMin(int[] nums) {
//        int res = nums[0];
        int len = nums.length;
//        Map<Integer,Integer> map = new HashMap<>();
//        map.getOrDefault()
        int begin = 0;
        int end = len-1;
        while(begin<end){
            int mid = (begin + end) >> 1;
            if(nums[mid] < nums[end]){
                end = mid;
            }else{
                begin = mid+1;
            }
        }
        return nums[begin];
    }
}
