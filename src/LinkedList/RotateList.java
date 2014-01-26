package LinkedList;

import Recursive.WordSearch;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        ListNode fast = head;//fast will point to the end of the list
        ListNode slow = head;//slow will point to the tail of rotated list
        // n > listNode length
        int len = 0;
        while(fast != null){
            fast = fast.next;
            len++;
        }
        n %= len;
        if(n == 0) return head;
        //reset fast to head
        fast = head;
        //move n steps first
        while(n > 0){
            fast = fast.next;
            n--;
        }
        //move two pointers together until fast point to the last node
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //make a cicle
        fast.next = head;
        //new head
        head = slow.next;
        //new tail
        slow.next = null;
        return head;
    }
	public static void main(String[] args) {
		RotateList obj = new RotateList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head = obj.rotateRight(head, 2);
		System.out.println(head.val);
	}
}
