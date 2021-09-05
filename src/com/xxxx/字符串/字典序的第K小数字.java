package com.xxxx.字符串;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 字典序的第K小数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = findKthNumber(n,k);
        System.out.println(res);
    }

    private static int findKthNumber(int n, int k) {
        String[] strs = new String[n];
        for (int i = 1; i <= n; i++) {
            strs[i-1] = String.valueOf(i);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(strs[i]);
        }
        return Integer.parseInt(strs[k-1]);
    }
}
