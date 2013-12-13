package Tree;

/* Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 */
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }
public class SortedListToBST {
	public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num == null) return null;
		return sortedArrayToBST(num ,0 ,num.length-1);
    }
    public TreeNode sortedArrayToBST(int[] num, int start, int end){
        if(start > end){
           return null;
        }
        int mid = start + (end - start)/2;
        TreeNode cur = new TreeNode(num[mid]);
        cur.left = sortedArrayToBST(num, start,  mid - 1);
        cur.right = sortedArrayToBST(num, mid + 1, end);
        return cur;    
    }
    public static void main(String[] args) {
		int[] num = {1,2,3,4};
		SortedListToBST obj = new SortedListToBST();
		TreeNode root = obj.sortedArrayToBST(num);
		System.out.println(root.val);
		
	}
}
