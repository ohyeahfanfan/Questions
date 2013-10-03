package Tree;

public class SumRootToLeafNumbers {
	/*
	Sum Root to Leaf Numbers
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

	An example is the root-to-leaf path 1->2->3 which represents the number 123.

	Find the total sum of all root-to-leaf numbers.

	For example,
		1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	
	Return the sum = 12 + 13 = 25.
	
	Test Case 
	1. null
	2.  1
	3.  1
	   /
	  2
	4.  1
	   / \
	  2   3
	
	**/
	
	public int sumNumbers(TreeNode root) {
	   return dfs(root, 0); 
	}
	//!!!!!marked for 不带全局变量的recursion
	public int dfs(TreeNode root, int num){
		//base case
		//cover case 1, case 3 (only have one node)
	    if(root == null) return 0;
	    num = num * 10 + root.val;
	    //cover case  1, case 4
	    if(root.right == null && root.left == null){
	        return num;    
	    }
	    //Recursive call
	    int sum = 0;
	    sum += dfs(root.right, num);
	    sum += dfs(root.left, num);
	    return sum;
	}
}
