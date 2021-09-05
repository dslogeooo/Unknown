package com.xxxx.设计类;

public class 打乱数组 {
    private int[] inorder;
    public 打乱数组(int[] nums) {
        inorder = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            inorder[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return inorder;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (inorder.length == 0) {
            return null;
        }
        int[] disorder = new int[inorder.length];
        for (int i = 0; i < disorder.length; i++) {
            int j = (int) (Math.random() * (disorder.length - i)) + i;
            swap(disorder, i, j);
        }
        return disorder;
    }

    private void swap(int[] disorder, int i, int j) {
        int temp = disorder[i];
        disorder[i] = disorder[j];
        disorder[j] = temp;
    }
}
