package com.xxxx.字符串.动态规划;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最长回文子串 {
    public static String longestPalindrome_dp(String s) {
        int len = s.length();
        if(len<=1){
            return s;
        }
        boolean[][]dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int left = 0;
        int maxLen = 0;
        for(int i=len-2;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j-i>=2){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = true;
                    }
                }

                if(dp[i][j] && (j-i+1)>maxLen){
                    left = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(left,left+maxLen);
    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1){
            return s;
        }
        int tmp=0;
        for (int i = 0; i < len; ++i)
        {
            if (s.charAt(i) != s.charAt(len-1-i)){
                break;
            }
            tmp++;
        }
        if(tmp == len){
            return s;
        }
        int maxleft = 0;
        int maxright = 0;
        int templen = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                if(isPalindrome(s.substring(i,j))){
                    if((j-i)>templen){
                        templen = (j-i);
                        maxleft = i;
                        maxright = j;
                    }
                }
            }
        }
        // System.out.println(templen);
        return s.substring(maxleft,maxright);
    }
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = longestPalindrome(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}