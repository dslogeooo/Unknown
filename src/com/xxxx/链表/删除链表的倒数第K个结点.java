package com.xxxx.链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 删除链表的倒数第K个结点 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        int len = 0;
        while(pre.next!=null){
            pre = pre.next;
            len++;
        }
        if(n>len){
            return dummy.next;
        }
        if(n == len){
            dummy.next = head.next;
            return dummy.next;
        }
        pre = dummy;
        int index = len-n;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
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
            line = in.readLine();
            int n = Integer.parseInt(line);

            ListNode ret = removeNthFromEnd(head, n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}