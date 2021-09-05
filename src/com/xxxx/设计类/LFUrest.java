package com.xxxx.设计类;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
    int key;
    int value;
    int freq;
    Node prev;
    Node next;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
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
    public boolean isEmpty(){
        return head.next == tail;
    }
}

public class LFUrest {
    Map<Integer,Node> map = new HashMap<>();
    Map<Integer, DoubleList> freqmap = new HashMap<>();
    int capacity;
    int size;
    int minFreq;
    public LFUrest(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 1;
        freqmap.put(1,new DoubleList());
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

            int oldfreq = oldNode.freq;
            DoubleList oldList = freqmap.get(oldfreq);
            oldList.remove(oldNode);
            int newfreq = oldfreq+1;
            if(oldfreq == minFreq && oldList.isEmpty()){
                minFreq = newfreq;
            }
            if(!freqmap.containsKey(newfreq)){
                freqmap.put(newfreq,new DoubleList());
            }
            DoubleList newList = freqmap.get(newfreq);
            newList.addFirst(newNode);
            newNode.freq = newfreq;
            map.put(key,newNode);
        }else{
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            DoubleList list1 = freqmap.get(1);
            list1.addFirst(newNode);
            if(size == capacity){
                DoubleList list2 = freqmap.get(minFreq);
                Node node = list2.removeLast();
                map.remove(node.key);
            }else{
                size++;
            }
            minFreq = 1;
        }
    }
}
