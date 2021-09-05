package com.xxxx.数字数值;

import java.util.Scanner;

public class pow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
//        System.out.println(Integer.MIN_VALUE);
        double res = myPow(x,n);
        System.out.println(res);

    }

    private static double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        if(x == -1){
            return n%2 == 0 ?1:-1;
        }
        long b = n;
        if(b == 0){
            return 1;
        }
//        if(n == Integer.MIN_VALUE){
//            return 0;
//        }
        boolean negative = false;

        if(b < 0){
            negative = true;
            b = -b;
        }
        double res = 1.0;
        while(b > 0){
            if(b % 2 == 1){
                res = res * x;
//                System.out.println(x);
//                System.out.println(res);
            }
            x = x * x;
            b = b / 2;
        }
        return negative ? 1/res : res;
    }
}
