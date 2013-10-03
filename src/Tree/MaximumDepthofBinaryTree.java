package Tree;
/*
 * Maximum Depth of Binary Tree 7/22/2013
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down 
 * to the farthest leaf node
 */
public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null){
			//!!!! return 1
			return 1;
		}
		return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
	}
}
