package com.xxxx.字符串;

import java.util.Scanner;

/**
3 3
1,2,3
4,5,6
7,8,9
 * */
public class 对角线遍历 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strmn = sc.nextLine();
        String[] mn = strmn.split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++){
            String strs = sc.nextLine();
            String[] ss = strs.split(",");
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(ss[j]);
            }
        }
        int[] res = findDiagonalOrder(mat);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+",");
        }
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] res = new int[row * col];
        if(row == 0 || col == 0){
            return res;
        }
        int r = 0;
        int c = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            if((r+c)%2 == 0){
                if(c == col-1){
                    r++;
                }else if(r == 0){
                    c++;
                }else{
                    r--;
                    c++;
                }
            }else{
                if(r == row-1){
                    c++;
                }else if(c == 0){
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
