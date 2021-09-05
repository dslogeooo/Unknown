package com.xxxx.数组;

import java.util.Scanner;

public class 求数列的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String strs = sc.nextLine();
            String[] ss = strs.split(" ");
            int n = Integer.parseInt(ss[0]);
            int m = Integer.parseInt(ss[1]);
//            System.out.println("n = "+n+"m = "+m);
            double res = getSum(n,m);
            System.out.printf("%.2f",res);
        }
    }

    private static double getSum(int n, int m) {
        if(m == 1){
            return n;
        }
        double num = n;
        double res = n;

        for(int i=0;i<m-1;i++){
            num = find(num);
            res += num;
            System.out.println(res);
        }
        return res;
    }

    private static double find(double num) {
        return Math.sqrt(num);
    }
}
