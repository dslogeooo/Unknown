package com.xxxx.数组;

import java.util.*;

public class 前K个高频元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] ss = strs.split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int k = Integer.parseInt(sc.nextLine());
        int[] res = topKFrequent(nums,k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    private static int[] topKFrequent(int[] nums,int k) {
        int len = nums.length;
        int[] res = new int[k];
        if (len == 0 || k == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Count = map.get(o1);
                int o2Count = map.get(o2);
                return o2Count - o1Count;
            }
        });
        for(Integer i:map.keySet()){
            pq.add(i);
        }
        int index = 0;
        while(index < k){
            res[index] = pq.poll();
            index++;
        }
        return res;
    }
}
