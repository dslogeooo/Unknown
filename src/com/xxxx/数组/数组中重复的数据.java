package com.xxxx.数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 数组中重复的数据 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        List<Integer> res = findDuplicates(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if(len <= 1){
            return res;
        }
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]);
            if(nums[index-1] < 0){
//                System.out.println(index-1);
                res.add(Math.abs(index));
            }else{
                nums[index-1] = -nums[index-1];
            }
        }
        return res;
    }
}
