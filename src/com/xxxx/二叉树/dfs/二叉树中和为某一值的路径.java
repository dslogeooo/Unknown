package com.xxxx.二叉树.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树中和为某一值的路径 {
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            if(target!=0){
                return res;
            }else{
                return new ArrayList<>(target);
            }
        }
        List<Integer> temp = new ArrayList<>();
        int tempSum = root.val;
        temp.add(root.val);
        backTrack(res,temp,root,target,tempSum);
        return res;
    }

    private static void backTrack(List<List<Integer>> res, List<Integer> temp, TreeNode root, int target, int tempsum) {
        if(root.left == null && root.right == null && tempsum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
//        if(tempsum > target){
//            return;
//        }

        if(root.left != null){
            tempsum += root.left.val;
            temp.add(root.left.val);
            backTrack(res,temp,root.left,target,tempsum);
            temp.remove(temp.size()-1);
            tempsum -= root.left.val;
        }
        if(root.right != null){
            tempsum += root.right.val;
            temp.add(root.right.val);
            backTrack(res,temp,root.right,target,tempsum);
            temp.remove(temp.size()-1);
            tempsum -= root.right.val;
        }
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<List<Integer>> ret = pathSum(root, target);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}