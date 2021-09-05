package com.xxxx.数组.利用归并排序;

import java.util.*;

public class 计算数组的小和 {
    public static int[] leftArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        leftArr = new int[len>>1];
        long res = mergeSort(nums, 0, len);
        System.out.print(res);
    }

    // 归并排序     返回值：数组从start到end的小和
    public static long mergeSort(int[] nums, int start, int end) {
        if (end - start < 2) {
            return 0;
        }
        int mid = (start+end)>>1;

//        System.out.println(mid);
        return mergeSort(nums, start, mid)
                + mergeSort(nums, mid, end)
                + merge(nums, start, mid, end);
    }

    public static long merge(int[] nums, int begin, int mid, int end) {
        int li = 0;
        int le = mid-begin;
        int ri = mid;
        int re = end;
        int ai = begin;
        long res = 0;
        for (int i = li; i < le; i++) {
            leftArr[i] = nums[i+ai];
        }
        while(li<le){
            if(ri<re && nums[ri] < leftArr[li]){
                nums[ai] = nums[ri];
//                System.out.println("leftArr[+"+li+"] = " + leftArr[li] +",re = "+re + ",ri = "+ri);
                ai++;
                ri++;
            }else{
                nums[ai] = leftArr[li];
                System.out.println("leftArr["+li+"] = " + leftArr[li] +" ,nums["+ri+"] = "+nums[ri] +" ,ri = "+ri + " ,re = "+re+" ,temp = "+(re - ri) * leftArr[li]);
                res += (long) (re - ri) * leftArr[li];
                ai++;
                li++;
            }
        }
        return res;
    }
}
//6 1 3 5 2 4 6
//5 1 3 4 2 5