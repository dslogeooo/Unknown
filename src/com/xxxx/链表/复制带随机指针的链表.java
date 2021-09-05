package com.xxxx.链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int val,Node next,Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class 复制带随机指针的链表 {
    public static Node copyRandomList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            Node clone = new Node(cur.val,null,null);
            map.put(cur,clone);
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
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

    public static Node stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        Node dummyRoot = new Node(0);
        Node ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new Node(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(Node node) {
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
            Node head = stringToListNode(line);

            Node ret = copyRandomList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}