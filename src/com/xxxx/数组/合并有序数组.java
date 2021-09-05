package com.xxxx.数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 合并有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<m+n;i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        while(m>0 && n>0){
            if(nums1[m-1]<nums2[n-1]){
                nums1[len-1] = nums2[n-1];
                len--;
                n--;
            }else{
                nums1[len-1] = nums1[m-1];
                len--;
                m--;
            }
        }
        while (n>0){
            nums1[len-1] = nums2[n-1];
            len--;
            n--;
        }
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
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            merge(nums1, m, nums2, n);
            String out = integerArrayToString(nums1);

            System.out.print(out);
        }
    }
}