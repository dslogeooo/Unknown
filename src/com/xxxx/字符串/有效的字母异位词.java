package com.xxxx.字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 有效的字母异位词 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        boolean res = isAnagram2(s,t);
        System.out.println(res?"True":"False");
    }

    private static boolean isAnagram2(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lens != lent){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < lens; i++) {
            if(ss[i] != tt[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lens != lent){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }else if(map.get(c) == 1){
                map.remove(c);
            }else if(map.get(c) >= 2){
                map.put(c,map.get(c)-1);
            }
        }
        return map.size() == 0;
    }
}
