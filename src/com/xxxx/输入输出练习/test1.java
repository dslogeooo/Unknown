package com.xxxx.输入输出练习;

//import java.util;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
//import java.*;

public class test1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            if(a == 0 && b == 0){
//                break;
//            }
//            System.out.println(a+b);
//        }
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//            String[] ss = str.split(" ");
//            if(ss.length == 1 && Integer.valueOf(ss[0])==0){
//                break;
//            }
//            int res = 0;
//            for(int i=0;i<ss.length;i++){
//                res += Integer.valueOf(ss[i]);
//            }
//            System.out.println(res);
//        }
//        while(sc.hasNextLine()){
//            int len = sc.nextInt();
//            if(len == 0){
//                break;
//            }
//            int res = 0;
//            for (int i = 0; i < len; i++) {
//                res += sc.nextInt();
//            }
//            System.out.println(res);
//        }
//        Scanner sc = new Scanner(System.in);
//        String ll = sc.nextLine();
//        int len = Integer.valueOf(ll);
//        for(int i =0;i<len;i++){
//            String str = sc.nextLine();
//            String[] ss = str.split(" ");
//            int res = 0;
//            for(int j=1;j<ss.length;j++){
//                res += Integer.valueOf(ss[j]);
//            }
//            System.out.println(res);
//        }
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//            String[] ss = str.split(" ");
//            int res = 0;
//            for (int i = 1; i < ss.length; i++) {
//                res += Integer.valueOf(ss[i]);
//            }
//            System.out.println(res);
//        }
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String ll = sc.nextLine();
//            int len = Integer.valueOf(ll);
//            String str = sc.nextLine();
//            String[] ss = str.split(" ");
//            Arrays.sort(ss);
//            for(int i=0;i<len;i++){
//                System.out.printf(ss[i] + " ");
//            }
//        }
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//            String[] ss = str.split(" ");
//            Arrays.sort(ss);
//            for (int i = 0; i < ss.length-1; i++) {
//                System.out.printf(ss[i] + ",");
//            }
//            System.out.println(ss[ss.length-1]);
//        }
//
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//            String[] ss = str.split(" ");
//            long res = 0;
//            for (int i = 0; i < ss.length; i++) {
//                res += Long.valueOf(ss[i]);
//            }
//            System.out.println(res);
//        }
        Scanner sc = new Scanner(System.in);
        String ll = sc.nextLine();
//        int len = Integer.valueOf(ll);
        String str = sc.nextLine();
        String[] ss = str.split(" ");
        int numsLen = ss.length;
        int[] nums = new int[numsLen];
        for (int i = 0; i < numsLen; i++) {
            nums[i] = Integer.valueOf(ss[i]);
//            System.out.println("nums["+i+"] = "+nums[i]);
        }
        String llCheck = sc.nextLine();
        int lenCheck = Integer.valueOf(llCheck);
        for(int i=0;i<lenCheck;i++){
            String strcheck = sc.nextLine();
            String[] sscheck = strcheck.split(" ");
            int begin = Integer.valueOf(sscheck[0]);
            int end = Integer.valueOf(sscheck[1]);
            int find = Integer.valueOf(sscheck[2]);
            int res = findNum(nums,begin,end,find);
            System.out.println(res);
        }
    }

    private static int findNum(int[] nums, int begin, int end, int find) {
        int res = 0;
        for(int i=begin-1;i<end;i++){
            if(nums[i] == find){
                res++;
            }
        }
        return res;
    }
}
