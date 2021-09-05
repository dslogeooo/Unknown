package com.xxxx.数组.dfs.岛屿问题;

public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid.length==0||grid[0].length==0){
            return res;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return;
        }
        if(grid[i][j] != '1'){
            return;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '2';
        }

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

}

