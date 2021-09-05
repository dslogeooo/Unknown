package com.xxxx.字符串;

import java.util.*;

public class 最大数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.split(" ");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        //超时
//        String res = largestNumber(nums);
        String res1 = largestNumber2(nums);
        System.out.println(res1);
        
    }

    private static String largestNumber2(int[] nums) {
        if(nums.length == 0){
            return "";
        }
        if(nums.length == 1){
            return String.valueOf(nums[0]);
        }
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss,new Comparator<String>(){
            public int compare(String o1,String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i]);
        }
        String res = sb.toString();
        //数组溢出
//        if(Integer.parseInt(res) == 0){
//            res = "0";
//        }
        if(res.charAt(0) == '0'){
            res = "0";
        }
        return res;
    }

    private static String largestNumber(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return "";
        }
        if(len == 1){
            return String.valueOf(nums[0]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(nums[i]);
        }
        int length = sb.length();
        List<String> sums = new ArrayList<>();
        boolean[] vistited = new boolean[nums.length];
        backTrack(sums,nums,new StringBuilder(),vistited,0,length);
        Collections.sort(sums);
        System.out.println(sums.size());
        return sums.get(sums.size()-1);
    }

    private static void backTrack(List<String> sums, int[] nums, StringBuilder temp, boolean[] vistited, int index, int length) {
        if(temp.length() == length){
            sums.add(temp.toString());
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(vistited[i]){
                continue;
            }
            int tempLen = temp.length();
            temp.append(nums[i]);
            vistited[i] = true;
            backTrack(sums,nums,temp,vistited,0, length);
            vistited[i] = false;
            temp.setLength(tempLen);
        }
    }
}
