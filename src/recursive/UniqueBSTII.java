package Recursive;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class UniqueBSTII {
	public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1,n);
    }
    
    public ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        
        if(start > end){
            res.add(null);   
        }else if(start == end){
            res.add(new TreeNode(start));
        }else if(start < end){
            for(int i = start; i <= end; i++){
                ArrayList<TreeNode> leftSubtreeRoots = generateTrees(start,i-1);
                ArrayList<TreeNode> rightSubtreeRoots = generateTrees(i+1,end);
                
                for(TreeNode leftSubtreeRoot:leftSubtreeRoots){
                    for(TreeNode rightSubtreeRoot:rightSubtreeRoots){
                        TreeNode cur= new TreeNode(i);
                        cur.left = leftSubtreeRoot;
                        cur.right = rightSubtreeRoot;
                        res.add(cur);
                    }
                }

            }
        } 
        return res;
    }
}
