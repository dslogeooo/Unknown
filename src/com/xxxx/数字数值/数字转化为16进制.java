package com.xxxx.数字数值;

import java.util.Scanner;

public class 数字转化为16进制 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String res = toHex(num);
        System.out.println(res);
    }

    private static String toHex(int num) {
        if(num == 0){
            return "0";
        }
        String s = "0123456789abcdef";
        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            char c = ss[num & 0b1111];
            sb.append(c);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}
