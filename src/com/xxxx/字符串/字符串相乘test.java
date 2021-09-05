package com.xxxx.字符串;

import java.util.Scanner;
/**
999
99
 * */
public class 字符串相乘test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String res = multiple(str1,str2);
        System.out.println(res);
    }

    private static String multiple(String str1, String str2) {
        if(str1.equals('0')||str2.equals('0')){
            return "0";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int[] res = new int[len1+len2];
        for(int i = len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int num = (str1.charAt(i)-'0') * (str2.charAt(j)-'0');

                int p1 = i+j;
                int p2 = i+j+1;

                num = num + res[p2];
                res[p2] = num % 10;
                res[p1] = num/10 + res[p1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if(res[0] == 0 && i==0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
