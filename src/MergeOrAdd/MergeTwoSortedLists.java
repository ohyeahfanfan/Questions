package MergeOrAdd;

public class MergeTwoSortedLists {
	/* Merge Two Sorted Lists
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists. 
	 * 
	 * Same Type of Problems
	 * Add Binary (OR is better) since request add carry
	 * Add Two Number (OR is better) since request add carry
	 * Merge Two Sorted List (OR and AND both are OK, since after merge it doesn't require do anything)
 
	 */
	 public ListNode mergeTwoListsAND(ListNode l1, ListNode l2) {
	        ListNode head = new ListNode(0);
	        ListNode cur = head;
	        while(l1!=null && l2!=null){
	            if(l1.val < l2.val){
	                cur.next = l1;
	                l1 = l1.next;
	            }else{
	                cur.next = l2;
	                l2 = l2.next;;
	            }
	            cur = cur.next;
	            cur.next = null;
	        }
	        ListNode left = (l1==null ? l2 : l1);
	        cur.next = left;
	        return head.next;
	    }
	 public ListNode mergeTwoListsOR(ListNode l1, ListNode l2) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        ListNode dummyNode = new ListNode(0);
	        ListNode curNode = dummyNode;
	        while(l1 != null || l2 != null){//!!!!!!!
	            if(l2 == null){
	                curNode = l1; //可以提前结束
	                break;
	            }else if(l1 == null){
	                curNode = l2;
	                break;
	            }else if (l1.val < l2.val){
	                curNode.next = l1;
	                l1 = l1.next;
	            }else{
	                curNode.next = l2;
	                l2 = l2.next;
	            }
	            curNode = curNode.next;
	        }
	        return dummyNode.next;
}
}