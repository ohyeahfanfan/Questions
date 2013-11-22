package Math;

import java.util.ArrayList;

import Tree.PathSumII;
import Tree.TreeNode;

public class PascalTrangle {
	  public static ArrayList<Integer> getRow(int rowIndex) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ArrayList<Integer> row = new ArrayList<Integer>();
	        if(rowIndex == 0) return row;
	        row.add(1);
	        for(int i = 1; i < rowIndex; i++){
	            row.set(0, 1);
	            int size = row.size();
	            for(int j = 1; j < size; j++){
	                int val = row.get(j-1) + row.get(j);
	                row.set(j, val);
	            }
	            row.add(size, 1);
	        }
	        return row;
	    }
	  public static void main(String[] args) {
		  PascalTrangle.getRow(2);
		 }
}
