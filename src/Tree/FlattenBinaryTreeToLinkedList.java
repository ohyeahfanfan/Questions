package Tree;

import java.util.Stack;

/*
 * Flatten Binary Tree to Linked List 
 * 
 */
public class FlattenBinaryTreeToLinkedList {
	/*
	 * 1. node both has left and right child
	 * a.find the right most child in left, right subtree of current node become the right subtree of right most child in left subtree
	 * b.左子树变右子树  
	 * c.右边走一步
	 * 2. node only has left 
	 * a.左子树变右子树： node.right = node.left
	 * b.右边走一步
	 * 3. node only has right
	 * a.右边走一步
	 * 
	 * Test Case:
	 * 1. null
	 * 2. 1
	 * 3.  1
	 *    /
	 *   2
	 * 4. 1
	 *     \
	 *      2
	 * 5. 1
	 *   / \
	 *  2   3 
	 */
	public void flattenNoExtraSpace(TreeNode root) {
		TreeNode cur = root;
		while(cur != null){
			if(cur.left != null){
				if(cur.right != null){
					//a.find the right most child in the left
					TreeNode rightMostInLeft = cur.left;
					while(rightMostInLeft.right != null){
						rightMostInLeft = rightMostInLeft.right;
					}
					rightMostInLeft.right = cur.right;
				}
				//b.左子树变右子树
				cur.right = cur.left;
				cur.left = null;
			}
			//c.右边走一步
			cur = cur.right;
		}
	}
	public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pre = null;
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
                //!!!记得回收
                cur.left = null;
            }
            if(pre != null){
                pre.right = cur;
                pre = cur;
            }
        }
    }
	
	
}
