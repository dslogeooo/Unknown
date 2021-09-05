package com.xxxx.数字数值;

import java.util.Scanner;

public class 整数反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        int x = Integer.parseInt(strs);
        int res = reverse(x);
        System.out.println(res);
    }

    private static int reverse(int x) {
        boolean flag = false;
        if(x < 0){
            flag = true;
            x = Math.abs(x);
        }
        if(x % 10 == 0){
            x = x / 10;
        }
        String ss = String.valueOf(x);
        char[] nums = ss.toCharArray();
        int len = ss.length();
        int begin = 0;
        int end = len-1;
        while(begin<end){
            char temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
//            int t =
            if(res > (Integer.MAX_VALUE-(nums[i]-'0'))/10){
                return 0;
            }
            res = res *10 + (nums[i] - '0');
        }
        return flag?-res:res;
    }
}
