package com.xxxx.输入输出练习;

import java.util.*;

//作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
// 为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串
// 珠里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的
// 手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜
// 色在任意连续m个串珠中出现了至少2次。
//第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50)
// 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。接下来依次读入num_i
// 个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
/**
6 2 3
3 1 2 3
0
2 2 3
0
1 2
1 3
 */
//第一种颜色出现在第1颗串珠，与规则无冲突。
//第二种颜色分别出现在第 1，3，4颗串珠，第3颗与第4颗串珠相邻，所以不合要求。
//第三种颜色分别出现在第1，3，5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
//总计有2种颜色的分布是有问题的。
//这里第2颗串珠是透明的。
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.split(" ");
        int n = Integer.valueOf(ss[0]);
        int m = Integer.valueOf(ss[1]);
        int c = Integer.valueOf(ss[2]);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String singleshouchuan = sc.nextLine();
            String[] singles = singleshouchuan.split(" ");
            int count = Integer.valueOf(singles[0]);
            List<Integer> list = new ArrayList<>();
            if(count == 0){
                map.put(i,list);
                continue;
            }
            for(int j=1;j<=count;j++){
//                System.out.print(Integer.valueOf(singles[j])+" ");
                list.add(Integer.valueOf(singles[j]));
            }
//            System.out.println("i = "+ i);
            map.put(i,list);
        }
        int res = finderror(map,m,c);
        System.out.println(res);
    }

    private static int finderror(Map<Integer, List<Integer>> map, int m, int c) {
        int res = 0;
        int len = map.size();
        for(int j=1;j<=c;j++){
            int[] index = new int[len];
            for(int i=0;i<len;i++){
                List<Integer> list = map.get(i);
                if(list.contains(j)){
                    index[i] = 1;
                }
//                System.out.print(index[i] + " ");
            }
//            System.out.println(check(index,m));
            if(check(index,m)){
                res++;
            }
//            System.out.println();
        }
        return res;
    }

    private static boolean check(int[] index, int m) {
        int len = index.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(index[i] == 1){
                list.add(i);
            }
        }
        int size = list.size();
        if(size == 0 || size == 1){
            return false;
        }
        for(int i=0;i<(size-1);i++){
            if((list.get(i+1)-list.get(i))<m){
                return true;
            }
        }
        if((list.get(0)+len-list.get(size-1))<m){
            return true;
        }
        return false;
    }
}
