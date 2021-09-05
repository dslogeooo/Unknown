package com.xxxx.字符串;

import java.util.Scanner;

public class 最长公共前缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        String res = longestCommonPrefix(ss);
        System.out.println(res);
    }

    private static String longestCommonPrefix(String[] ss) {
        int len = ss.length;
        if(len==0){
            return "";
        }
        String str = ss[0];
        int res = str.length();
        for (int i = 1; i < ss.length; i++) {
            String temp = ss[i];
            int tempMax = 0;
            int ll = Math.min(str.length(),temp.length());
            for (int j = 0; j < ll; j++) {
                if(str.charAt(j) == temp.charAt(j)){
                    tempMax++;
//                    System.out.println(tempMax);
                }else{
                    break;
                }
            }
            res = Math.min(res,tempMax);
        }
        return str.substring(0,res);
    }
}
