package LinkedList;


public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode biggerHead = new ListNode(0);
        ListNode sTail = smallerHead;
        ListNode bTail = biggerHead;
        while(head != null){
            if(head.val < x){
                sTail.next = head;
                sTail = sTail.next;
            }else{
                bTail.next = head;
                bTail = bTail.next;
            }
            head = head.next;
        }
        sTail.next = null;
        bTail.next = null;
        sTail.next = biggerHead.next;
        return smallerHead.next;
    }
	 
    public static void main(String[] args) {
    	PartitionList test = new PartitionList();
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(1);
    	head.next.next = new ListNode(0);
    	System.out.println(test.partition(head, 2).val);
    }	
}
