package com.xxxx.二叉树.dfs;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 判断dfs结束条件 比较
 * 路径总和
 */
public class 根节点到叶子节点的数字之和 {
    public static int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        dfs(root,nums,0);

        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            res+=nums.get(i);
        }
        return res;
    }

    private static void dfs(TreeNode root, List<Integer> nums, int num) {
        if(root == null){
            return;
        }

        num = num*10 + root.val;
        if(root.left == null && root.right == null){
            nums.add(num);
        }
        dfs(root.left,nums,num);
        dfs(root.right,nums,num);
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

            int ret = sumNumbers(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}