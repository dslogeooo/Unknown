package com.xxxx.数组;

import java.util.Scanner;

public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] numbers = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            numbers[i] = Integer.parseInt(ss[i]);
        }
        int res = minArray(numbers);
        System.out.println(res);
    }

    private static int minArray(int[] numbers) {
        int len = numbers.length;
//        int begin = 0;
//        int end = len-1;
        int res = numbers[0];
        for(int i=1;i<len;i++){
            if(numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return res;
    }
    private static int minArray2(int[] numbers) {
        int len = numbers.length;
        int begin = 0;
        int end = len-1;
        while(begin<end){
            int mid = (begin+end)>>1;
            if(numbers[mid] < numbers[end]){
                end = mid;
            }else if(numbers[mid] > numbers[end]){
                begin = mid+1;
            }else{
                end--;
            }
        }
        return numbers[begin];
    }
}
