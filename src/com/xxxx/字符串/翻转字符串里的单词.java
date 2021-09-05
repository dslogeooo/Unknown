package com.xxxx.字符串;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 翻转字符串里的单词 {
    public static String reverseWords(String s) {
        if(s.length() <= 1){
            return s;
        }
        char[] ss = s.toCharArray();
        word_reverse(ss);
        reverse(ss,0,ss.length-1);
        return space_clean(ss);
    }
    public static String space_clean(char[] ss){
        int i=0;
        int j=0;
        int len = ss.length;
        while(j<len){
            while(j<len && ss[j] == ' '){
                j++;
            }
            while(j<len && ss[j] != ' '){
                ss[i] = ss[j];
                i++;
                j++;
            }
            while(j<len && ss[j] == ' '){
                j++;
            }
            if(j<len){
                ss[i] = ' ';
                i++;
            }
        }
        return new String(ss).substring(0,i);
    }
    public static void reverse(char[] ss,int begin,int end){
        while(begin<end){
            char t = ss[begin];
            ss[begin] = ss[end];
            ss[end] = t;
            begin++;
            end--;
        }
    }
    public static void word_reverse(char[] ss){
        int len = ss.length;
        int i=0;
        int j=0;
        while(j<len){
            if(j<len && ss[j] == ' '){
                j++;
            }
            i=j;
            while(j<len && ss[j] != ' '){
                j++;
            }
            reverse(ss,i,j-1);
        }
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

            String ret = reverseWords(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}