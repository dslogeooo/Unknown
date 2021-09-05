package com.xxxx.字符串;

import java.util.Scanner;

public class 压缩字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("\"","");
        System.out.println(str);
        String[] ss = str.split(",");
        char[] chars = new char[ss.length];
        for (int i = 0; i < ss.length; i++) {
            chars[i] = ss[i].charAt(0);
        }
        int res = compress(chars);
        for (int i = 0; i < res; i++) {
            System.out.print(chars[i]);
        }
    }

    private static int compress(char[] chars) {
        int len = chars.length;
        if(len == 1){
            return 1;
        }
        int count = 1;
        int index = 0;
        for(int i=1;i<len;i++){
//            char c = chars[i];
            if(chars[i] == chars[i-1]){
                count++;
                continue;
            }else{
                chars[index] = chars[i-1];
                index++;
            }
            if(count>1){
                String num = String.valueOf(count);
                System.out.println(num);
                for (int j = 0; j < num.length(); j++) {
                    chars[index] = num.charAt(j);
                    index++;
                }
                count = 1;
            }
        }
        chars[index] = chars[len-1];
        index++;
        if(count>1){
            String num = String.valueOf(count);
            for (int j = 0; j < num.length(); j++) {
                chars[index] = num.charAt(j);
                index++;
            }
        }
        return index;
    }
}
