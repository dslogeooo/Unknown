package com.xxxx.股票问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 买卖股票最佳时机1 {
    private static int maxProfit(int[] prices) {
        int res = 0;
//        for(int i=0;i<prices.length-1;i++){
//            for(int j=i+1;j<prices.length;j++){
//                if(res<prices[j]-prices[i]){
//                    res = prices[j] - prices[i];
//                }
//            }
//        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }
            res = Math.max(res,prices[i]-min);
        }
        return res;
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
            int[] prices = stringToIntegerArray(line);

            int ret = maxProfit(prices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}