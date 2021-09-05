package com.xxxx.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test最大宽度 {
    public static void main(String[] args) {

    }
    private int widthOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }
        LinkedList<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        list.push(1);
        int res = 1;
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            size--;
//            int tl = list.poll();
            int tl = list.removeFirst();
            if(t.left!=null){
                list.add(tl * 2);
                queue.add(t.left);
            }
            if(t.right!=null){
                list.add(tl * 2 + 1);
                queue.add(t.right);
            }
            if(size == 0){
                size = queue.size();
                if(list.size()>1){
                    res = Math.max(res,list.getLast()-list.getFirst()+1);
                }
            }
        }
        return res;
    }
}
