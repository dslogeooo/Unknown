package com.xxxx;


import java.util.Scanner;
//00100
//11000
//00100
//11011
//01100
//11000
//00110
//11100

public class ttt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int len = Integer.parseInt(sc.nextLine());
        String A = sc.nextLine();
        String B = sc.nextLine();
//        System.out.println(A+B);
        int res = findmax(A,B);
        System.out.println(res);
    }

    private static int findmax(String a, String b) {
        int len = a.length();
        int res = 0;
        int[]nums = new int[len];
        for(int i=0;i<len;i++){
            if(a.charAt(i) != b.charAt(i)){
                nums[i] = 1;
//                System.out.println("i="+i+",nums[i] = "+nums[i]);
            }
        }
        if(nums[0] == 1){
            res++;
        }
        int count = 0;
        for(int i=1;i<len;i++){
            if(nums[i-1] == 1){
                count++;
                continue;
            }
            if(nums[i] == 1){
                res++;
            }
        }
        if(count == len){
            return 0;
        }
        return res;
    }
}