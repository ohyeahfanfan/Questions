package Graph;

import java.util.LinkedList;
import java.util.Queue;
/* http://leetcode.com/onlinejudge#question_130
 * Surrounded Regions 7/21/2013
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 *
 * 
 * 
 * 
 */


public class SurroundedRegions {
/*	
	 class Point{
		 int x;
		 int y;
		 Point(int xpos, int ypos){
			 x = xpos;
			 y = ypos;
		 }
	 }
	 public void solve(char[][] board) {
		 //找到所有连通域，有边界
		 Queue<Point> q = new LinkedList<Point>();
		 int height = board.length;
		 if(height==0) return;
		 int weight = board[0].length;
		 for(int i = 0; i < height; i++){
			 if(board[i][0] == 'O'){
				 board[i][0] = 'Y';
				 q.offer(new Point(i, 0));
			 }
			 if(board[i][weight-1] == 'O'){
				 board[i][weight-1] = 'Y';
				 q.offer(new Point(i, weight-1));
			 }
		}
		 for(int i = 0; i < weight; i++){
			 if(board[0][i] == 'O'){
				 board[0][i] = 'Y';
				 q.offer(new Point(0, i));
			 }
			 if(board[height-1][i] == 'O'){
				 board[height-1][i] = 'Y';
				 q.offer(new Point(height-1, i));
			 }
		}
		while(q.size() != 0){
			Point p = q.poll();
			board[p.x][p.y] = 'Y'; //visited flag
			//up
			if(p.x > 0 && board[p.x - 1][p.y] == 'O') q.offer(new Point(p.x - 1, p.y));
			//down
			if(p.x < height - 1 && board[p.x + 1][p.y] == 'O') q.offer(new Point(p.x + 1, p.y));
			//left
			if(p.y > 0 && board[p.x][p.y - 1] == 'O') q.offer(new Point(p.x, p.y - 1));
			//right
			if(p.y < weight - 1 && board[p.x][p.y + 1] == 'O') q.offer(new Point(p.x, p.y + 1));
		}
		
		for(int i = 0; i < height; i++){
			for(int j = 0; j < weight; j++){
				if(board[i][j]=='O'){
					board[i][j] = 'X';
				}else if(board[i][j]=='Y'){
					board[i][j] = 'O';
				}
				
			}
		}
	}*/
	
	public void solveDFS(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // scan from boundary, set all O to Y which can be reachable to boundary O 
        if(board == null || board.length < 2 || board[0].length < 2) return;
        for(int i = 0; i < board.length; i++){
        	changeColorDFS(board, 0, i);
        	changeColorDFS(board, i, 0);
        	changeColorDFS(board, i, board.length-1);
        	changeColorDFS(board, board.length-1, i);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'Y'){//!!!!!!!!!!
                    board[i][j] = 'O';
                }
            }
        }
        
        // set all O to X
        // set all Y to O
    }
    void changeColorDFS(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board.length) return;
        if(board[x][y] == 'O'){
            board[x][y] = 'Y';
            changeColorDFS(board, x+1, y);
            changeColorDFS(board, x-1, y);
            changeColorDFS(board, x, y+1);
            changeColorDFS(board, x, y-1);
        }
    }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			SurroundedRegions s = new SurroundedRegions();
			char[][] board = {{'O','O','O'},{'O','X','O'},{'O','O','O'}};
			s.solve(board);
	}
	 public void solve(char[][] board) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        // scan from boundary, set all O to Y which can be reachable to boundary O 
	        if(board == null || board.length < 2 || board[0].length < 2) return;
	        for(int i = 0; i < board.length; i++){
	        	changeColorBFS(board, 0, i);
	        	changeColorBFS(board, i, 0);
	        	changeColorBFS(board, i, board.length-1);
	        	changeColorBFS(board, board.length-1, i);
	        }
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[0].length; j++){
	                if(board[i][j]=='O'){
	                    board[i][j] = 'X';
	                }else if(board[i][j] == 'Y'){//!!!!!!!!!!
	                    board[i][j] = 'O';
	                }
	            }
	        }
	        
	        // set all O to X
	        // set all Y to O
	    }
	    void changeColorBFS(char[][] board, int x, int y){
	        if(board[x][y] == 'X') return;
	        int n = board[0].length;
	        Queue<Integer> q = new LinkedList<Integer>();
	        q.offer(x * n + y);
	        while(!q.isEmpty()){
	            int pos = q.poll();
	            x = pos / n;
	            y = pos % n;
	            board[x][y] = 'Y';
	            if(x + 1 < board.length && board[x+1][y] == 'O'){
	                int next = pos + n;
	                q.offer(next);
	            }
	            if(x - 1 > 0 && board[x - 1][y] == 'O'){
	            	int next = pos - n;
	                q.offer(next);
	            }
	            if(y - 1 > 0 && board[x][y - 1] == 'O'){
	            	int next = pos - 1;
	                q.offer(next);
	            }
	            if(y + 1 < n && board[x][y + 1] == 'O'){
	            	int next = pos + 1;
	                q.offer(next);
	            }
	        }
	    }	 
}
