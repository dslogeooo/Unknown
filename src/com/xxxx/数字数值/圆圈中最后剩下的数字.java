package com.xxxx.数字数值;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = lastRemaining(n,m);
        System.out.println(res);
    }

    private static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while(n > 1){
            index = (index + m - 1)%n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
