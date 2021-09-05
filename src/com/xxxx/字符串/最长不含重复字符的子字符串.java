package com.xxxx.字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = lengthOfLongestSubstrin(s);
        System.out.println(res);
    }

    private static int lengthOfLongestSubstrin(String s) {
        int len = s.length();
        if(len <= 1){
            return len;
        }
        int begin = 0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)){
                begin = Math.max(begin,map.get(c));
            }
            res = Math.max(res,(end-begin+1));
            map.put(c,end+1);
        }
        return res;
    }
}
