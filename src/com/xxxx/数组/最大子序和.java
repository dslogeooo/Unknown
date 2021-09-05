package com.xxxx.数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最大子序和 {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int tempsum = 0;
            for(int j=i;j<nums.length;j++){
                tempsum += nums[j];
                if(tempsum>max){
                    max = tempsum;
                }
            }
        }
        return max;
    }
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            res = Math.max(res,sum);
            if(sum<0){
                sum = 0;
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
            int[] nums = stringToIntegerArray(line);

            int ret = maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}