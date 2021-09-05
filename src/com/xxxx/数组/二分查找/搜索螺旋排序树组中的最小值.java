package com.xxxx.数组.二分查找;

import java.util.Scanner;

public class 搜索螺旋排序树组中的最小值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = findMin(nums);
        System.out.println(res);
    }

    private static int findMin(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int begin = 0;
        int end = len-1;
        while(begin < end){
            int mid = (begin + end)>>1;
            if(nums[mid] > nums[end]){
                begin = mid+1;
            }else if(nums[mid] < nums[end]){
                end = mid;
            }else {
                end--;
            }
        }
        return nums[begin];
    }
}
