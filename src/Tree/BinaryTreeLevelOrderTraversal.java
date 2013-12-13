package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rez = new ArrayList<ArrayList<Integer>>();
        if(root == null) return rez;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int curLevelNumOfNodes = 1;
        while(!q.isEmpty()){
            int nextLevelNumOfNodes = 0;
            ArrayList<Integer> levelNodes = new ArrayList<Integer>();
            while(curLevelNumOfNodes > 0){
                TreeNode cur = q.poll();
                levelNodes.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                    nextLevelNumOfNodes++;
                }
                if(cur.right != null){
                    q.offer(cur.right);
                    nextLevelNumOfNodes++;
                }
                curLevelNumOfNodes--;
            }
            rez.add(levelNodes);
            curLevelNumOfNodes = nextLevelNumOfNodes;
        }
        return rez;
	}
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		obj.levelOrder(root);
	}	
}