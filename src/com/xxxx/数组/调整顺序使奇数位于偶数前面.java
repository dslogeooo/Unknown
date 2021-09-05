package com.xxxx.数组;

import java.util.Scanner;

public class 调整顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(" ");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int[] res = exchange(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] exchange(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            while (begin < end) {
                if (nums[end] % 2 == 0) {
                    end--;
                } else {
                    swap(nums,begin,end);
                    begin++;
                    break;
                }
            }
            while (begin<end){
                if(nums[begin] % 2 == 1){
                    begin++;
                }else{
                    swap(nums,begin,end);
                    end--;
                    break;
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
