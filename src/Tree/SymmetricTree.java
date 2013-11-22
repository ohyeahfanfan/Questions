package Tree;

/* http://leetcode.com/onlinejudge#question_101
 * 
 * Symmetric Tree 7/22/2013
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric: 
 * 
 * 这道题目比较新颖的地方是，如何reduce problem
 * 不是一般的N=>N-1 而是 symmetric tree =》 same tree
 * Symmetric Tree can be reduced to Symmetric Tree
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return areSymmetric(root.left, root.right);
    }
    public boolean areSymmetric(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return true;
        }
        if(l == null || r == null){
            return false;
        }
        if(l.val != r.val) return false;
         if(areSymmetric(l.left, r.right) && areSymmetric(l.right, r.left)){
            return true;
        }
        return false;
    }
}
