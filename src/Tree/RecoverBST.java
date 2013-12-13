package Tree;

public class RecoverBST {
	/* Recover Binary Search Tree
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * Recover the tree without changing its structure.
	 * Note:
	 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
	 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	 */
	class Result{
		TreeNode pre;
		TreeNode first;
		TreeNode second;
	}
	public void recoverTree(TreeNode root) {
        Result rez = new Result();
		search(root, rez);
		if(rez.first == null) return;
        int val = rez.first.val;
        rez.first.val = rez.second.val;
        rez.second.val = val;
    }
	private void search(TreeNode cur, Result rez){
		if(cur == null) return;
		search(cur.left, rez);
		if(rez.pre != null){
			if(rez.pre.val > cur.val){
				if(rez.first == null){
					rez.first = rez.pre;
					rez.second = cur;
				}else{
					rez.second = cur;
				}
			}
		}
		rez.pre = cur;
		search(cur.right, rez);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoverBST obj = new RecoverBST();
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(-1);
		obj.recoverTree(root);
	}

}
