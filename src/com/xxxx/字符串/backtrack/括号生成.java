package com.xxxx.字符串.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 括号生成 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        int n = Integer.valueOf(strs);
        List<String> res = generateParenthesis(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        backTrack(res,new StringBuilder(),0,0, n);
        return res;
    }

    private static void backTrack(List<String> res, StringBuilder temp, int left, int right,int n) {
        if(left < right || left >n || right>n){
            return;
        }
        if(left == n && right == n){
            res.add(temp.toString());
            return;
        }
        if(left>=right){
            temp.append('(');
            backTrack(res,temp,left+1,right,n);
            temp.deleteCharAt(temp.length()-1);
            temp.append(')');
            backTrack(res,temp,left,right+1,n);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
