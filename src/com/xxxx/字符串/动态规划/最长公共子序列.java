package com.xxxx.字符串.动态规划;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最长公共子序列 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1==0||len2==0){
            return 0;
        }
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String text1 = stringToString(line);
            line = in.readLine();
            String text2 = stringToString(line);

            int ret = longestCommonSubsequence(text1, text2);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
