package com.xxxx.二叉树.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 路径总和1 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res,temp,root,targetSum,0);
        return res.size() != 0;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> temp, TreeNode root, int targetSum, int sum) {
        if(root == null){
            return;
        }
        temp.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size()-1);
            return;
        }

        dfs(res,temp,root.left,targetSum,sum);
        dfs(res,temp,root.right,targetSum,sum);
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
            line = in.readLine();
            int targetSum = Integer.parseInt(line);

            boolean ret = hasPathSum(root, targetSum);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}