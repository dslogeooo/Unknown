package com.xxxx.二叉树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 从中序和后序遍历构建二叉树 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode res = buildhelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return res;
    }

    private static TreeNode buildhelper(int[] inorder, int inbegin, int inend, int[] postorder, int postbegin, int postend) {
        if(inbegin>inend || postbegin>postend){
            return null;
        }
        int rootval = postorder[postend];
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(rootval == inorder[i]){
                index = i;
            }
        }

        TreeNode root = new TreeNode(rootval);
        root.left = buildhelper(inorder,inbegin,index-1,postorder,postbegin,index-inbegin+postbegin-1);
        root.right = buildhelper(inorder,index+1,inend,postorder,index-inbegin+postbegin,postend-1);

        return root;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] inorder = stringToIntegerArray(line);
            line = in.readLine();
            int[] postorder = stringToIntegerArray(line);

            TreeNode ret = buildTree(inorder, postorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}