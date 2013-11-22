package Recursive;
 
public class SumNumber {
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, root.val);
    }
    public int dfs(TreeNode root, int curSum){
        if(root.right == null && root.left == null){
            return curSum;
        }
        int right = 0;
        if(root.right != null){
            right = dfs(root.right, curSum * 10 + root.right.val);
        }
        int left = 0;
        if(root.left != null){
            left = dfs(root.left, curSum * 10 + root.left.val);
        }
        return right + left;
    }
}
