package MergeOrAdd;

public class AddTwoNumber {
/* 
 * Add Two Number
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit
 * Add the two numbers and return it as a linked list
 * Input: (2->4->3) + (5->6->4) 342 + 465 = 807 !!!
 * Output: 7->0->8
 * 
 * Same Type of Problems
 * Add Binary (OR is better) since request add carry
 * Add Two Number (OR is better) since request add carry
 * Merge Two Sorted List (OR and AND both are OK, since after merge it doesn't require do anything)
 * 
 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummyNode = new ListNode(0);
		ListNode tail = dummyNode;
		int carry = 0;
		while(l1 != null || l2 != null){
			int digit = carry;
			digit += (l1 == null ? 0 : l1.val);
			digit += (l2 == null ? 0 : l2.val);
			carry = digit / 10;
			digit = digit % 10;
			ListNode cur = new ListNode(digit);
			tail.next = cur;
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(carry != 0){
			tail.next = new ListNode(carry);
		}
		return dummyNode.next;
	}
	public static void main(String[] args) {
		AddTwoNumber obj = new AddTwoNumber();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode rez = obj.addTwoNumbers(l1, l2);
	}
}
