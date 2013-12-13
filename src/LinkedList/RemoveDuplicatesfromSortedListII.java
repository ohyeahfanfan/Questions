package LinkedList;

/* 
 * Remove Duplicates from Sorted ListII
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *	For example,
 *	Given 1->2->3->3->4->4->5, return 1->2->5.
 *	Given 1->1->1->2->3, return 2->3 
 *
 * Solution:
 * not equal to previous element & not equal to next element
 * very elegant solution
 * 
 * What I learned
 * Dummy Node is very useful when the head is possible to be changed. 
 * Dummy node is not essential to all the linkedlist questions.  
 */
public class RemoveDuplicatesfromSortedListII {
	 
    //I like this solution!!!
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
	
	public ListNode deleteDuplicates2ndTime(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        boolean distinct = true;
        while(head != null){
            if(head.next != null){
                if(head.val == head.next.val){
                    distinct = false;
                }else if(distinct){
                    tail.next = head;
                    tail = tail.next;
                }else{
                    distinct = true;
                }
            }else if(distinct){
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
            
        }
        //!!!!
        tail.next = null;
        return dummy.next;
   }
}
