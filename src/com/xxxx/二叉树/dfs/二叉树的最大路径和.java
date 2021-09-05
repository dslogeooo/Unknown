package com.xxxx.二叉树.dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大路径和 {
    public static int res = 0;
    public static int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxLeft = Math.max(0,dfs(root.left));
        int maxRight = Math.max(0,dfs(root.right));

        res = Math.max(res,maxLeft+maxRight+root.val);
        return Math.max(maxLeft,maxRight)+root.val;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = maxPathSum(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
