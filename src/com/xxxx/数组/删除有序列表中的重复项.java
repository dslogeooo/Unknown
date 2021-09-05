package com.xxxx.数组;

import java.util.Scanner;

public class 删除有序列表中的重复项 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 1;
        }
        int index = 1;
        for(int i=1;i<len;i++){
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
