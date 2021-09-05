package com.xxxx.输入输出练习;

//【编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
// 询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
// 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
//abcbaa 2
// 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
// 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。

import java.util.*;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ss = str.toCharArray();
        int times = sc.nextInt();
        int res = move(ss,times);
        System.out.println(res);
    }

    private static int move(char[] ss, int times) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            map.put(ss[i], new ArrayList<Integer>());
        }
        for (int i = 0; i < ss.length; i++) {
            List<Integer> list = map.get(ss[i]);
            list.add(i);
        }

        return 0;
    }
}
