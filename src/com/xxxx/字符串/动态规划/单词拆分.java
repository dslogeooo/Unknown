package com.xxxx.字符串.动态规划;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
leetcodeleet
leet,code
 */
public class 单词拆分 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String strs = sc.nextLine();
        List<String> wordDict = new ArrayList<>();
        String[] ss = strs.split(",");
        for (int i = 0; i < ss.length; i++) {
            wordDict.add(ss[i]);
        }
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if (len == 0) {
            return false;
        }
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                if(dp[i] && wordDict.contains(s.substring(i,j))){
                    System.out.println((s.substring(i,j)));
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }
}
