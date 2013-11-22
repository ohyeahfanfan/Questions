package LinkedList;

import java.util.HashSet;
import java.util.Set;

import DP.WordBreak;

/*
 * Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 * 
 */
public class SwapNodesInPairs {
	// input: the head of list to be swapped
	// output: the head of swapped list
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}
	//1->2->3
	 public ListNode swapPairsI(ListNode head){
			ListNode newHead = null;
			ListNode preTail = null;
			while(head != null){
				ListNode swappedHead = swapTwo(head);
				if(newHead == null){ 
				    newHead = swappedHead;
				    preTail = head;
				}else{
				    preTail.next = swappedHead;
				    preTail = head;
				}
				head = head.next;
			}
			return newHead;
		}
	    //swap 2, return the next element to be swapped 
		public ListNode swapTwo(ListNode head) {
			//null or only one left
			if(head == null || head.next == null) return head;
			ListNode tail = head.next;
			head.next = tail.next;
			tail.next = head;
			return tail;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SwapNodesInPairs obj = new SwapNodesInPairs();
			ListNode head = new ListNode(1);
			head.next = new ListNode(2);
			head.next.next = new ListNode(3);
			head.next.next.next = new ListNode(4);
			head.next.next.next.next = new ListNode(5);
			obj.swapPairsI(head);
		}
}
