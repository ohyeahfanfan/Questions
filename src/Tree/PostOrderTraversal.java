package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
	/*
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 * For example:
	 * Given binary tree {1,#,2,3},
	 * return [3,2,1].
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * Test Case:
	 * 1. null
	 * 2. 1
	 * 3. 1,#,2,3
	 * 
	 */
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        ArrayList<Integer> rez = new ArrayList<Integer>();
	        if(root == null) return rez;
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(root);
	        TreeNode pre = null;
	        while(!stack.empty()){
	        	TreeNode cur = stack.peek();
	        	if(cur.left != null && pre != cur.left){
	        		stack.push(cur.left);
	        	}else if(cur.right != null && pre != cur.right){
	        		stack.push(cur.right);
	        	}else{
	        		pre = stack.pop();
	        		rez.add(pre.val);
	        	}
	        }
	        return rez;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostOrderTraversal obj = new PostOrderTraversal();
		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(2);
		node.right.left = new TreeNode(3);
		obj.postorderTraversal(node);
		
	}

}
