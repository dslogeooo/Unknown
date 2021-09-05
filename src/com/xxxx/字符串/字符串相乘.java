package com.xxxx.字符串;

import java.util.Scanner;

public class 字符串相乘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.split(" ");
        String num1 = ss[0];
        String num2 = ss[1];
        String res = multiply(num1, num2);
        System.out.println(res);
    }

    /**
     * 999
     * 99
     * ----------
     * 8991
     * 8991
     * ----------
     * 98901
     */
    private static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int sum = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;

                sum = sum + res[p2];
                res[p2] = sum%10;
                res[p1] = res[p1]+sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if(i==0 && res[0] == 0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
