package Tree;

import java.util.ArrayList;
import java.util.Stack;

/*
 *Binary Tree Inorder Traversal 
 *
 Given a binary tree, return the inorder traversal of its nodes' values.
 *For example:
 *Given binary tree {1,#,2,3}, 
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 */
public class InOrderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> rez = new ArrayList<Integer>();
        if(root == null) return rez;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){
            //left subtree hasn't been visited yet
        	if(cur != null){
                stack.push(cur);
                cur = cur.left;
            //left subtree has been visited
            }else{
                cur = stack.pop();
                rez.add(cur.val);
                cur = cur.right;    
            }
        }
        return rez;
    }
	public static void main(String[] args) {
		
	}
}
