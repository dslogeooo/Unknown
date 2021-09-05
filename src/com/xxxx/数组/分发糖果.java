package com.xxxx.数组;

import java.util.Scanner;

public class 分发糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] ratings = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            ratings[i] = Integer.parseInt(ss[i]);
        }
        int res = candy(ratings);
        System.out.println(res);
    }

    private static int candy(int[] ratings) {
        int len = ratings.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = 1;
        }

        for(int i=1;i<len;i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = Math.max(res[i],res[i-1]+1);
            }
        }
        for(int i=len-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i],res[i+1]+1);
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            System.out.println(res[i]);
            sum += res[i];
        }
        return sum;
    }
}
