package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectedSets {
	public int[][] readInput() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] rez = null;
		String line = br.readLine();
        int cases = 0;
        int size = 0;
        int m = 0;
        int n = 0;
        int lineNum = 0;
        while (line != null) {
        	if(lineNum == 0){
        		cases = Integer.parseInt(line); 
        	}else if(lineNum == 1){
        		n = Integer.parseInt(line);
        		rez = new int[m][n];
        	}else{
        		String[] nums = line.split(" ");
        		for(int i = 0; i < nums.length; i++){
        			rez[lineNum-2][i] = Integer.parseInt(nums[i]);
        		}
        	}
        	lineNum++;
            line = br.readLine();
        }
	    return rez;
	}
	public int countConnectedSet(int[][] matrix){
		int total = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0;  j < matrix.length; j++){
				if(matrix[i][j] == 1){
					total++;
					dfs(matrix, i, j);
				}
			}
		}
		return total;
	}
	public void dfs(int[][] matrix, int i, int j){
		if(i >= matrix.length || i < 0) return;
		if(j >= matrix[0].length || j < 0) return;
		if(matrix[i][j] == 0) return;
		matrix[i][j] = 0;
		dfs(matrix, i - 1, j);
		dfs(matrix, i + 1, j);
		dfs(matrix, i, j - 1);
		dfs(matrix, i, j + 1);
		dfs(matrix, i - 1, j - 1);
		dfs(matrix, i - 1, j + 1);
		dfs(matrix, i + 1, j - 1);
		dfs(matrix, i + 1, j + 1);
	}
	public static void main(String args[] ) throws Exception {
		ConnectedSets s = new ConnectedSets();
		int[][] matrix = s.readInput();
		System.out.println(s.countConnectedSet(matrix));
	}
	
}
