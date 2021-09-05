package com.xxxx.字符串.backtrack;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import java.util.ArrayList;
//import java.util.List;

public class 复原ip地址 {


    public static List<String> restoreIpAddresses(String s) {
        List<String> res =  new ArrayList<>();
        int len = s.length();
        if(len<4 || len>12){
            return res;
        }
        backTrack(res,new StringBuilder(),s,0,0);
        return res;
    }

    private static void backTrack(List<String> res, StringBuilder temp, String s, int index, int step) {
        int len = s.length();
        if(index == len && step == 4){
            res.add(temp.toString());
            return;
        }
        for (int i = index; i < len; i++) {
            String t = s.substring(index,i+1);
            if(t.length()>3 || Integer.valueOf(t)>255 ||(t.length()>1 && t.charAt(0)=='0')){
                continue;
            }
            int tempLen = temp.length();
            temp.append(t);
            if(i!=len-1){
                temp.append('.');
            }
            backTrack(res,temp,s,i+1,step+1);
            temp.setLength(tempLen);
            step--;
        }
    }


    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            List<String> ret = restoreIpAddresses(s);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}