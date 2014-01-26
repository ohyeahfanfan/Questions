package Array;



public class RotateMatrix {
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        int maxLayer = n / 2;
        for(int layer = 0; layer < maxLayer; layer ++){
            for(int i = layer; i < n - 1 - layer; i++){
                //counterclockwise　
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[n - 1 - i][layer];
                matrix[n - 1 - i][layer]= matrix[n-1-layer][n-1-i];
                matrix[n-1-layer][n - 1 - i] = matrix[i][n-1-layer];
                matrix[i][n - 1 - layer] = temp;
            }
        }
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
		RotateMatrix obj = new RotateMatrix();
		obj.rotate(matrix);
		System.out.println(matrix);
	}
}
