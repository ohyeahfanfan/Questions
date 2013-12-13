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
        TreeNode pre = null;
        TreeNode cur = root;
        while(!stack.empty()|| cur != null){
        	//Status 1: left subtree hasn't been visited yet.
        	if(cur != null){
        	    stack.push(cur);
        	    cur = cur.left;
        	//Status 2 & 3:    
        	}else{
        	    cur = stack.peek();
        	    //Status 2: left subtree is visited but right subtree hasn't visited
        	    if(cur.right != null && pre != cur.right){
        	        cur = cur.right;
        	    //Status 3: both subtrees are visited
        	    }else{
        	        pre = stack.pop();
        	        rez.add(pre.val);
        	        cur = null;   
        	    }
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
		node.left = new TreeNode(2);
		obj.postorderTraversal(node);
		
	}

}
