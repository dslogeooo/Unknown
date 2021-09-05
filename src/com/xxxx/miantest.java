package com.xxxx;
class test{
    int id;
    String name;
}
public class miantest {
    public static void main(String[] args) {
        test A = new test();
        test B = new test();

        System.out.println(A.equals(B));
    }
}

