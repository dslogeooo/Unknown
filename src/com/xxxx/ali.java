package com.xxxx;

import java.util.Scanner;
//001100   0 -2 2 2 -2 0
//101101

//000000   0 -2 0 0 -2 0
//101101

//000001   0 -2 0 0 -2 2
//101101
public class ali {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int len = Integer.parseInt(sc.nextLine());
        String A = sc.nextLine();
        String B = sc.nextLine();
//        System.out.println(A+B);
        int res = findmax(A, B);
        System.out.println(res);
    }

    private static int findmax(String a, String b) {
        int len = a.length();
        int[] as = new int[len];
        int[] bs = new int[len];
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == '0') {
                as[i] = -1;
            } else {
                as[i] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (b.charAt(i) == '0') {
                bs[i] = -1;
            } else {
                bs[i] = 1;
            }
        }
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Math.abs(as[i] + bs[i]);
//            System.out.println(nums[i]);
        }
        int res = get(nums);
        System.out.println(res);
        return res;
    }

    private static int get(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 2) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        int up = 0;
        int down = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                up = 1;
//                down = 0;
            } else if (nums[i - 1] > nums[i]) {
                down = 1;
//                up = 0;
            }
            if (up == 1 && down == 1) {
                down = 0;
                up = 0;
                continue;
            }
            if(up != down){
                res++;
            }

        }
        return res;
    }
}
/**
 * 001
 * 100
 * 0 -2 0
 * -1 -1  1
 * 1 -1 -1
 */