package com.xxxx.字符串;

import java.util.Scanner;

/**
 输入形式:
 4 4
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 */
public class 最大正方形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str1s = str1.split(" ");
        int m = Integer.valueOf(str1s[0]);
        int n = Integer.valueOf(str1s[1]);
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str2 = sc.nextLine();
//            String[] str2s = str2.split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = str2.charAt(j);
            }
        }
        int res = maximalSquare(matrix);
        System.out.println(res);
    }
    public static int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
