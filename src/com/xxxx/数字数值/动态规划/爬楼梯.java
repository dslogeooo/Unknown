package com.xxxx.数字数值.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 爬楼梯 {
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int [n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = climbStairs(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}