package Recursive;

import DP.GasStation;

public class WordSearch {
	 /*
    idea:
    1.find the start character
    2.DFS find the rest part of word
    Since the same letter cell may not be used more than once then extra space to record if it is recorded in the space.
    */
    public boolean exist(char[][] board, String word) {
        boolean exists = false;
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return exists;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
               if(board[i][j] == word.charAt(0)){
                    exists = dfs(board, visited, i, j, word, 0);
                    if(exists) return exists;       
               }
            }
        }
        return exists;
    }
    public boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int index){
        if(index >= word.length()) return false;
        visited[x][y] = true;
    	if(!visited[x][y]&&board[x][y] == word.charAt(index)){
            
            if(x > 0 && dfs(board, visited, x-1, y, word, index + 1)){
                return true;
            }
            if(y > 0 && dfs(board, visited, x, y-1, word, index + 1)){
                return true;
            }
            if(x < board.length - 1 && dfs(board, visited, x+1, y, word, index + 1)){
                return true;
            }
            if(y < board[0].length - 1 && dfs(board, visited, x, y+1, word, index + 1)){
                return true;
            }
            if(index == word.length() - 1){ 
            	return true;
            }
        }
    	visited[x][y] = false;
        return false;
    }
    public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		/*char[][] board = {{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		System.out.println(ws.exist(board, "ABCCED"));*/
		char[][] board = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
		System.out.println(ws.exist(board, "aaaaaaaaaaaaaa"));
	}
}
