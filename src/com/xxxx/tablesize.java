package com.xxxx;

public class tablesize {
    private static int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    public static void main(String[] args) {
        int res = tableSizeFor(100+50+1);
        System.out.println(res);
        System.out.println(res * 0.75);
    }

}
