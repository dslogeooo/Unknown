package com.xxxx.字符串;

import java.util.Scanner;

public class 重复的字字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean res = repeatedSubstringPattern(s);
        System.out.println((res?"True":"False"));
    }

    private static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int midlen = len>>1;
        String temp = s.substring(midlen,len);
//        System.out.println(temp);
//        String reversetemp = reverse(temp);
        String reversetemp = temp;
//        System.out.println(reversetemp);
        for (int i = 0; i < reversetemp.length(); i++) {
            if(reversetemp.charAt(i) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private static String reverse(String temp) {
        StringBuilder sb = new StringBuilder();
        char[] ss = temp.toCharArray();
        int begin = 0;
        int end = ss.length-1;
        while(begin<end){
            char t = ss[begin];
            ss[begin] = ss[end];
            ss[end] = t;
            begin++;
            end--;
        }
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i]);
        }
        return sb.toString();
    }
}
