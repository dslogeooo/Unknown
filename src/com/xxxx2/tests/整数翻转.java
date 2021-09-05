package com.xxxx2.tests;

import java.util.Scanner;

public class 整数翻转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = Integer.parseInt(str);
//        System.out.println(num);
        int res = reverse(num);
        System.out.println(res);
    }

    private static int reverse(int num) {
//        System.out.println(num);
        boolean negative = false;
        if(num<0){
            num = Math.abs(num);
            negative = true;
        }
//        if(num < 10){
//            return num;
//        }
        int res = 0;
        while(num > 0){
            int temp = num % 10;
            num = num / 10;
            System.out.println("num = "+num+", temp = "+temp);
            if(res > (Integer.MAX_VALUE-temp)/10){
                return 0;
            }
            res = res * 10 + temp;
        }
        return negative?-res:res;
    }
}
