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
	}
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			SurroundedRegions s = new SurroundedRegions();
			char[][] board = new char[1][1];
			board[0][0] = 'X';
			s.solve(board);
		}
	 
}
