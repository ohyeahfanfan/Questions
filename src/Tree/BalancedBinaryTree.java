package Tree;
/*
 * Balanced Binary Tree 7/22/2013
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 * 
 * IsBalanced(root) = IsBalanced(root.right) && IsBalanced(root.left) && |height(root.right)-height(root.left)| < 1
 * 
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(height(root) == -1) return false;
        return true;
    }
    // -1 not balance
    // >= 0 height of tree
    public int height(TreeNode root){
        if(root == null) return 0;
        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;
        if(Math.abs(rightHeight - leftHeight) > 1) return -1;
        return Math.max(rightHeight, leftHeight) + 1;
    }
}
