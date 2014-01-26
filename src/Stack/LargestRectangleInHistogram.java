package Stack;
import java.util.Stack;
/*
 * Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram. 
 * 
 * The problem can be solved by 
 * 1. calculate the largest rectangle for each height
 * 2. calculate the max 
 * 
 * In step 1, how can we calculate the width of the rectangle
 * 1. start index (should be extended to the last left elements shorter than current height)
 * 	  eg. {4,2,0,3,2,4,3,4} start index of the first 4 should be index 0 
 * 2. end index (should be extended to the first right elements shorter than current height)
 *    eg. {4,2,0,3,2,4,3,4} start index of the first 4 should be index 1
 *    
 * the import moment is 
 * when we meet the height which is shorter than the top element of the stack
 * keep popping until the height of the top of stack is shorter than the current height 
 * 1. right extend the end index of pop element, calculate the area
 * 2. left extend the start index of current element
 * 
 */
public class LargestRectangleInHistogram {
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
                		// 1. right extend the end index of pop element, calculate the area
                		int curArea = (i - top.start) * top.height;
                		maxArea  = Math.max(curArea, maxArea);
                		// 2. left extend the start index of current element
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
    	LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
    	int[] height = {4,2,0,3,2,4,3,4};
    	System.out.println(obj.largestRectangleArea(height));
    }
}
