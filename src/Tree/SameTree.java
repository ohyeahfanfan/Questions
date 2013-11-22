package Tree;
/*
 * http://leetcode.com/onlinejudge#question_100 
 * Same Tree 7/22/2013
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 *	Test Case:
 *	1. null vs null
 *	2. 1 vs 1
 *	3. 1,2, # vs 1, 2,#
 *	4. null vs !null
 *	5. 1 vs 0
 *	6, 1, 2, # vs 1, #, 2
 *
 *  Solution:
 *  IsSameTree(root) = IsSameTree(root.left) && IsSameTree(root.right) 
 */
public class SameTree {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
            return true;
        }
        return false;
    }
}
