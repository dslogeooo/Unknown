package com.xxxx.数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 零钱兑换 {
    public static int coinChange(int[] coins, int amount) {

        int len = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,10001);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                if(j>=coins[i]){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount] == 10001?-1:dp[amount];


























//        if(amount == 0){
//            return 0;
//        }
//        int len = coins.length;
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,10001);
        //dp[0] = 0;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = 0; j <= amount; j++) {
//                if(j>=coins[i]){
//                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
//                }
//            }
//        }
//        return dp[amount]==10001?-1:dp[amount]a;

//        int len = coins.length;
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,10001);
//        dp[0] = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j <= amount; j++) {
//                if(j>=coins[i]){
//                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
//                }
//            }
//        }
//        return dp[amount] == 10001?-1:dp[amount];
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