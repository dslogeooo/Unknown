package com.xxxx.数字数值;

import java.util.Scanner;

public class 最大交换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = maximumSwap(num);
        System.out.println(res);
    }

    private static int maximumSwap(int num) {
        if(num<=10){
            return num;
        }
        String s = String.valueOf(num);
        char[] ss = s.toCharArray();
        int len = ss.length;
        int index = len-1;
        int[] maxIndex = new int[ss.length];
        for(int i=len-1;i>=0;i--){
            if(ss[i]-'0' > ss[index]-'0'){
                index = i;
            }
            maxIndex[i] = index;
        }
        for(int i=0;i<len;i++){
            int tempNum = ss[i] - '0';
            int maxNum = ss[maxIndex[i]]-'0';
            if(tempNum != maxNum){
                ss[maxIndex[i]] = (char)(tempNum + '0');
                ss[i] = (char) (maxNum + '0');
                break;
            }
        }
        return Integer.parseInt(new String(ss));
    }
}
