package com.xxxx.设计类.LRU;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class DoubleList{
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    public DoubleList(){
        head.next = tail;
        tail.prev = head;
    }
    public void addFirst(Node node){
        Node oldFirst = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldFirst;
        oldFirst.prev = node;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public Node removeLast(){
        Node node = tail.prev;
        remove(node);
        return node;
    }
}

public class LRU {
    Map<Integer,Node> map = new HashMap<>();
    DoubleList list = new DoubleList();
    int capacity;
    int size;
    public LRU(int capacity){
        this.capacity = capacity;
        size = 0;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            int value = node.value;
            put(key,value);
            return value;
        }
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            Node newNode = new Node(key,value);
            map.remove(key);
            map.put(key,newNode);
            list.remove(oldNode);
            list.addFirst(newNode);
        }else{
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            list.addFirst(newNode);
            if(size == capacity){
                Node node = list.removeLast();
                map.remove(node.key);
            }else {
                size++;
            }
        }
    }
}

