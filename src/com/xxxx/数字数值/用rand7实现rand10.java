package com.xxxx.数字数值;

public class 用rand7实现rand10{
    public int rand10() {
        while(true){
            int a = rand7();
            int b = rand7();
            int c = (a-1) * 7 + b;

            if(c<=40){
                return c%10+1;
            }
        }

    }
    public int rand7(){
        return (int) (Math.random()%7+1);
    }
}
