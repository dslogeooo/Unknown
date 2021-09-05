package com.xxxx.数组.二分查找;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 在排序数组中查找第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int len = nums.length;
        if(len == 0){
            return res;
        }
        if (len == 1 && nums[0] == target){
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        int left = searchLeft(nums,target);
        int right = searchRight(nums,target);

        res[0] = left;
        res[1] = right;
        return res;
    }

    private static int searchRight(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        while(begin<end){
            int mid = (begin+end+1)>>1;
            if(nums[mid] > target){
                end = mid-1;
            }else if(nums[mid] < target){
                begin = mid;
            }else{
                begin++;
            }
        }
        return nums[begin] == target?begin:-1;
    }

    private static int searchLeft(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        while(begin<end){
            int mid = (begin+end)>>1;
            if(nums[mid] < target){
                begin = mid+1;
            }else if(nums[mid] > target){
                end = mid;
            }else{
                end--;
            }
        }
        return nums[begin] == target?begin:-1;
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = searchRange(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}