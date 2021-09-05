package com.xxxx.链表;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int len = lists.length;
        while(len>1){
            for (int i = 0; i < len/2; i++) {
                lists[i] = mergetwoList(lists[i],lists[len-i-1]);
            }
            len = (len+1)>>1;
        }
        return lists[0];
    }

    public ListNode mergetwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }
        }
        if (l1 == null) {
            pre.next = l2;
        }
        if (l2 == null) {
            pre.next = l1;
        }
        return dummy.next;
    }
}