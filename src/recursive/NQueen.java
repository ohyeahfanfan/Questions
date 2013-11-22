package Recursive;

import java.util.ArrayList;
/*
 * http://leetcode.com/onlinejudge#question_51
 * CRC 9.9
 * N-Queens
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle: 
 * 
 * 
 */
public class NQueen {
	public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> rez = new ArrayList<String[]>();
        int[] solution = new int[n]; //index is row, value is column
        int row = 0;
        placeQueen(row, solution, rez);
        return rez;
    }
    
    public void placeQueen(int row, int[] solution, ArrayList<String[]> rez){
        if(row == solution.length){
            rez.add(convertRez(solution));
            return;
        }
        for(int i = 0; i < solution.length; i++){
            if(validSpot(row, i, solution)){
                solution[row] = i;
                placeQueen(row+1, solution, rez);
            }
        }
        
    }
    
    public boolean validSpot(int row, int col, int[] solution){
        //1st row can pick any column
        for(int i = 0; i < row; i++){
            //no same column
            if(solution[i]==col){
                return false;
            }
            //diagonals no same row
            int rowDiff = Math.abs(i-row);
            int colDiff = Math.abs(solution[i] - col);
            if(rowDiff == colDiff) return false;
        }
        return true;
    }
    public String[] convertRez(int[] solution){
        String[] rez = new String[solution.length];
        for(int i = 0; i < solution.length; i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < solution.length; j++){
                if(solution[i]!=j){
                    sb.append(".");
                }else{
                    sb.append("Q");
                }    
            }
            rez[i] = sb.toString();
        }
        return rez;
    }
    public static void main(String[] args) {
   	 	NQueen q = new NQueen();
   	 	q.solveNQueens(4);
	}

}
