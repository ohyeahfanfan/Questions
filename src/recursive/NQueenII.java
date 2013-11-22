package Recursive;
/*
 * Leetcode:
 * http://leetcode.com/onlinejudge#question_52
 * N-Queens II 7/21/2013
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, 
 * return the total number of distinct solutions. 
 * 
 * 
 */
public class NQueenII {
	public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] solution = new int[n];
        return placeQueen(0, n, solution);
    }
    
    public int placeQueen(int row, int n, int[] solution){
        if(row==n){
            return 1;
        }
        int count = 0;
        for(int col = 0; col < n; col++){
            if(validSpot(row, col,solution)){
                solution[row] = col;
                count += placeQueen(row+1, n, solution);
            }
        } 
        return count;
    }
    
    public boolean validSpot(int row, int col, int[] solution){
        for(int i = 0; i < row; i++){
            if(solution[i]==col){
                return false;
            }
            if(Math.abs(solution[i]-col)==Math.abs(i-row)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		NQueenII q = new NQueenII();
		System.out.println(q.totalNQueens(8));
		
	}
}
