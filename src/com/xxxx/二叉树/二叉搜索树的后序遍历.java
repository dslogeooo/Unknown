package com.xxxx.二叉树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 二叉搜索树的后序遍历 {
    public static boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if(len <= 2){
            return true;
        }
        return helper(postorder,0,len-1);
    }

    private static boolean helper(int[] postorder, int pi, int pe) {
        if(pi>=pe){
            return true;
        }
        int rootval = postorder[pe];
        int index = pi;
        for(int i=pi;i<pe;i++){
            if(postorder[index] < rootval){
                index++;
            }
        }
        for(int i=index;i<pe;i++){
            if(postorder[i] < rootval){
                return false;
            }
        }
        return helper(postorder,pi,index-1) && helper(postorder,index,pe-1);
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] postorder = stringToIntegerArray(line);

            boolean ret = verifyPostorder(postorder);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
