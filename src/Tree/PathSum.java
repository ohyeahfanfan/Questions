package Tree;

public class PathSum {
	/*
	 * http://leetcode.com/onlinejudge#question_101
	 * Path Sum 7/22/2013
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	 * For example:
	 * Given the below binary tree and sum = 22, 
	 * 
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
        //£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡walk around test case {}, 0 
        int leftSum = sum - root.val;
        // the ending point must be leaf
        if(leftSum == 0 && root.right==null && root.left==null) return true;
        if(hasPathSum(root.left, leftSum))return true;
        if(hasPathSum(root.right, leftSum))return true;
        return false;
    }
}
