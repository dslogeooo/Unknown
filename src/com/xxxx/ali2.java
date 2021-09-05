package com.xxxx;

import java.util.Scanner;

public class ali2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int m = (int)(Math.sqrt(b+c/2.0) - Math.sqrt(a-c/2.0));
        int n = (int)(Math.pow(a+c/2.0,3)-Math.pow(a+b/2.0,3));
        int res= 0;
        for(int i=a;i<b+c;i++){
            for(int j=a;j<a+b;j++){
                if(i*i - j*j*j<c){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
