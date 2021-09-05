package com.xxxx.排序;

public class QuickSort {
    public static void quicksort(int[] nums){
        int len = nums.length;
        sort(nums,0,len);
    }
    public static void sort(int[] nums,int begin, int end){
        if(end-begin<2){
            return;
        }
        int pivot = findPivot(nums,begin,end);
        sort(nums,begin,pivot);
        sort(nums,pivot+1,end);
    }

    private static int findPivot(int[] nums, int begin, int end) {

        int pivot = nums[begin];
        end--;

        while(begin<end){
            while(begin<end){
                if(nums[end]>pivot){
                    end--;
                }else{
                    nums[begin] = nums[end];
                    begin++;
                    break;
                }
            }
            while(begin<end){
                if(nums[begin]<pivot){
                    begin++;
                }else{
                    nums[end] = nums[begin];
                    end--;
                    break;
                }
            }
        }
        nums[begin] = pivot;
        return begin;
    }
}
