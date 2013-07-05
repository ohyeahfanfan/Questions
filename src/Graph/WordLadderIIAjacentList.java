package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderIIAjacentList {

	/**
	 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

		Only one letter can be changed at a time
		Each intermediate word must exist in the dictionary
		For example,
		
		Given:
		start = "hit"
		end = "cog"
		dict = ["hot","dot","dog","lot","log"]
		
		Return
		
		  [
		    ["hit","hot","dot","dog","cog"],
		    ["hit","hot","lot","log","cog"]
		  ]
	 *  
	 *  Solution:
	 *  Compare to the WordLadder II
	 *  The queue stores the shortest paths 
	 *  from start to current level string in the dictionary
	 *  
	 *  To slow to pass the large cases
	 *     
	 */
	/*
	 * Assume word "end" sits at level k
	 * 1. create a graph store shortest path from word start to the words at level k
	 * 2. from word "end" dfs util word "start" 
	 * 
	 * Save space, compare to method 1 WordLadderIIPathQueue
	 * 1. Since all the edges are stored once. instead of multiple times in method 1
	 * */
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
    	//each word, the length from start word to current word
        Hashtable<String, Integer> wordShortestPath = new Hashtable<String, Integer>();
        //we can build a graph, which only contains the shortest paths 
        //from start word to the words which depth less than shortest path from start to end
    	Hashtable<String, ArrayList<String>> graph = new Hashtable<String, ArrayList<String>>();
		//BSF traverse the tree by level, 
    	//curLevelLeftNodes stores the number of remaining nodes in the current level 
    	int curLevelLeftNodes = 1;
    	//curDepth stores current depth
		int curDepth = 1;
		if(dict.contains(start)){
			wordShortestPath.put(start, curDepth);
		}
	    queue.add(start);
		int shortestDepth = Integer.MAX_VALUE;
		//all the shortest paths have same length
		//if current depth > shortLen, we don't need move forward.
		while(queue.size() != 0 && curDepth < shortestDepth){
			curDepth++;
			while(curLevelLeftNodes > 0){
				String word = queue.poll();
				curLevelLeftNodes--;
				ArrayList<String> neighbors = this.getNeighbors(word, dict, end);
				for(String neighbor : neighbors){
					//!hey we find you
					if(neighbor.equals(end) && shortestDepth == Integer.MAX_VALUE){
						//first time touch the end, and update shortestDepth: from start to end
						shortestDepth = curDepth;
					}
					//if this is the first time, we didn't reach the word before
					//1.add the edge to graph
					//2.update the shortest path from start to current word
					//3.add current word to the queue
					if(!wordShortestPath.containsKey(neighbor)){
						wordShortestPath.put(neighbor, curDepth);
						queue.add(neighbor);
						ArrayList<String> edges = new ArrayList<String>();
						//add the edge from neighbor to word
						edges.add(word);
						graph.put(neighbor, edges);
					}else if(wordShortestPath.get(neighbor)==curDepth){
						//if we visit the word neighbor before, 
						//but its distance from start to neighbor is same with its shortest path 
						//we should add the edge to graph too
						graph.get(neighbor).add(word);
					}else{
						//do nothing
						//current edge from neighbor to word is not on the shortest path
					}
					
				}
			}
			//current queue size will be next level size
			curLevelLeftNodes = queue.size();
		}
		//back track  graph from end to start, collect all the paths
		ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
		path.add(end);
		dfs(paths,path,graph,start);
		return paths;
	}
	//back track from end to start, collect all the paths
	public void dfs(ArrayList<ArrayList<String>> rez, ArrayList<String> path, Hashtable<String, ArrayList<String>> graph, String dest){
		String cur = path.get(path.size()-1);
		if(cur.equals(dest)){
			//shallow copy, but String is immutable, doesn't contain any references to other classes.
			ArrayList<String> copy = new ArrayList<String>(path);
			//reverse the copy, since the graph stores the reversed edge
			//time complexity here O(n)
			for(int i = 0, j = copy.size()-1; i < j; i++, j--){
				String temp = copy.get(i);
				copy.set(i, copy.get(j));
				copy.set(j, temp);
			}
			rez.add(copy);
			return;
		}
		ArrayList<String> adjs = graph.get(cur);
        if(adjs == null) return;
		for(String word: adjs){
			path.add(word);
			dfs(rez, path, graph, dest);
			path.remove(path.size()-1);
		}
	}
	   
	/*
	 * Get all possible one step transforms 
	 */
	public ArrayList<String> getNeighbors(String word, HashSet<String> dict, String end){
		ArrayList<String> neighbors = new ArrayList<String>();
		char[] letters = word.toCharArray();
		for(int i = 0; i < word.length(); i++){
			char letter = letters[i];
			for(char c = 'a'; c <= 'z'; c++){
				if(c == letter) continue;
				letters[i] = c;
				String neighbor = new String(letters);
				//exist in the dictionary or neighbor equals to end
				if(dict.contains(neighbor)||end.equals(neighbor)){
					neighbors.add(neighbor);
				}
				//!!!!
				letters[i] = letter;
			}
		}
		return neighbors;
	}
	public static void main(String[] args) {
		//"lost", "miss", ["most","mist","miss","lost","fist","fish"]
		String[] arr = {"most","mist","miss","lost","fist","fish"};
	    HashSet<String> dict =  new HashSet<String>();
		for(String word: arr){
			dict.add(word);
		}
		WordLadderIIAjacentList wl = new WordLadderIIAjacentList();
		ArrayList<ArrayList<String>> paths = wl.findLadders("lost", "miss", dict);
		System.out.println("==========");
		System.out.println(paths);
		
	}

}
