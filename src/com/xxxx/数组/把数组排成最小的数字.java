package com.xxxx.数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 把数组排成最小的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        String res = minNumber(nums);
        System.out.println(res);
    }

    private static String minNumber(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return String.valueOf(nums[0]);
        }
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(strs[i]);
//            System.out.println(strs[i]);
        }
        return sb.toString();
    }
}
