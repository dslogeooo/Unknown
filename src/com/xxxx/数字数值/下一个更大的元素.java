package com.xxxx.数字数值;

import java.util.Arrays;
import java.util.Scanner;

public class 下一个更大的元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = nextGreaterElement(n);
        System.out.println(res);
    }

    private static int nextGreaterElement(int n) {
        if(n <= 10){
            return -1;
        }
        String s = String.valueOf(n);
        int len = s.length();
        char[] ss = s.toCharArray();
        for(int i=len-2;i>=0;i--){
            boolean flag = false;
            for(int j=len-1;j>i;j--){
                if(ss[j] - '0' > ss[i] - '0'){
                    swap(ss,i,j);
                    Arrays.sort(ss,i+1,len);
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        if(Long.parseLong(new String(ss))>Integer.MAX_VALUE){
            return -1;
        }
        int res = Integer.parseInt(new String(ss));
        return res == n?-1:res;
    }

    private static void swap(char[] ss, int i, int j) {
        char t = ss[i];
        ss[i] = ss[j];
        ss[j] = t;
    }
}
