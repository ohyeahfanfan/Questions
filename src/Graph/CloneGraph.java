package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		// 1. BST create new node on each old node and construct the mapping
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> visiteds = new HashSet<UndirectedGraphNode>();
		Hashtable<UndirectedGraphNode, UndirectedGraphNode> mapping = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();
		q.offer(node);
		visiteds.add(node);//!!!!!!!!!!!
		while (!q.isEmpty()) {
			UndirectedGraphNode curNode = q.poll();
			// copy node
			UndirectedGraphNode copyNode = new UndirectedGraphNode(
					curNode.label);
			mapping.put(curNode, copyNode);
			for (UndirectedGraphNode neighbor : curNode.neighbors) {
				if (!visiteds.contains(neighbor)) {
					// mark visited
					visiteds.add(neighbor);
					// add to queue
					q.offer(neighbor);
				}
			}
		}
		// 2. connect nodes
		visiteds.clear();
		q.offer(node);
		visiteds.add(node);//!!!!!!!!!!!!!
		while (!q.isEmpty()) {
			UndirectedGraphNode curNode = q.poll();
			// copy node
			UndirectedGraphNode copyNode = mapping.get(curNode);
			for (UndirectedGraphNode neighbor : curNode.neighbors) {
				if (!visiteds.contains(neighbor)) {
					// mark visited
					visiteds.add(neighbor);
					// add to queue
					q.offer(neighbor);
				}
				UndirectedGraphNode neighborCopy = mapping.get(neighbor);
				copyNode.neighbors.add(neighborCopy);
			}
		}
		UndirectedGraphNode copyRoot = mapping.get(node);
		return copyRoot;
	}
	public static void main(String args[] ) throws Exception {
		CloneGraph graph = new CloneGraph();
		UndirectedGraphNode n0 = graph.new UndirectedGraphNode(0);
		n0.neighbors.add(n0);
		n0.neighbors.add(n0);
		graph.cloneGraph(n0);
	}
}
