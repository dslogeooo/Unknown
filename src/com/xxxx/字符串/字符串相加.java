package com.xxxx.字符串;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 字符串相加 {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0 || carry > 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;

            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            l1--;
            l2--;
        }
        return sb.reverse().toString();
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input.substring(1,input.length()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String num1 = stringToString(line);
            line = in.readLine();
            String num2 = stringToString(line);

            String ret = addStrings(num1, num2);

            String out = (ret);

            System.out.print(out);
        }
    }
}