package Tree;

public class ConstructBinaryTreeFromPreInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null)
			return null;
		return buildTreeHelper(inorder, 0, preorder, 0, preorder.length);
	}

	public TreeNode buildTreeHelper(int[] inorder, int startIn, int[] preorder,
			int startPre, int len) {
		if (len <= 0)
			return null;
		int rootVal = preorder[startPre];
		int rootIndex = startIn;
		while (rootVal != inorder[rootIndex]) {
			rootIndex++;
		}
		TreeNode node = new TreeNode(rootVal);
		int leftLen = rootIndex - startIn;
		node.left = buildTreeHelper(inorder, startIn, preorder, startPre + 1,
				leftLen);
		node.right = buildTreeHelper(inorder, rootIndex + 1, preorder, startPre
				+ leftLen + 1, len - leftLen - 1);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromPreInorder obj = new ConstructBinaryTreeFromPreInorder();
		int[] inorder = {4,2,5,1,3};
		int[] preorder = {1,2,4,5,3};
		TreeNode root = obj.buildTree(preorder, inorder);
		System.out.println(root.val);
	}

}
