package com.xxxx.字符串;

import java.util.Scanner;

public class 反转字符串中的单词 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = reverseWords(s);
        System.out.println(res);
    }

    private static String reverseWords(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        char[] ss = s.toCharArray();
        int i = 0;
        int j = 0;
        while(j<len){
            if(s.charAt(j) != ' '){
                j++;
                continue;
            }
//            System.out.println("i= "+i+",j="+j);
            reverse(ss,i,j);
            i=j+1;
            j++;
        }
        reverse(ss,i,j);
        return new String(ss);
    }

    private static void reverse(char[] ss, int i, int j) {
        int begin = i;
        int end = j-1;
        while(begin < end){
            char t = ss[begin];
            ss[begin] = ss[end];
            ss[end] = t;
            begin++;
            end--;
        }
    }


}
