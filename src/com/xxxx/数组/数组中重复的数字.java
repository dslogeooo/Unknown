package com.xxxx.数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数组中重复的数字 {
    public static int findRepeatNumber(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return 0;
        }
        for(int i=0;i<len;i++){
            int index = Math.abs(nums[i]);
//            System.out.println(index);
            if(nums[index] < 0){
                return Math.abs(index);
            }else{
                nums[index] = -nums[index];
            }
        }
        return 0;
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

            int ret = findRepeatNumber(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}