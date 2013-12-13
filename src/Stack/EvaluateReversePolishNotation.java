package Stack;

import java.util.Stack;
/*
 * Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * learned:
 * 1.Every time when we see an operation sign we pop stack, then
 * only the numbers will be pushed into the stack. 
 * So the type of stack can be integer
 * Which avoid the conversion from int to string after the calculation (string to int)
 * Similar to the Add Binary (char to int)
 * 2. String to int: Integer.parseInt();
 * 
 * 
 * 
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        //Only the numbers will be pushed into the stack. 
		//The operation sign wouldn't be pushed into the stack.
		//So the type of stack can be integer
		Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            String cur = tokens[i];
            if(cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")){
            	int num1 = 0;
            	int num2 = 0;
                if(stack.size() >= 2){
                    num1 = stack.pop();
                    num2 = stack.pop();
                }else{
                    return -1;
                }
                int rez = op(num1, num2, cur);
                stack.push(rez);
            }else{
            	//how to convert a string to integer
                stack.push(Integer.parseInt(cur));
            }
        }
        return stack.size() == 1 ?stack.pop() : -1;
    }
	public int op(int num1, int num2, String token){
		int rez;
		if(token.equals("+")){
            rez = num1 + num2;
         }else if(token.equals("-")){
            rez = num2 - num1;
         }else if(token.equals("*")){
            rez = num1 * num2;
         }else{
             rez = num2 / num1;
         }
		return rez;
	}
	public static void main(String[] args) {
		EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
		String[] token = {"2", "1", "+", "3", "*"};
		System.out.println(test.evalRPN(token));
	 }
}
