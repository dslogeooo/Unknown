package com.xxxx.数组.双指针;

import java.util.Scanner;

public class 盛水最多的容器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] height = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            height[i] = Integer.parseInt(ss[i]);
        }
        int res = maxArea(height);
        System.out.println(res);
    }

    private static int maxArea(int[] height) {
        int len = height.length;
        if(len == 1){
            return 0;
        }
        if(len == 2){
            return Math.min(height[0],height[1]);
        }

        int res = 0;
        int begin = 0;
        int end = len-1;
        while(begin < end){
            int hi = height[begin];
            int he = height[end];
            res = Math.max(res,((end-begin) * Math.min(hi,he)));
            if(hi < he){
                begin++;
            }else{
                end--;
            }
        }
        return res;
    }
}
