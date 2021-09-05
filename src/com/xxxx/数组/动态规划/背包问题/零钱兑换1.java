package com.xxxx.数组.动态规划.背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 零钱兑换1 {
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if(amount == 0){
            return 0;
        }
        if(len == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,10001);
        dp[0] = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<=amount;j++){
                if(j>=coins[i]){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                    System.out.println("dp[" + j + "] = "+ dp[j]);
                }
            }
        }
        return dp[amount] != 10001?dp[amount]:-1;
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
            int[] coins = stringToIntegerArray(line);
            line = in.readLine();
            int amount = Integer.parseInt(line);

            int ret = coinChange(coins, amount);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}