package Tree;

import String.ZigZagConversion;

public class ConvertSortedListToBalancedBST {
	ListNode head = null;
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        this.head = head;
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
       return sortedListToBSTButtomUp(0, len - 1);
    }
    /*
    1. It creates a balanced BST for nodes from “start” to “end”
    2. During the process in creating the BST, it also moves the “list” pointer to point at the node after the “end” node.
    */
    public TreeNode sortedListToBSTButtomUp(int start, int end){
           if(start > end) return null;
           int mid = start + (end - start) / 2;
           TreeNode left = sortedListToBSTButtomUp(start, mid - 1);
           TreeNode root = new TreeNode(head.val);
           root.left = left;
           this.head = this.head.next;
           root.right = sortedListToBSTButtomUp(mid + 1, end);
           return root;
    }
    public static void main(String[] args) {
    	ConvertSortedListToBalancedBST obj = new ConvertSortedListToBalancedBST();
    	ListNode head = new ListNode(12);
    	head.next = new ListNode(99);
    	head.next.next = new ListNode(37);
    	TreeNode root = obj.sortedListToBST(head);
    	System.out.println(root.val);
    	
    }
}
