package com.xxxx.数组.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 全排列2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        List<List<Integer>> res = permuteUnique(nums);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + ",");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTrack(nums,res,temp,visited,index);
        return res;
    }

    private static void backTrack(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] visited, int index) {
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && visited[i-1]){
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            backTrack(nums,res,temp,visited,0);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
