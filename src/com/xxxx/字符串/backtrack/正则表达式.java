package com.xxxx.字符串.backtrack;

import java.util.Scanner;

/**
aa
*
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
        boolean res2 = isMatch2(s, t);
        System.out.println(res);
    }

    //动态规划:
    private static boolean isMatch2(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        if(lenp == 0){
            return lens == 0;
        }
        boolean[][] dp = new boolean[lens+1][lenp+1];
        dp[0][0] = true;
        for(int i=1;i<=lenp;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lenp; j++) {
                if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
                if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[lens][lenp];
    }

    //递归:
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
