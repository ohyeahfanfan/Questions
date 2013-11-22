package Recursive;

import java.util.ArrayList;

public class GenerateParenthesis {
	/*** 7/21/2013
	 * http://leetcode.com/onlinejudge#question_22
	 * CRC 9. 
	  *@Problem Generate Parentheses
		Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
		For example, given n = 3, a solution set is:
		"((()))", "(()())", "(())()", "()(())", "()()()"
	  * 
	  * */
	//�Ż���һ�´��룬û����д����3��д�����Զ࿼�ǵ�,
	//1. ��StringBuffer������create new string
	//2. left�����ܱ�right��
	//3. walk through the code, ����base cases��һ���Ƿ�����һ����left��right����
	 public ArrayList<String> generateParenthesis(int n) {
	        ArrayList<String> result = new ArrayList<String>();
	        StringBuffer sb = new StringBuffer();
	        if(n <= 0) return result;
	        helper(n, 0, 0, result, sb);
	        return result;
	    }
	    public void helper(int n, int left, int right, ArrayList<String> result, StringBuffer sb){
	        if(left==n && right==n){
	            result.add(sb.toString());
	        }
	        //add left parenthesis, any time we have left parenthesis, we can add them
	        if(left < n){
	            helper(n, left+1, right, result, sb.append("("));
	            int last = sb.length()-1;
	            sb.delete(last,last+1);//!!!!!how to delete char from stringbuffer
	        }
	        //add right parenthesis
	        if(right < n && left > right){
	            helper(n, left, right+1, result, sb.append(")"));
	            int last = sb.length()-1;
	            sb.delete(last,last+1);
	        }
	        //otherwise, do nothing
	    }
}
