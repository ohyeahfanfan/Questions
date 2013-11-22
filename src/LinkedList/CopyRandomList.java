package LinkedList;
/* Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.*/
public class CopyRandomList {
	class RandomListNode {
		 int label;
	     RandomListNode next, random;
		 RandomListNode(int x) { this.label = x; }
    };
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode cur = head;
        //1. copy nodes
        while(cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        //2. add additional random pointer to new list
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3. slipt two list
        //A->A1->B->B1
        cur = head;
        RandomListNode copyHead = head.next;
        RandomListNode copyCur = null;
        while(cur != null){
            copyCur = cur.next;
            cur.next = copyCur.next;
            cur = cur.next;
            copyCur.next = (cur == null ? null : cur.next); //!!!!!!!!!!!!!!!!!!!!!!
        }
        return copyHead;
    }
}
