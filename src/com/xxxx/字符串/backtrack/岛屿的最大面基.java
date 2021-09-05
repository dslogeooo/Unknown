package com.xxxx.字符串.backtrack;

import java.util.Scanner;

/**
8 13
0,0,1,0,0,0,0,1,0,0,0,0,0
0,0,0,0,0,0,0,1,1,1,0,0,0
0,1,1,0,1,0,0,0,0,0,0,0,0
0,1,0,0,1,1,0,0,1,0,1,0,0
0,1,0,0,1,1,0,0,1,1,1,0,0
0,0,0,0,0,0,0,0,0,0,1,0,0
0,0,0,0,0,0,0,1,1,1,0,0,0
0,0,0,0,0,0,0,1,1,0,0,0,0
 */
public class 岛屿的最大面基 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] mn = strs.split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine();
            String[] ss = str.split(",");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(ss[j]);
            }
        }
        int res = maxAreaOfIsland(grid);
        System.out.println(res);
    }

    private static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    int temp = dfs(grid,i,j);
                    res = Math.max(res,temp);
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i<0||i>=grid.length || j<0||j>=grid[0].length){
            return 0;
        }
        if(grid[i][j] != 1){
            return 0;
        }
        if(grid[i][j] == 1){
            grid[i][j] = 2;
        }

        return 1+dfs(grid,i+1,j)
                +dfs(grid,i,j+1)
                +dfs(grid,i-1,j)
                +dfs(grid,i,j-1);
    }
}
