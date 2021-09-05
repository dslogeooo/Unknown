package com.xxxx.设计类;

import java.util.Stack;

class 用栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /** Initialize your data structure here. */
    public 用栈实现队列() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int ret = stack1.pop();
        return ret;
    }

    /** Get the front element. */
    public int peek() {
        int ret = stack1.peek();
        return ret;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */