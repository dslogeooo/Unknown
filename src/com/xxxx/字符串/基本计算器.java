package com.xxxx.字符串;

import java.util.*;

public class 基本计算器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        int res = calculate(strs);
        System.out.println(res);
    }

    private static Map<Character, Integer> map = new HashMap<>();

    private static int calculate(String s) {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('%', 2);
        map.put('^', 3);
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");
        s = s.replaceAll("\\(\\+", "(0+");
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(c)) {
                    int j = i;
                    int t = 0;
                    while (j < n && isNumber(cs[j])) {
                        t = t * 10 + (cs[j] - '0');
                        j++;
                    }
                    nums.addLast(t);
                    i = j - 1;
                } else {
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peekLast();
    }

    private static void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast();
        int a = nums.pollLast();
        int op = ops.pollLast();
        int res = 0;
        if (op == '+') {
            res = a + b;
        } else if (op == '-') {
            res = a - b;
        } else if (op == '*') {
            res = a * b;
        } else if (op == '/') {
            res = a / b;
        } else if (op == '%') {
            res = a % b;
        } else if (op == '^') {
            res = (int) Math.pow(a, b);
        }
        nums.addLast(res);
    }

    private static boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
