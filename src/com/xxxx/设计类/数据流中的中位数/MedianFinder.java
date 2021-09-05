package com.xxxx.设计类.数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    public PriorityQueue<Integer> min = new PriorityQueue<>();
    public PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public MedianFinder(){

    }
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(min.size() > max.size()){
            max.add(min.poll());
        }
    }

    public double findMedian() {
        if(min.size() == max.size()){
            return (min.peek() + max.peek())/2.0;
        }else{
            return max.peek();
        }
    }

}
