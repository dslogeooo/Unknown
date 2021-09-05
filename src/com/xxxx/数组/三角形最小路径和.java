package com.xxxx.数组;

import com.eclipsesource.json.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 三角形最小路径和 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+temp.get(j);
            }
        }

        return dp[0][0];

    }

    private static List<Integer> stringToIntegerList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        List<Integer> arr = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            arr.add(jsonArray.get(i).asInt());
        }
        return arr;
    }

    public static List<List<Integer>> stringToInt2dList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToIntegerList(cols.toString()));
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            List<List<Integer>> triangle = stringToInt2dList(line);

            int ret = minimumTotal(triangle);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}