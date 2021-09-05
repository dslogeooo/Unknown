package com.xxxx.设计类;

import java.util.Stack;

public class 用两个栈实现队列 {
}
class CQueue {

    //1 2 3
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if(!stack1.isEmpty()){
            return stack1.pop();
        }else{
            return -1;
        }
    }
}
