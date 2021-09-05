package com.xxxx.字符串;

import java.util.Scanner;

public class 验证回文串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean res = isPalindrome(s);
        if(res){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        if(len <= 1){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                sb.append(c);
            }else if(c>='A' && c<='Z'){
                sb.append((char)(c-'A'+'a'));
            }else if(c>='0' && c<='9'){
                sb.append(c);
            }else{
                continue;
            }
        }
        String ss = sb.toString();
        System.out.println(ss);
        int end = ss.length()-1;
        int begin = 0;
        while(begin<end){
            if(ss.charAt(begin) != ss.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
