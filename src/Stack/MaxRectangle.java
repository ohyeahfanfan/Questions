package Stack;

import java.util.Stack;

public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int maxArea = 0;
        int[] row = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                	row[j] += 1; 
                }else{
                	row[j] = 0;	
                }
            }
            int rowMax = largestRectangleArea(row);
            maxArea = Math.max(rowMax, maxArea);
        }
        return maxArea;
    }
    class Rectangle{
        int start;
        int height;
        Rectangle(int start, int height){
            this.start = start;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] height) {
       if(height == null || height.length == 0) return 0;
       Stack<Rectangle> stack = new Stack<Rectangle>();
       height = putZeroIntoHeight(height);
       int maxArea = 0;
       stack.push(new Rectangle(0, height[0]));
        for(int i = 1; i < height.length; i++){
            Rectangle top = stack.peek();
            if(top.height < height[i]){
            	//bigger element to stack
                stack.push(new Rectangle(i, height[i]));
            }else{
            	Rectangle curRect = new Rectangle(i, height[i]);
                while(!stack.empty()){
                	top = stack.peek();
                	if(top.height >= height[i]){
                		int curArea = (i - top.start) * top.height;
                		maxArea  = Math.max(curArea, maxArea);
                		curRect.start = top.start; 
                		stack.pop();
                	}else{
                    	break;
                    }  
                }
                stack.push(curRect);
            }
        } 
        return maxArea;
    }
    public int[] putZeroIntoHeight(int[] height){
        int[] rez = new int[height.length + 1];
        for(int i = 0; i < height.length; i++){
            rez[i] = height[i];
        }
        rez[height.length] = 0;
        return rez;
    }
    public static void main(String[] args) {
    	MaxRectangle obj = new MaxRectangle();
    	char[][] matrix = {{'0','1'},{'0','1'}};
    	System.out.println(obj.maximalRectangle(matrix));
    }
}
