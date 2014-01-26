package BinarySearch;

import java.util.Arrays;

public class SearchInMatrix {
    /********Search a 2D Matrix****************** 
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties: 
      
    Integers in each row are sorted from left to right. 
    The first integer of each row is greater than the last integer of the previous row. 
    For example, 
      
    Consider the following matrix: 
      
    [ 
      [1,   3,  5,  7], 
      [10, 11, 16, 20], 
      [23, 30, 34, 50] 
    ] 
    Given target = 3, return true. 
 *  
 */
public boolean searchMatrix(int[][] matrix, int target) { 
    // Start typing your Java solution below 
    // DO NOT write main() function 
    //find row 
    int[] col0 = new int[matrix.length]; 
    for(int i = 0; i<matrix.length;i++){ 
        col0[i]= matrix[i][0]; 
    } 
    int colIndex = findInsertPoint(col0, target); 
   //!!!!!!!!!!又忘记了读书组之前看看在不在range里面 
    if(colIndex != matrix.length&&matrix[colIndex][0]==target) return true; 
      
    colIndex = colIndex -1; 
    if(colIndex<0)return false; 
    //find col 
    int rowIndex = findInsertPoint(matrix[colIndex], target); 
    if(rowIndex != matrix[0].length&&matrix[colIndex][rowIndex]==target)return true; 
    return false; 
} 
public boolean searchMatrixTwice(int[][] matrix, int target) { 
    if(target < matrix[0][0]||target > matrix[matrix.length-1][matrix[0].length-1]){ 
        return false; 
    } 
    //find row 
    int[] lastCol = new int[matrix.length]; 
    for(int i = 0; i < matrix.length; i++){ 
        lastCol[i] = matrix[i][matrix[0].length-1]; 
    } 
    int rowIndex = Arrays.binarySearch(lastCol, target); 
    if(rowIndex >= 0) return true; //!!!!">=" 
    else rowIndex = - rowIndex - 1; 
    int colIndex = Arrays.binarySearch(matrix[rowIndex], target); 
    if(colIndex >= 0) return true; 
    else return false; 
} 
public int findInsertPoint(int[] A, int target){ 
    int left = 0; 
    int right = A.length-1; 
    while(left<=right){ 
        int mid = (left+right)/2; 
        if(A[mid]<target){ 
            left = mid + 1; 
        }else{ 
            right = mid -1; 
        } 
    } 
    return left; 
}
}
