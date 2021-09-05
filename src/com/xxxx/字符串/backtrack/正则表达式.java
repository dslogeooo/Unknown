package com.xxxx.字符串.backtrack;

import java.util.Scanner;

/**

.*
mississippi
mis*is*ip*.
 */
public class 正则表达式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        boolean res = isMatch(s, t);
        System.out.println(res);
    }

    private static boolean isMatch(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        return backTrack(s, t, lens, lent, 0, 0);
    }

    private static boolean backTrack(String s, String t, int lens, int lent, int i, int j) {
        if (j == lent) {
            return i == lens;
        }
        if (j < lent - 1 && t.charAt(j + 1) == '*') {
            if (i < lens && (s.charAt(i) == t.charAt(j) || t.charAt(j) == '.')){
                return backTrack(s,t,lens,lent,i+1,j) || backTrack(s,t,lens,lent,i,j+2);
            }else{
                return backTrack(s,t,lens,lent,i,j+2);
            }
        }
        if(i < lens && (s.charAt(i) ==  t.charAt(j) || t.charAt(j) == '.')){
            return backTrack(s,t,lens,lent,i+1,j+1);
        }
        return false;
    }
}
