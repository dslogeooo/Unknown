package com.xxxx.数字数值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class x的平方根 {
    public static int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        if(x <= 3){
            return 1;
        }
        int begin = 0;
        int end = x;
        while(begin<end){
            int mid = (begin+end)>>1;
            if(mid == x/mid){
                return mid;
            }else if(mid > x/mid){
                end = mid-1;
            }else{
                if((mid+1) > x/(mid+1)){
                    return mid;
                }else{
                    begin = mid+1;
                }
            }
        }

        return begin;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = mySqrt(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}