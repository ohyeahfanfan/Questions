package Bit;

import BinarySearch.SearchRange;

public class IsValidNumber {
	public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blocks = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
            	if(board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                if(testAndSet(rows, i, c) 
                ||testAndSet(cols, j, c)  
                ||testAndSet(blocks, i / 3 * 3 + j / 3, c)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean testAndSet(int[] arr, int index, int bit){
        if((arr[index]&(1 << bit)) != 0){
            return true;
        }
        arr[index] |= (1 << bit);
        return false;
    }
    public static void main(String[] args) {
    	
    }
}
