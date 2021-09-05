package com.xxxx.数组.动态规划.背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 零钱兑换2 {
    public static int change(int amount, int[] coins) {
        int len = coins.length;
        if(amount == 0){
            return 1;
        }
        if(len == 0){
            return 0;
        }

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<len;i++){
            for(int j=0;j<=amount;j++){
                if(j >= coins[i]){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int amount = Integer.parseInt(line);
            line = in.readLine();
            int[] coins = stringToIntegerArray(line);

            int ret = change(amount, coins);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}