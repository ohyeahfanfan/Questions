package Tree;

import java.util.ArrayList;
import java.util.Stack;

import LinkedList.ListNode;
import LinkedList.ReorderList;

public class PreOrderTree {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> rez = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return rez;
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            rez.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return rez;
    }
	
}
