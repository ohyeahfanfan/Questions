package Array;

import java.util.ArrayList;

public class SpiralMatrixII {
	//[]
    //[1]
    //[[1,2],[4,3]]
    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[0][0];
        int[][] rez = new int[n][n];
        fillInMatrix(rez, n, 0, 1);
        return rez;
    }
    public void fillInMatrix(int[][] matrix, int len, int layer, int index){
        if(len == 0){
            return;
        }
        if(len == 1){
            for(int j = layer; j < layer + len; j++){
                matrix[layer][j] = index;
                index ++;
            }
            return;
        }
        for(int j = layer;  j < layer + len; j++){
            matrix[layer][j] = index;
            index ++;
        }
        for(int i = layer + 1; i < layer + len; i++ ){
            matrix[i][layer + len - 1] = index;
            index ++;
        }
        for(int j = layer + len - 2; j >= layer; j--){
            matrix[layer + len - 1][j] = index;
            index ++;
        }
        for(int i = layer + len - 2; i > layer; i--){
            matrix[i][layer] = index;
            index ++;
        }
        fillInMatrix(matrix, len - 2, layer + 1, index);
        return;
    }
    public static void main(String[] args) {
    	SpiralMatrixII sm = new SpiralMatrixII();
		//int[][] matrix = sm.generateMatrix(1);
		//System.out.println(matrix.length);
		int[][] matrix  = sm.generateMatrix(3);
		System.out.println(matrix.length);
	}
}
