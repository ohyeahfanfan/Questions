package LinkedList;

/* 
 * Remove Duplicates from Sorted ListII
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *	For example,
 *	Given 1->2->3->3->4->4->5, return 1->2->5.
 *	Given 1->1->1->2->3, return 2->3 
 * 
 *  思路就是和前面一个不等，和后面一个也不等
 * 
 */
public class RemoveDuplicatesfromSortedListII {
	 

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode pre = null;
		ListNode tail = dummy;
		while (head != null) {
			if ((pre == null || head.val != pre.val)
					&& (head.next == null || head.val != head.next.val)) {
				//not equal to previous element & not equal to next element
				tail.next = head;
				tail = tail.next;
			}
			pre = head;
			head = head.next;

		}
		//2->3->3 => 2->null
		tail.next = null;
		return dummy.next;
	}
}
