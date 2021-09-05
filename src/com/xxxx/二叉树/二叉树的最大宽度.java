package com.xxxx.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的最大宽度 {
    public static void main(String[] args) {

    }

    private int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(1);
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            size--;
            int index = list.removeFirst();
            if (t.left != null) {
                queue.add(t.left);
                list.add(index * 2);
            }
            if (t.right != null) {
                queue.add(t.right);
                list.add(index * 2 + 1);
            }
            if(size == 0){
                size = queue.size();
                if(list.size() > 1){
                    res = Math.max(res,list.getLast() - list.getFirst()+1);
                }
            }
        }
        return res;
    }
}
