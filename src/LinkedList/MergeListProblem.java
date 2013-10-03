package LinkedList;

class Node {
    public int value;
    public Node next;
    public Node() {
            value = 0;
            next = null;
    }
    public Node(int value, Node next) {
            this.value = value;
            this.next = next;
    }
}

public class MergeListProblem {
	/*
	 * Document your assumptions
Explain your approach and how you intend to solve the problem
Provide code comments where applicable
Explain the big-O run time complexity of your solution. Justify your answer.
Identify any additional data structures you used and justify why you used them.
Only provide your best answer to each part of the question
 
	 * 
	 */
	/*
	 * I. Assumptions:
	 * 1. Assume there is no noop in two single linkedlists
	 * 2. return null if both linkedlist is null;
	 * 
	 * II. My approach.
	 * Compare the nodes in two linkedlist, insert the smaller one to the new linkedlist
	 * 
	 * II. Run Time
	 * Each node is touched once, so the time complexity is big-O
	 * 
	 * II. Test Cases
	 * 1. null vs null => return null
	 * 2. null vs 1 => return 1
	 * 3. 1 vs null => return 1
	 * 4. 1 vs 1 => return 1->1
	 * 5. 1->2 vs 3->4 => return 1->2->3->4
	 * 
	 */
	
    public static Node mergeLists(Node head1, Node head2) {
    	Node head = new Node();
    	Node cur = head;
    	while(head1 != null && head2 != null){
    		if(head1.value <= head2.value){
    			cur.next = head1;
    			head1 = head1.next;
    		}else{
    			cur.next = head2;
    			head2 = head2.next;
    		}
    		cur = cur.next;
    	}
    	cur.next = (head1 == null ? head2 : head1);
    	return head.next;
    }
    public static void main(String args[] ) {
    	Node head = MergeListProblem.mergeLists(null, null);
    	if(head == null) System.out.println("true");
    	head = MergeListProblem.mergeLists(null, new Node(1, null));
    	if(head.value==1 && head.next == null) System.out.println("true");
    	head = MergeListProblem.mergeLists(new Node(1, null), new Node(1,null));
    	System.out.println(head.value);
    }
}

