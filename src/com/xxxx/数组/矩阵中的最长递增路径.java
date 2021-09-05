package com.xxxx.数组;

import com.eclipsesource.json.JsonArray;

import java.io.*;

import static java.lang.Math.max;

public class 矩阵中的最长递增路径 {
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        int r = 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                r = Math.max(r,dfs(matrix,i,j,res));
            }
        }
        return r;
    }

    private static int dfs(int[][] matrix, int i, int j,int[][] res) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length){
            return 0;
        }
        if(res[i][j] != 0){
            return res[i][j];
        }

        int r = 0;
        int left = 0;
        int right = 0;
        int top = 0;
        int down = 0;
        if(i>0 && matrix[i][j] < matrix[i-1][j]){
            top = dfs(matrix,i-1,j,res);
        }
        if(i<matrix.length-1 && matrix[i][j] <matrix[i+1][j]){
            down = dfs(matrix,i+1,j,res);
        }
        if(j>0 && matrix[i][j] < matrix[i][j-1]){
            left = dfs(matrix,i,j-1,res);
        }
        if(j<matrix[0].length - 1 && matrix[i][j] < matrix[i][j+1]){
            right = dfs(matrix,i,j+1,res);
        }
        r = Math.max(Math.max(top,down),Math.max(left,right))+1;
        res[i][j] = r;
        return r;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);

            int ret = longestIncreasingPath(matrix);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}