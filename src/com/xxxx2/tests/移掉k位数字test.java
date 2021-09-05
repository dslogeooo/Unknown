package com.xxxx2.tests;

import java.util.Scanner;

public class 移掉k位数字test {
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
        if(k == 0 || k >= len){
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
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
        for (int i = 0; i < len-1; i++) {
            if((sb.charAt(i)-'0')>(sb.charAt(i+1)-'0')){
                return i;
            }
        }
        return len-1;
    }
}
