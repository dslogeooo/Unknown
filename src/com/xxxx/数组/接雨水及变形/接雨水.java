package com.xxxx.数组.接雨水及变形;
import java.io.*;
public class 接雨水 {
    public static int trap(int[] height) {
        int len = height.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return 0;
        }
        int res = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len-1; i++) {
            int tempLeft = 0;
            for(int j=0;j<i;j++){
                if(height[j] > tempLeft){
                    tempLeft = height[j];
                }
            }
            left[i] = tempLeft;
            int tempRight = 0;
            for(int j = i+1;j<len;j++){
                if(height[j] > tempRight){
                    tempRight = height[j];
                }
            }
            right[i] = tempRight;
        }
        for (int i = 1; i < len-1; i++) {
            if(height[i] < Math.min(left[i],right[i])){
                res += Math.min(left[i],right[i]) - height[i];
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
            int[] height = stringToIntegerArray(line);

            int ret = trap(height);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}