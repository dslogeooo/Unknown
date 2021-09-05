package com.xxxx.数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 接雨水 {
    public static int trap(int[] height) {
        int res = 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            int tempLeft = 0;
            int tempright = 0;
            for (int j = 0; j < i; j++) {
                if (tempLeft < height[j]) {
                    tempLeft = height[j];
                }
            }
            left[i] = tempLeft;
            for (int j = i + 1; j < height.length; j++) {
                if(tempright <height[j]){
                    tempright = height[j];
                }
            }
            right[i] = tempright;
        }
        for (int i = 1; i < height.length-1; i++) {
            if(height[i]<Math.min(left[i],right[i]))
            res += Math.min(left[i],right[i])-height[i];
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
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);

            int ret = trap(height);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
