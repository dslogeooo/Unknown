package com.xxxx.字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 有效的括号 {
    public static boolean isValid(String s) {
        if(s.length()%2 != 0){
            return false;
        }
        Stack<Character>stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '('||c == '[' || c == '{'){
                stack.push(c);
            }else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }else if(!stack.isEmpty() && c == ']'){
                if(stack.peek()=='['){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }else if(!stack.isEmpty() && c == '}'){
                if(stack.peek()=='{'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input.substring(1,input.length()-1);
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = isValid(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
