package com.xxxx.数组.接雨水及变形;
import java.io.*;
public class 柱状图中的最大矩形 {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return heights[0];
        }
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = -1;
        for(int i=1;i<len;i++){
            int temp = i-1;
            while(temp>=0 && heights[temp] >= heights[i]){
                temp = left[temp];
            }
            left[i] = temp;
        }
        right[len-1] = len;
        for(int i=len-2;i>=0;i--){
            int temp = i+1;
            while(temp <= len-1 && heights[i] <= heights[temp]){
                temp = right[temp];
            }
            right[i] = temp;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,(right[i] - left[i] - 1) * heights[i]);
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
            int[] heights = stringToIntegerArray(line);

            int ret = largestRectangleArea(heights);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}