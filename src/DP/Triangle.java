package DP;

import java.util.ArrayList;

public class Triangle {
	/*
	 * Recursion:
	 * f(i, j) = min(f(i+1,j), f(i+1, j+1)) + triangle[i][j];
	 * 
	 * Test Case:
	 * 1. null => 0;
	 * 2. [[]] => 0;
	 * 3. [[1]] => 0;
	 * 4. [[2],[3,4]] => 5
	 */
	public int minimumTotalDp(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int rowSize = triangle.size();
        int colSize = rowSize;
        //store the min path total ending at each point in the current row
        //eg: at row i minPathTotal[j] the min path total from button until triangle[i][j]
        int[] minPathTotal = new int[colSize];
        //fill last row values to table
        for(int col = 0; col < colSize; col ++){
        	minPathTotal[col] = triangle.get(rowSize-1).get(col);
        }
        //calculate the min path total buttom up
        for(int row = rowSize - 2; row >= 0; row--){
            for(int col = 0; col <= row; col++ ){
            	minPathTotal[col] = Math.min(minPathTotal[col], minPathTotal[col + 1]); 
            	minPathTotal[col] += triangle.get(row).get(col);
            }
        }
        return minPathTotal[0];
    }
	public int minimumTotalRecursive(ArrayList<ArrayList<Integer>> triangle) {
	    if(triangle == null) return 0;
	    return minTotal(triangle, 0, 0);
	}
	
	public int minTotal(ArrayList<ArrayList<Integer>> triangle, int rowIndex, int colIndex){
	    if(rowIndex == triangle.size()) return 0;
	    int left = minTotal(triangle, rowIndex + 1, colIndex);
	    int right = minTotal(triangle, rowIndex + 1, colIndex + 1);
	    return Math.min(left, right) + triangle.get(rowIndex).get(colIndex);
	}
}
