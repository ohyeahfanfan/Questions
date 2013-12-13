package LinkedList;

public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        //1. one step and two step, meet at m
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) break;
        }
        if(p2 != p1) return null;
        //2. p1 start at head, p2 start at m, move one step until two pointers meet
        p2 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
	 public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next;
		DetectCycle dc = new DetectCycle();
		ListNode rez = dc.detectCycle(head);
		System.out.println(rez==null?null:rez.val);
	 }
}
