package Tree;

import java.util.ArrayList;

import Math.Sqrt;

public class PathSumII {
	/*
	 * http://leetcode.com/onlinejudge#question_101
	 * Path Sum 7/22/2013
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	 * For example:
	 * Given the below binary tree and sum = 22, 
	 * 
	 */
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return results;
        helper(root, sum, results, result);
        return results;
    }
    public void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result){
        int rest = sum - root.val;
        result.add(root.val);
        if(root.left == null && root.right == null && rest == 0){
            ArrayList<Integer> copy = new ArrayList<Integer>(result);
            results.add(copy);
            result.remove(result.size()-1);
            return;
        }
        if(root.left != null){
            helper(root.left, rest, results, result);
        }
        if(root.right != null){
            helper(root.right, rest, results, result);
        }
        result.remove(result.size()-1);
    }
    public static void main(String[] args) {
    	PathSumII ps = new PathSumII();
    	TreeNode root = new TreeNode(1);
		ps.pathSum(root, 1);
	 }
}
