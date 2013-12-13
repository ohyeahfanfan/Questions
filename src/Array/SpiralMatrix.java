package Array;

import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	if(matrix == null || matrix.length == 0) return new ArrayList<Integer>();
    	int rowLen = matrix.length;
    	int colLen = matrix[0].length;
        return printByLayer(matrix, rowLen, colLen, 0);
    }
    public ArrayList<Integer> printByLayer(int[][] matrix, int rowLen, int colLen, int layer){
        ArrayList<Integer> rez = new ArrayList<Integer>();
        //base case
        if(rowLen == 0 || colLen == 0) return rez;
        if(rowLen == 1) {
            for(int i = 0; i < colLen; i++){
                rez.add(matrix[layer][layer + i]);
            }
            return rez;
        }else if(colLen == 1){
            for(int i = 0; i < rowLen; i++){
                rez.add(matrix[layer + i][layer]);
            }
            return rez;
        }
        //recursive
        //from left top to right top
        for(int j = layer; j < layer + colLen; j++){
            rez.add(matrix[layer][j]);
        }
        //from right top to right bottom
        for(int i = layer + 1; i < layer + rowLen; i++){
            rez.add(matrix[i][layer + colLen - 1]);
        }
        //from right bottom to left bottom
        for(int j = layer + colLen - 2; j >= layer; j--){ //-2 && >=  layer!!
            rez.add(matrix[layer + rowLen - 1][j]);
        }
        //from left bottom to left top
        for(int i = layer + rowLen - 2; i > layer; i--){
            rez.add(matrix[i][layer]);
        }
        ArrayList<Integer> insideLayers = printByLayer(matrix, rowLen - 2, colLen - 2, layer + 1);
        rez.addAll(insideLayers);
        return rez;
    }
    public static void main(String[] args) {
    	SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10}};
		ArrayList<Integer> rez = sm.spiralOrder(matrix);
		System.out.println(rez.size());
	}
}
