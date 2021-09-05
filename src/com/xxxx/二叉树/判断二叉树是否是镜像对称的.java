package com.xxxx.二叉树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 判断二叉树是否是镜像对称的 {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return mirror(root.left,root.right);
    }

    private static boolean mirror(TreeNode left, TreeNode right) {
        if(left == null && right==null){
            return true;
        }
        if(left!=null || right!=null || left.val != right.val){
            return false;
        }
//        if(left!=null && right==null){
//            return false;
//        }
//        if(right!=null && left==null){
//            return false;
//        }
//        if(left!=null && right != null && left.val != right.val){
//            return false;
//        }

        return mirror(left.left,right.right) && mirror(left.right,right.left);
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = isSymmetric(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}