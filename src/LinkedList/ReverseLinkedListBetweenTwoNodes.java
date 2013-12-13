package LinkedList;

import Stack.EvaluateReversePolishNotation;

public class ReverseLinkedListBetweenTwoNodes {
	class Result{
        ListNode head;
        ListNode afterTail; //the next node right after the tail of reversed list
        Result(ListNode head, ListNode tail){
            this.head = head;
            this.afterTail = tail;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        if(m == 1){
            Result rez = reverseBetweenHelper(head, n - m );
            head.next = rez.afterTail;
            return rez.head;    
        }
        //stop at the one node before the start node
        ListNode cur = head;
        for(int i = 1; cur != null && i+1 < m; i++){
            cur = cur.next;
        }
        ListNode next = cur.next;
        Result rez= reverseBetweenHelper(next, n - m);
        //1->2<-3<-4<-rez.head  
        //    <-next
        //5<-rez.afterTail
        cur.next = rez.head;
        //next is the tail
        next.next = rez.afterTail;
        return head;
    }
    public Result reverseBetweenHelper(ListNode head, int steps){
        if(head == null) return null;
        if(steps == 0) return new Result(head, head.next);
        ListNode next = head.next;
        Result rez = reverseBetweenHelper(next, steps - 1);
        //reverse
        next.next = head;
        return new Result(rez.head, rez.afterTail);
    }
    /*
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * return 1->4->3->2->5->NULL. 
     */
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
		ReverseLinkedListBetweenTwoNodes test = new ReverseLinkedListBetweenTwoNodes();
		ListNode rez = test.reverseBetween(head, 4, 5);
		System.out.println(rez.val);
	 }
}
