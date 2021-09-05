package com.xxxx.数组.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 组合总和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] candidates = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            candidates[i] = Integer.parseInt(ss[i]);
        }
        List<List<Integer>> res = combinationSum2(candidates,target);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> temp = res.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j)+" ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[len];
        int tempsum = 0;
        int index = 0;
        Arrays.sort(candidates);
        backTrack(res,temp,candidates,visited,tempsum,target,index);
        return res;
    }

    private static void backTrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, boolean[] visited, int tempsum, int target,int index) {
        if(index >= candidates.length){
            return;
        }
        if(tempsum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(tempsum > target){
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && candidates[i] == candidates[i-1] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            temp.add(candidates[i]);
            tempsum+=candidates[i];
            backTrack(res,temp,candidates,visited,tempsum,target,i);
            visited[i] = false;
            temp.remove(temp.size()-1);
            tempsum -= candidates[i];
        }
    }
}
/****
8
10,1,2,7,6,1,5
5
2,5,2,1,2
27
14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12
 */