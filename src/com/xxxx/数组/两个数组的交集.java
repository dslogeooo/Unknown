package com.xxxx.数组;

import java.util.*;

/***
1,2,2,1
2,2
 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] ss1 = str1.split(",");
        int[] nums1 = new int[ss1.length];
        for (int i = 0; i < ss1.length; i++) {
            nums1[i] = Integer.parseInt(ss1[i]);
        }
        String str2 = sc.nextLine();
        String[] ss2 = str2.split(",");
        int[] nums2 = new int[ss2.length];
        for (int i = 0; i < ss2.length; i++) {
            nums2[i] = Integer.parseInt(ss2[i]);
        }
        int[] res = intersection(nums1,nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        Set<Integer>set1 = new HashSet<>();
        Set<Integer>set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for (Integer integer : set2) {
            res[index] = integer;
            index++;
        }
        return res;
    }
}
