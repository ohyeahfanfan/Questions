package OOP;
import java.util.Hashtable;
/*
 * LRU Cache Total 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * Points:
 * 1. In the double linked list, each node has two pointers, pre and next
 * Therefore, each operation needs update two pointers
 * 2. LRU Cache has two data structures, hashtable and linkedlist, both of them need to be updated at the same time
 * 3. Two helper classes: node and list
 * Space Complexity O(n), Time Complexity O(n) 
 * 
 */
class DoubleLinkedListNode{
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;
    public int val;
    public int key;
    public DoubleLinkedListNode(DoubleLinkedListNode pre, DoubleLinkedListNode next, int key, int val){
        this.pre = pre;
        this.next = next;
        this.val = val;
        this.key = key;
    }
}
class DoubleLinkedList{
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private int length;
    // O(1)
    public int length(){
    	return length;
    }
    public void addFirst(DoubleLinkedListNode node){
        if(head == null){
            head = node;
            tail = head;
        }else{
            node.next = head;
            head.pre = node;
            head = node;
        }
        length ++;
    }
    public void remove(DoubleLinkedListNode node){
        //0<->1<->2
        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            //eg: 1->null remove 1 or 1->2->null remove 1 
            //node is the head
            head = head.next;
        }
        /* 0----->2
         * 0<-1<->2
         */
        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            //eg: 1->null remove 1 or 1->2->null remove 2
            //node is the tail
            tail = node.pre;
        }
        /*0<--->2
         *0<-1->2
         *!!
         */
        node.pre = null;
        node.next = null;
        /*
         * 0<->2
         * null<-1->null
         */
        length--;
    }
    public DoubleLinkedListNode removeLast(){
        DoubleLinkedListNode removed = tail;
    	if(tail != null){
            tail = tail.pre;
            //!!break the link between the new tail and the nodes after it
            tail.next = null;
            removed.pre = null;
            length--;
        }
    	return removed;
    }
}
public class LRUCache {
    private int capacity;
    //1.to check if the key exists in the cache or not
    //2.keep the reference of the list node.
    private Hashtable<Integer,DoubleLinkedListNode> table = new Hashtable<Integer,DoubleLinkedListNode>();
    //keep the node in order. The freshest one is the head
    private DoubleLinkedList list = new DoubleLinkedList();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int rez = -1;
        if(table.containsKey(key)){
            DoubleLinkedListNode cur = table.get(key);
            list.remove(cur);
            list.addFirst(cur);
            rez = cur.val;
        }
        return rez;
    }
    
    public void set(int key, int value) {
        //1. locate the node by key, if exists remove the node from the list
        DoubleLinkedListNode cur;
        if(table.containsKey(key)){
            cur = table.get(key);
            cur.val = value;
            list.remove(cur);
        }else{
            cur = new DoubleLinkedListNode(null, null, key,value);
            //add new node to table
            table.put(key, cur);
        }
        //2. insert the node in the beginning of list
        list.addFirst(cur);
        //3. if exceed the capacity, update the tail
        if(list.length() > this.capacity){
        	DoubleLinkedListNode removed = list.removeLast();
        	table.remove(removed.key);
        }
    }


   
}
