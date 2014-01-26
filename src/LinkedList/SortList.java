package LinkedList;

public class SortList {
	 public ListNode sortList(ListNode head) { 
	        if(head == null || head.next == null){
	            return head;
	        }
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode secondHead = slow.next;
	        slow.next = null; //break two list
	        head = sortList(head);
	        secondHead = sortList(secondHead);
	        return mergeTwoLists(head, secondHead);
	    } 
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
