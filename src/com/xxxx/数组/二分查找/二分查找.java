package com.xxxx.数组.二分查找;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 二分查找 {
    public static int search(int[] nums, int target) {
        int res = -1;
        int begin = 0;
        int end = nums.length;
        while(begin<end){
            int mid = (begin+end)>>1;
            if(nums[mid]>target){
                end = mid;
            }else{
                begin = mid+1;
            }
            if(nums[mid] == target){
                res = mid;
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}