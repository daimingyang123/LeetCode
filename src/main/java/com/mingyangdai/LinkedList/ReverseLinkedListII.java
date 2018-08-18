package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2018/5/30
 */
public class ReverseLinkedListII {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        int i = 1;
        while (i < m) {
            head = head.next;
            i++;
        }
        ListNode pre = head.next;
        if (pre  == null) return head;
        
        ListNode cur = pre.next;
        while (cur!=null && i<n) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }
        
        head.next.next = cur;
        head.next = pre;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[]{1, 2, 3, 4, 5});
        ListNode res = new ReverseLinkedListII().reverseBetween(head, 2, 4);
        ListNode.traversalLinkedList(res);
    }
}
