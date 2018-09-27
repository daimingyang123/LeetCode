package com.mingyangdai.LinkedList;

/**
 * @author daimingyang
 * @since 2018/9/27
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[]{1,2,3,4});
        ListNode res = new RemoveDuplicatesfromSortedListII().deleteDuplicates(head);
        ListNode.traversalLinkedList(res);
    }
}
