package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @Question
 * Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity
 * 
 * @Solution
 * Time complexity
 * O(klogn) 
 * 
 * @Learned:
 * 1. PriorityQueue in Java cannot have initialCapacity 0, so here we need
 * 2. Ð¡¶¥¶Ñ
 *    if (a.val < b.val)
 *		return -1;
 *	  else if (a.val > b.val)
 *		return 1;
 *	  else
 *		return 0
 * 3. class MinHeapComparator implements Comparator<ListNode>
 * 
 * @Test Cases:
 * 1. []
 * 2. [{}]
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeKSortedLists {
	public static class MinHeapComparator implements Comparator<ListNode> {
		public int compare(ListNode a, ListNode b) {
			if (a.val < b.val)
				return -1;
			else if (a.val > b.val)
				return 1;
			else
				return 0;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode head = null;
		ListNode cur = null;
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// PriorityQueue in Java cannot have initialCapacity 0, so here we need
		// to check if lists.size() == 0
		if (lists == null || lists.size() == 0)
			return head;
		// why the size of heap is lists.size()?
		// The max should be bigger than rest of lists.size() element
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(
				lists.size(), new MinHeapComparator());
		// fill the heap
		for (ListNode list : lists) {
			if (list == null)
				continue;
			minHeap.offer(list);
		}
		// extract one and insert one
		while (!minHeap.isEmpty()) {
			ListNode min = minHeap.poll();
			if (head == null) {
				head = min;
				cur = head;
			} else {
				cur.next = min;
				cur = cur.next;
			}
			if (min.next != null) {
				minHeap.offer(min.next);
			}
		}
		return head;
	}
}
