package com.mingyangdai.LinkedList;

/**
 * @author mingyang.dai
 * @since 2017/8/24
 */
public class CopyListwithRandomPointer {
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode node = head;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            RandomListNode next = node.next;
            node.next = newNode;
            newNode.next = next;
            
            node = next;
        }
        
        node = head;
        while (node != null) {
            RandomListNode next = node.next;
            RandomListNode random = node.random;
            if (next != null && random != null) {
                next.random = random.next;
            }
            node = next.next;
        }
        
        node = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode newHead = dummy;
        while (node != null && node.next != null) {
            RandomListNode next = node.next;
            node.next = next.next;
            node = node.next;
            
            newHead.next = next;
            newHead = newHead.next;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(-1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        
//        r1.next = r2;
//        r2.next = r3;
//        r3.next = r4;
        
//        r1.random = r3;
//        r2.random = r1;
//        r3.random = r2;
        
        CopyListwithRandomPointer pointer = new CopyListwithRandomPointer();
        RandomListNode head = pointer.copyRandomList(r1);
        System.out.println(head);
    }
}
