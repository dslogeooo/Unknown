package com.xxxx.字符串;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class 删除字符串中所有相邻重复项 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = removeDuplicates(s);
        System.out.println(res);
    }

    private static String removeDuplicates(String s) {
        int len = s.length();
        if(len <= 1){
            return s;
        }
        StringBuilder sb = new StringBuilder(null);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(c);
                continue;
            }
            if(stack.peek() == c){
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
//        System.out.println(s);
        sb = sb.reverse();
        return sb.toString();
    }
}
