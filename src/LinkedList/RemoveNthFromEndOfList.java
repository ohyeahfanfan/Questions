package LinkedList;
/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass. 
 * 
 */
public class RemoveNthFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        //first step
        ListNode fast = head;
        ListNode slow = head;
        if(head == null) return head;
        while(fast.next != null && n > 0){
            fast = fast.next;
            n--;
        }
        if(n == 1) return head.next; // 1->2 2
        if(n > 1) return head;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next; 
        slow.next = next.next;
        next.next = null;
        return head;
    }
}
