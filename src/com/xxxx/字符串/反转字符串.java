package com.xxxx.字符串;

import java.util.Scanner;

public class 反转字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        strs = strs.replaceAll(",","");
        strs = strs.replaceAll("\"","");
        char[] s = strs.toCharArray();
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }

    private static void reverseString(char[] s) {
        int begin = 0;
        int end = s.length-1;
        while(begin<end){
            char t = s[begin];
            s[begin] = s[end];
            s[end] = t;
            begin++;
            end--;
        }
    }
}
