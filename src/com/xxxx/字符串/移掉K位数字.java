package com.xxxx.字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 移掉K位数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(" ");
        String num = ss[0];
        int k = Integer.parseInt(ss[1]);
        String res = removeKdigits(num,k);
        System.out.println(res);
    }

    private static String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == 0 || len <= k){
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
//        System.out.println(sb);
        for (int i = 0; i < k; i++) {
            int index = find(sb);
            sb.deleteCharAt(index);
        }
        while(sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    private static int find(StringBuilder sb) {
        int len = sb.length();
        int end = len-1;
        for (int i = 0; i < end; i++) {
            if((sb.charAt(i)-'0') > (sb.charAt(i+1)-'0')){
                return i;
            }
        }
        return end;
    }
}
