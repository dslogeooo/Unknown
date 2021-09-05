package com.xxxx.数字数值;

import java.util.Scanner;

public class 第N位数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = findNthDigit(n);
        System.out.println(res);
    }

    private static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long num = n;
        long size = 1;
        long max = 9;
        while (num - max *size> 0) {
            num = num - max * size;
            size++;
            max *= 10;
        }
        long count = num / size;
        long left = num % size;
//        System.out.println("count = "+count + ",left = "+left);
        if (left == 0) {
//            System.out.println(Math.pow(10,size-1) + count - 1);
            double res = (Math.pow(10,size-1) + count - 1)%10;
            return (int) res;
        }else{
            double res = (Math.pow(10,size-1) + count) / Math.pow(10,size-left) % 10;
            return (int) res;
        }

    }
}
