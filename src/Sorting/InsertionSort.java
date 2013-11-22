package Sorting;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class InsertionSort {
	public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode tail = head;
        ListNode insert = tail.next;
        while(insert != null){
            //If smaller than head, then inserted before head
        	if(insert.val < head.val){
                tail.next = insert.next;
                insert.next = head;
                head = insert;
            //If bigger than or equal to tail, then insert after head 
        	}else if(insert.val >= tail.val){
                tail = tail.next;
            //in between head and tail, then insert before the first element larger than the node to be inserted
        	}else{
                /*ListNode cur = head;
                while(cur != tail){
                    if(cur.next.val > insert.val){
                        tail.next = insert.next;
                        insert.next = cur.next;
                        cur.next = insert;
                    }
                    cur = cur.next;
                }*/
        		 ListNode cur = head;
                 while(cur != tail && cur.next.val <= insert.val){
                     cur = cur.next;
                 }
                 tail.next = insert.next;
                 insert.next = cur.next;
                 cur.next = insert;
            }
            insert = tail.next;
        }
        return head;
    }
	public static void main(String[] args) {
	    ListNode head = new ListNode(4);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(1);
	    head.next.next.next = new ListNode(3);
	    InsertionSort obj = new InsertionSort();
	    obj.insertionSortList(head);
	    
	}

}
