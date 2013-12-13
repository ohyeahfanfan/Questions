package Tree;

import DP.UniqueBST;

public class ConstructBinaryTreeFromPostInOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null) return null;
        return buildTreeHelper(inorder, 0, postorder, 0, postorder.length);
    }
    public TreeNode buildTreeHelper(int[] inorder, int startIn, int[] postorder, int startPost, int len) {
        if(len <= 0) return null;
        int rootVal = postorder[startPost + len - 1];
        int rootIndex = startIn;
        while(rootVal != inorder[rootIndex]){
            rootIndex++;
        }
        TreeNode node = new TreeNode(rootVal);
        int leftLen = rootIndex - startIn;
        node.left = buildTreeHelper(inorder, startIn, postorder, startPost, leftLen );
        node.right = buildTreeHelper(inorder, rootIndex + 1, postorder, startPost + leftLen, len -leftLen -1);
        return node;
    }
    public static void main(String[] args) {
		ConstructBinaryTreeFromPostInOrder obj = new ConstructBinaryTreeFromPostInOrder();
		int[] inorder = {4,2,5,1,3};
		int[] postorder = {4,5,2,3,1};
		TreeNode root = obj.buildTree(inorder,  postorder);
		System.out.println(root);
	}
}
