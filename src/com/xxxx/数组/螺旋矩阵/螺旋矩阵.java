package com.xxxx.数组.螺旋矩阵;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;




public class 螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int top = 0;
        int botton = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while(true){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(top>botton){
                break;
            }
            for(int i=top;i<=botton;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left>right){
                break;
            }
            for(int i=right;i>=left;i--){
                res.add(matrix[botton][i]);
            }
            botton--;
            if(top>botton){
                break;
            }
            for(int i=botton;i>=top;i--){
                res.add(matrix[i][left]);
            }
            if(left>right){
                break;
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

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);

            List<Integer> ret = spiralOrder(matrix);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}