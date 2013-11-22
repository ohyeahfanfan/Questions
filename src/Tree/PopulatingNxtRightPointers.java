package Tree;

public class PopulatingNxtRightPointers {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val = x;
		}
	}
	public void connect(TreeLinkNode root) {
		TreeLinkNode curLevelNode = root;
		while (curLevelNode != null) {
			TreeLinkNode nxtLevelHeadNode = null;
			TreeLinkNode nxtLevelPreNode = null;
			while (curLevelNode != null) {
				if (curLevelNode.left != null) {
					if (nxtLevelPreNode != null) {
						nxtLevelPreNode.next = curLevelNode.left;
						nxtLevelPreNode = nxtLevelPreNode.next;
					} else {
						nxtLevelHeadNode = curLevelNode.left;
						nxtLevelPreNode = curLevelNode.left;
					}
				}
				if (curLevelNode.right != null) {
					if (nxtLevelPreNode != null) {
						nxtLevelPreNode.next = curLevelNode.right;
						nxtLevelPreNode = nxtLevelPreNode.next;
					} else {
						nxtLevelHeadNode = curLevelNode.right;
						nxtLevelPreNode = curLevelNode.right;
					}
				}
				curLevelNode = curLevelNode.next;
			}
			curLevelNode = nxtLevelHeadNode;
		}
	}

}
