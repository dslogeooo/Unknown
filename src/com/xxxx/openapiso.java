package com.xxxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class openapiso {
    //quick
    public static ListNode quicksort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        sort(head,null);
        return head;
    }

    private static void sort(ListNode begin, ListNode end) {
        if(begin == end || begin.next == end){
            return;
        }
        ListNode mid = findpivot(begin,end);
        sort(begin,mid);
        sort(mid.next,end);
    }

    private static ListNode findpivot(ListNode begin, ListNode end) {
        int pivot = begin.val;
        ListNode cur = begin;
        ListNode post = begin.next;
        while(post!=null){
            if(pivot>post.val){
                cur = cur.next;
                int temp = cur.val;
                cur.val = post.val;
                post.val = temp;
            }
            post = post.next;
        }
        begin.val = cur.val;
        cur.val = pivot;
        return cur;
    }
    public static ListNode mergesort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        return sort2(head);
    }

    private static ListNode sort2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = new ListNode(-1);
        fast.next = head;
        ListNode slow = fast;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode l1 = sort2(head);
        ListNode l2 = sort2(head2);
        return merge(l1,l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }

        }
        if(l1!=null){
            pre.next = l1;
        }
        if(l2!=null){
            pre.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int num = 11;
        for(int i=0;i<10;i++){
            cur.next = new ListNode((int)Math.abs(Math.random()*100));
            cur = cur.next;
            num--;
        }
//        quicksort(head);
        mergesort(head);
        for(int i=0;i<=10;i++){
            System.out.printf(head.val+ "  ");
            head = head.next;
        }
    }
}
// 6 7 1 2 3 4 5
// 3 4 5 6 7 1 2
class openapisp{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root == p){
            return root;
        }
        if(root == q){
            return root;
        }
        TreeNode left  = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<=1){
            return s;
        }
        int begin = 1;
        int maxlen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len-2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if((j-i)>=2){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j] && (j-i+1)>maxlen){
                    begin = i;
                    maxlen = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int begin = 0;
        int end = len-1;
        while(begin<=end){
            int mid = (begin+end)>>1;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<nums[end]){
                if(target>nums[mid] && target<=nums[end]){
                    begin = mid+1;
                }else{
                    end = mid-1;
                }
            }
//            if(nums[begin]<nums[mid]){
            else{
                if(target>=nums[begin] && target<nums[mid]){
                    end = mid-1;
                }else{
                    begin = mid+1;
                }
            }
        }
        return -1;
    }
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<=1){
            return len;
        }
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]<nums[j]){
                    dp[j] = Math.max(dp[j],dp[i]+1);
                    res = Math.max(res,dp[j]);
                }
            }
        }
        return res;
    }
    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));

        res = Math.max(left+right+root.val,res);
        return Math.max(left,right)+root.val;
    }
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len <= 2){
            Arrays.sort(nums);
        }
        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>=i;j--){
                if(nums[i]<nums[j]){
                    swap(nums,i,j);
                    Arrays.sort(nums,i+1,len);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
    public static int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs_sumNumber(root,res,0);
        int r = 0;
        for (int i = 0; i < res.size(); i++) {
            r += res.get(i);
        }
        return r;
    }
    private static void dfs_sumNumber(TreeNode root, List<Integer> res, int digit) {
        if(root == null){
            return;
        }
        digit = digit * 10 + root.val;
        System.out.println(digit);
        if(root.left == null && root.right == null){
            res.add(digit);
        }
        dfs_sumNumber(root.left,res,digit);
        dfs_sumNumber(root.right,res,digit);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        dfs_pathSum(root,res,temp,targetSum,0);
        return res;
    }
    private void dfs_pathSum(TreeNode root, List<List<Integer>> res, List<Integer> temp, int targetSum, int sum) {
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

        dfs_pathSum(root.left,res,temp,targetSum,sum);
        dfs_pathSum(root.right,res,temp,targetSum,sum);

        temp.remove(temp.size()-1);
        sum-=root.val;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0){
            return len2;
        }
        if(len2 == 0){
            return len1;
        }
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j]+1);
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j],Math.max(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        return dp[len1][len2];
    }

//    public int findLength(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//
//    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int res = sumNumbers(root);
    }
}