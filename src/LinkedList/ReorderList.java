package LinkedList;

import Tree.PostOrderTraversal;
import Tree.TreeNode;

public class ReorderList {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 * {1,2,3,4}
	 * if((i+1)%2 == 1) oddCur = cur;
	 * else evenCur = cur;
	 * cur = cur.next
	 * 
	 * odd
	 * oddTail.next = oddCur;
	 * oddTail = oddTail.next;
	 *  
	 * even
	 * evenCur = evenHead.next;
	 * evenHead = evenCur;
	 * 
	 * 1->3
	 * 4->2
	 * 
	 * Reorder List Total Accepted: 2020 Total Submissions: 11573 My Submissions
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * You must do this in-place without altering the nodes' values.
	 * For example,
	 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 * 
	 */
	
    public void reorderList_(ListNode head) {
        ListNode oddTail;
        ListNode oddHead;
        ListNode evenHead;
        
        if(head == null) return;
        oddHead = head;
        oddTail = oddHead;
        if(head.next == null) return;
        evenHead = head.next;
        oddHead.next = null;
        head = evenHead.next;
        //divide one list into two lists
        evenHead.next = null;
        for(int i = 1; head != null; i++){
        	ListNode next = head.next;
        	if(i%2 == 1){
        		oddTail.next = head;
        		oddTail = head;
        		head.next = null;
        	}else{
        		head.next = evenHead;
        		evenHead = head;
        	}
        	
        	head = next;
        }
        head = new ListNode(0);
        ListNode tail = head;
        //merge
        int i = 1;
        while(evenHead != null||oddHead != null){
        	if(evenHead == null){
        		tail.next = oddHead;
        		break;
        	}else if(oddHead == null){
        		tail.next = evenHead;
        		break;
        	}else if((i%2) == 1){
        		tail.next = oddHead;
        		oddHead = oddHead.next;
        	}else if((i%2) == 0){
        		tail.next = evenHead;
        		evenHead = evenHead.next;
        	}
        	i++;
        	tail = tail.next;
        }
        
    }
    public ListNode reverse_(ListNode head){
    	if(head == null||head.next == null) return head;
    	ListNode tail = head.next;
    	ListNode newHead = reverse(head.next);
    	tail.next = head;
    	head.next = null;
    	return newHead;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode previous = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;

    }
    public void reorderList(ListNode head) {
        ListNode secondHalfHead;
        ListNode firstHalfHead;
        ListNode oneStep = head;
        ListNode twoSteps = head;
        if(head == null || head.next == null) return;
        while(twoSteps.next!=null && twoSteps.next.next != null){
        	oneStep = oneStep.next;
        	twoSteps = twoSteps.next.next;
        }
        firstHalfHead = head;
        secondHalfHead = oneStep.next;
        oneStep.next = null;
        //reverse
        secondHalfHead = reverse(secondHalfHead);
        
        head = new ListNode(0);
        ListNode tail = head;
        //merge
        
        int i = 1;
        while(secondHalfHead != null||firstHalfHead != null){
        	if(secondHalfHead == null){
        		tail.next = firstHalfHead;
        		break;
        	}else if(firstHalfHead == null){
        		tail.next = secondHalfHead;
        		break;
        	}else if((i%2) == 1){
        		tail.next = firstHalfHead;
        		firstHalfHead = firstHalfHead.next;
        	}else if((i%2) == 0){
        		tail.next = secondHalfHead;
        		secondHalfHead = secondHalfHead.next;
        	}
        	i++;
        	tail = tail.next;
        }
        
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList rl = new ReorderList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		rl.reorderList(head);
		System.out.println();
		
	}
	
}
