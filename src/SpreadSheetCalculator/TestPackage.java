package SpreadSheetCalculator;

import java.util.ArrayList;

import junit.framework.TestCase;
public class TestPackage extends TestCase{
	//private ArrayList<Token> list;
	private Expression exp;
	public void setUp() throws Exception{
		//list = Expression.generateTokenList("39 B1 B2 * +");
		exp = new Expression();
		exp.setTokenList("39 B1 B2 * +");
	}
	public void tearDown(){
		exp = null;
	}
	public void testCellExpression(){
		
	}
}
