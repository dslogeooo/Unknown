package com.xxxx.字符串.backtrack;

import java.util.Scanner;
/**
输入形式:
 第一行words,
 第二行 3 4 表示行数和列数
 后面的表示boards
 :
ABCCED
3 4
A B C E
S F C S
A D E E

 * */
public class 单词搜索 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        String mnlen = sc.nextLine();
        String[] mn = mnlen.split(" ");
        int m = Integer.valueOf(mn[0]);
        int n = Integer.valueOf(mn[1]);
        char[][] boards = new char[m][n];
        for(int i=0;i<m;i++){
            String t = sc.nextLine();
            String[] ts = t.split(" ");
            for(int j=0;j<n;j++){
                boards[i][j] = ts[j].charAt(0);
            }
        }
        if(exist(boards,words)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    private static boolean exist(char[][] boards, String words) {
        int m = boards.length;
        int n = boards[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(backTrack(boards,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backTrack(char[][] boards, String words, int i, int j, int index) {
        if(index == words.length()){
            return true;
        }
        if(i<0 || i>=boards.length || j<0 || j>=boards[0].length){
            return false;
        }
        if(boards[i][j] != words.charAt(index)){
            return false;
        }
        char temp = boards[i][j];
        boards[i][j] = '.';
        boolean res = backTrack(boards,words,i+1,j,index+1)||backTrack(boards,words,i-1,j,index+1)||backTrack(boards,words,i,j+1,index+1)||backTrack(boards,words,i,j-1,index+1);
        boards[i][j] = temp;
        return res;
    }
}
