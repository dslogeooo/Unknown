package com.xxxx.数组.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最长重复子数组 {
    public static int findLength(int[] nums1, int[] nums2) {
        int res = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0 || len2 == 0){
            return 0;
        }
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for (int j = 1; j <= len2; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i][j]);
                    res = Math.max(dp[i][j],res);
                }
            }
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
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            int ret = findLength(nums1, nums2);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
