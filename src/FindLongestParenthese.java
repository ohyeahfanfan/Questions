import java.util.Stack;

import DP.GasStation;



public class FindLongestParenthese {
/* 
 * Longest Valid Parentheses 
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", 
 * which has length = 4.
 * 
 * idea:
 * at each position, we may have "(" or ")"
 * if "(",
 * 1. push to stack
 * if ")"
 * we have three cases,
 * 1. extra "("  eg. (()  index(")") - index(previous"(")
 * 2. extra ")"  eg. )    change start index to )
 * 3. match "()" eg. ()() (()()) index(")") - index("start")
 * 
 * 
 *
 */
    class Element{
    	char val;
    	int index;
    	Element(char v, int i){
    		val = v;
    		index = i;
    	}
    }
	public int longestValidParentheses(String s) {
		int longest = 0;
		Stack<Element> stack = new Stack<Element>();
		int last = -1; //one pos before the start position of parentheses
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '('){
				stack.push(new Element(c, i));
				// c == ')'
			}else{ 
				// extra ")"
				if(stack.empty()){
					//update last index, all the parentheses calculation start after last
					last = i; 
				}else{
					//pop one "("
					stack.pop();
					int curLen = 0;
					
					if(!stack.empty()){
						//extra (
						curLen = i - stack.peek().index;
					}else{
						//( and ) match
						curLen = i - last;
					}
					longest = (longest > curLen ? longest : curLen);
				}
			}
		}
		return longest;
    }
	public static void main(String[] args) {
		FindLongestParenthese obj = new FindLongestParenthese();
		System.out.println(obj.longestValidParentheses(""));
		System.out.println(obj.longestValidParentheses("("));
		System.out.println(obj.longestValidParentheses(")"));
		System.out.println(obj.longestValidParentheses("()"));
		System.out.println(obj.longestValidParentheses("(())"));
	}
}
