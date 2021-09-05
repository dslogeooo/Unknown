package com.xxxx.排序;

public class MergeSort {
    public static void mergesort(int[] nums){
        int len = nums.length;
        sort(nums,0,len);
    }
    public static void sort(int[] nums,int begin ,int end){
        if(end-begin<2){
            return;
        }
        int mid = (begin+end)>>1;
        sort(nums,begin,mid);
        sort(nums,mid,end);
        merge(nums,begin,mid,end);
    }
    public static void merge(int[] nums,int begin,int mid,int end){
        int li = 0;
        int le = mid - begin;
        int ri = mid;
        int re = end;
        int ai = begin;
        int[] leftNums = new int[nums.length>>1];
        for(int i=li;i<le;i++){
            leftNums[i] = nums[ai+i];
        }
        while(li<le){
            if(ri<re && nums[ri] < leftNums[li]){
                nums[ai] = nums[ri];
                ai++;
                ri++;
            }else{
                nums[ai] = leftNums[li];
                ai++;
                li++;
            }
        }
    }
}
