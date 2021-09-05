package com.xxxx.链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 反转链表2 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        if(right-left == 0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        ListNode end = dummy;
        for(int i=0;i<left-1;i++){
            begin = begin.next;
        }
        for(int i=0;i<right;i++){
            end = end.next;
        }
        ListNode start = begin.next;
        begin.next = null;
        ListNode next = end.next;
        end.next = null;
        begin.next = reverse(start);
        start.next = next;
        return dummy.next;
    }
    public static ListNode reverse(ListNode head){
        if(head == null||head.next ==null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
            int left = Integer.parseInt(line);
            line = in.readLine();
            int right = Integer.parseInt(line);

            ListNode ret = reverseBetween(head, left, right);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}