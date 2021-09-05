package com.xxxx.字符串;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 字符串解码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = decodeString(str);
        System.out.println(res);
    }

    private static String decodeString(String str) {
        int len = str.length();
        if(len == 0){
            return "";
        }
        LinkedList<Integer> numstack = new LinkedList<>();
        LinkedList<String> strstack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c-'0';
            }else if(c >= 'a' && c <= 'z' || c >= 'A' && c<='Z'){
                sb.append(c);
            }else if(c == '['){
                numstack.push(num);
                num = 0;
                strstack.push(sb.toString());
                sb = new StringBuilder();
            }else{
                StringBuilder tempsb = new StringBuilder();
                tempsb.append(strstack.pop());
                int time = numstack.pop();
                for (int j = 0; j < time; j++) {
                    tempsb.append(sb.toString());
                }
                sb = tempsb;
//                System.out.println(sb);
            }
        }
        return sb.toString();
    }
}
