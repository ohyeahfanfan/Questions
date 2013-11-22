package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @Question:
 * Word Break II
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 有一下几种不同的构造图的方法
 * 1. the end index of pre word
 * 0 1 2 3 4 5 6 7 8 9
 * c a t s a n d d o g
 *     | |     |     |
 *    -1-1     2     6
 *             |
 *             3
 * 2. the start index of cur word            
 * 0 1 2 3 4 5 6 7 8 9
 * c a t s a n d d o g
 *     | |     |     |
 *     0 0     3     7
 *             |
 *             4
 * 3. current word which ends at the current index            
 * 0 1 2 3 4 5 6 7 8 9
 * c a t s a n d d o g
 *     | |     |     |
 *   catcats  and   dog
 *             |
 *            sand
 * 
 */
public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String>[] graph = new ArrayList[s.length()];
		// possible steps, we only jump the steps which contains in the dict.
		// it will reduce the jump times
		Set<Integer> steps = new HashSet<Integer>();
		for (String word : dict) {
			steps.add(word.length());
		}
		//build graph
		for (int end = 0; end < s.length(); end++) {
			String word = s.substring(0, end + 1);
			if (dict.contains(word)) {
				ArrayList<String> words = new ArrayList<String>();
				words.add(word);
				graph[end] = words;
			}
			for (int step : steps) {
				int start = end - step;
				if (start < 0) continue;
				if (graph[start] != null) {
					word = s.substring(start + 1, end + 1);
					if (dict.contains(word)) {
						ArrayList<String> words = null;
						if (graph[end] == null) {
							words = new ArrayList<String>();
						} else {
							words = graph[end];
						}
						words.add(word);
						graph[end] = words;
					}
				}
			}
		}
		//dfs the graph
		ArrayList<String> sentences = new ArrayList<String>();
		String sentence = "";
		dfs(graph, graph.length - 1, sentence, sentences);
		return sentences;
	}

	public void dfs(ArrayList<String>[] graph, int end, String sentence,
			ArrayList<String> sentences) {
		if (end == -1) {
			sentences.add(sentence);
			return;
		}
		ArrayList<String> words = graph[end];
		if (words == null)
			return;
		for (String word : words) {
			String next = (sentence == "" ? word : word + " ");// !!!!
			next += sentence;
			dfs(graph, end - word.length(), next, sentences);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII wb = new WordBreakII();
		Set<String> dict = new HashSet<String>();
		// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
		/*
		 * dict.add("a"); dict.add("aa"); dict.add("aaa"); dict.add("aaaa");
		 * dict.add("aaaaa"); dict.add("aaaaaa"); dict.add("aaaaaaa");
		 * dict.add("aaaaaaaa"); dict.add("aaaaaaaaa"); dict.add("aaaaaaaaaa");
		 * wb.wordBreak(
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
		 * , dict);
		 */
		dict.add("a");
		wb.wordBreak("a", dict);
	}
}
