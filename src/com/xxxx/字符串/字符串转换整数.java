package com.xxxx.字符串;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class 字符串转换整数 {

    public static int myAtoi(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int res = 0;
        int i=0;
        while(i<len && s.charAt(i) == ' '){
            i++;
        }
        if(i == len){
            return 0;
        }
        boolean negative = false;
        if(s.charAt(i) == '-'){
            i++;
            negative = true;
        }else if(s.charAt(i) == '+'){
            negative = false;
            i++;
        }else if(!Character.isDigit(s.charAt(i))){
            return 0;
        }

        int begin = i;
        while(i<len && Character.isDigit(s.charAt(i))){
            i++;
        }
        int end = i;
        String str = s.substring(begin,end);

        for (int j = 0; j < str.length(); j++) {
            int num = str.charAt(j)-'0';
            if(res <=(Integer.MAX_VALUE-num)/10){
                res = res * 10 + num;
            }else{
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return negative?-res:res;
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

            int ret = myAtoi(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}