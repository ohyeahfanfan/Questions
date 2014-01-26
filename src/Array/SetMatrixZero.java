package Array;

import DP.GasStation;

public class SetMatrixZero {
	/*
	 * Set Matrix Zeroes 
	 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	 * click to show follow up.
	 * Follow up:
	 * Did you use extra space?
	 * A straight forward solution using O(mn) space is probably a bad idea.
	 * A simple improvement uses O(m + n) space, but still not the best solution.
	 * Could you devise a constant space solution?
	 * 
	 */
	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;
		 //1. firstColZero firstRowZero
        boolean firstColZero = false;
        boolean firstRowZero = false;
        for(int i = 0; i < matrix.length; i++){
        	if(matrix[i][0] == 0){
        		firstColZero = true;
        		break;
        	}
        }
        for(int j = 0; j < matrix[0].length; j++){
        	if(matrix[0][j] == 0){
        		firstRowZero = true;
        		break;
        	}
        }
        //2. record at first row/col if current row/col should all set to zero
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
            	if(matrix[i][j] == 0){
            		matrix[i][0] = 0;
            		matrix[0][j] = 0;
            	}
            }
        }
        //3. set zeros on rest array, base on the record at first row/col
        for(int i = 1; i < matrix.length; i++){
        	if(matrix[i][0] == 0){
        		for(int j = 1; j < matrix[0].length; j++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(int j = 1; j < matrix[0].length; j++){
        	if(matrix[0][j] == 0){
        		for(int i = 1; i < matrix.length; i++){
        			matrix[i][j] = 0;
        		}
        	}
        } 
        //4. set zeros on the 1st row & col  
        if(firstColZero){
        	for(int i = 0; i < matrix.length; i++){
        		matrix[i][0] = 0;
        	}
        }
        if(firstRowZero){
        	for(int j = 0; j < matrix[0].length; j++){
        		matrix[0][j] = 0;
        	}
        }
        return;
	}
	public static void main(String[] args) {
		SetMatrixZero test = new SetMatrixZero();
		int[][] matrix = {{1},{0}};
		test.setZeroes(matrix);
		System.out.println(matrix.length);
	}	
	
}
