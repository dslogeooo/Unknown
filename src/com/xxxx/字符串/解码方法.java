package com.xxxx.字符串;

import java.util.Scanner;

public class 解码方法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = numDecodings(s);
        System.out.println(res);
    }

    private static int numDecodings(String s) {
        int len = s.length();
        if (len == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        char[] ss = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = ss[0] == '0' ? 0 : 1;
        for(int i=2;i<=len;i++){
            if(ss[i-2] == '1' || (ss[i-2] == '2' && ss[i-1]>='0' && ss[i-1]<='6')){
                if(ss[i-1] == '0'){
                    dp[i] = dp[i-2];
                }else{
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }else if(ss[i-1] == '0'){
                return 0;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }
}
