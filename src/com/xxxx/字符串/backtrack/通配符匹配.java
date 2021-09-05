package com.xxxx.字符串.backtrack;

import java.util.Scanner;

//aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba
//a*******b
//
//*******
//aa
//*
public class 通配符匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        boolean res = isMatch(s, t);
        System.out.println(res);
    }

    private static boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        //递归超时!!!
//        return helper(s, p, lens, lent, 0, 0);
        if(lenp == 0){
            return lens == 0;
        }
        boolean[][] dp = new boolean[lens+1][lenp+1];
        dp[0][0] = true;
        for(int i=1;i<=lenp;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<=lens;i++){
            for(int j=1;j<=lenp;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[lens][lenp];
    }

    //递归超时
    private static boolean helper(String s, String p, int lens, int lenp, int i, int j) {
        if(j == lenp){
            return i == lens;
        }
        System.out.println("i = " + i + ", j = " + j);
        if(p.charAt(j) == '*'){
            if(i<lens){
                boolean a = helper(s,p,lens,lenp,i,j+1);
                boolean b = helper(s,p,lens,lenp,i+1,j);
                boolean c = helper(s,p,lens,lenp,i+1,j+1);
                System.out.println(a+" " + b + " "+ c);
                return (a||b)||c;
            }
        }
        if(i < lens && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
            return helper(s,p,lens,lenp,i+1,j+1);
        }
        return false;
    }
}
