package com.xxxx.字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len<=1){
            return len;
        }
        int res = 0;
        int start = 0;
        Map<Character,Integer>map = new HashMap<>();
        for(int end=0;end<len;end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.min(start,map.get(c));
            }
            res = Math.max(res,end-start+1);
            map.put(c,end+1);
        }
        return res;
    }


    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
//        return JSON.value(input).toString();
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = lengthOfLongestSubstring(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}