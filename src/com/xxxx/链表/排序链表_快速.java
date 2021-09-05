package com.xxxx.链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 排序链表_快速 {
    public static ListNode sortList(ListNode head) {
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
        ListNode mid = findPivot(begin,end);

        sort(begin,mid);
        sort(mid.next,end);
    }

    private static ListNode findPivot(ListNode begin, ListNode end) {
        int pivot = begin.val;
        ListNode cur = begin;
        ListNode post = begin.next;
        while(post!=end){
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

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = sortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}