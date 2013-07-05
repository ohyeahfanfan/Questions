package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

	/**
	 *  http://leetcode.com/onlinejudge#question_127
	 *  Word Ladder
	 *	Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
	 *	
	 *	Only one letter can be changed at a time
	 *	Each intermediate word must exist in the dictionary
	 *	For example,
		
	 *	Given:
	 *	start = "hit"
	 *	end = "cog"
   	 *  dict = ["hot","dot","dog","lot","log"]
		
	 *	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	 *  return its length 5.
		
	 *  Note:
		
	 *  Return 0 if there is no such transformation sequence.
	 *	All words have the same length.
	 *  All words contain only lowercase alphabetic characters.
	 *  
	 *  Solution:
	 *  Since we want to know the shortest path, BFS should be used.
	 *  To avoid revisit same node, we should have a table to track if the word is visited or not 
	 *  (avoid the circle in the graph)
	 *  1. transform one word to another word (getNeighbours)
	 *  2. check if new word is the target, if yes return
	 *  3. if no, check if new word exists in dict, if no conintue
	 *  4. if yes, add new word to queue
	 */
	public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
		HashSet<String> visitedWords = new HashSet<String>();
		int length = 1;
		int currentLevelSize = 1;
		queue.add(start);
		while(queue.size() != 0){
			length++;
			while(currentLevelSize > 0){
				String word = queue.poll();
                currentLevelSize--;
				ArrayList<String> neighbours = this.getNeighbours(word);
				for(String neighbour : neighbours){
					//!hey we find you
					if(neighbour.equals(end)){
						return length;
					}else{
						//only put unvisited word to queue
						if(dict.contains(neighbour)&&!visitedWords.contains(neighbour)){
							visitedWords.add(neighbour);
							queue.add(neighbour);
						}
					}
				}
			}
			//current queue size will be next level size
			currentLevelSize = queue.size();
		}
		return 0;
    }
	
	/*
	 * Get all possible one step transforms 
	 */
	public ArrayList<String> getNeighbours(String word){
		ArrayList<String> neighbors = new ArrayList<String>();
		char[] letters = word.toCharArray();
		for(int i = 0; i < word.length(); i++){
			char letter = letters[i];
			for(char c = 'a'; c <= 'z'; c++){
				if(c == letter) continue;
				letters[i] = c;
				neighbors.add(new String(letters));
				//!!!!
				letters[i] = letter;
			}
		}
		return neighbors;
	}
       
	public static void main(String[] args) {
		//"hot", "dog", ["hot","dog","dot"]
		HashSet<String> dict =  new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength("hot", "dog", dict));
		 
	}

}
