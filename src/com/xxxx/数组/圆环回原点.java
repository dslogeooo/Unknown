package com.xxxx.数组;

import java.util.Scanner;

public class 圆环回原点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int n = sc.nextInt();
        int res = backToOrigin(len,n);
        System.out.println(res);
    }

    private static int backToOrigin(int len,int n) {
        if(n <= 1){
            return 0;
        }
        int[][] dp = new int[n+1][len];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i-1][(j-1+len)%len] + dp[i-1][(j+1)%len];
            }
        }
        return dp[n][0];
    }
}
