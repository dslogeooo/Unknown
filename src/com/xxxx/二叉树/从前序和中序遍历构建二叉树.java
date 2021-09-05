package com.xxxx.二叉树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 从前序和中序遍历构建二叉树 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    private static TreeNode buildHelper(int[] preorder, int prebegin, int preend, int[] inorder, int inbegin, int inend) {
        if(prebegin>preend || inbegin>inend){
            return null;
        }
        int rootval = preorder[prebegin];
        int rootIndex = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == rootval){
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootval);
        root.left = buildHelper(preorder,prebegin+1,rootIndex-inbegin+prebegin,inorder,inbegin,rootIndex-1);
        root.right = buildHelper(preorder,rootIndex-inbegin+prebegin+1,preend,inorder,rootIndex+1,inend);

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
            int[] preorder = stringToIntegerArray(line);
            line = in.readLine();
            int[] inorder = stringToIntegerArray(line);

            TreeNode ret = buildTree(preorder, inorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}