package SpreadSheetCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Spreadsheet {
	public static int col;
	public static int row;
	public static Hashtable<String, Expression> dict = null;
	public static ArrayList<String> load() {
		ArrayList<String> expressions = new ArrayList<String>();
		try {
			// Open the file that is the first
			// command line parameter
			//FileInputStream fstream = new FileInputStream("C:/depot/gwt/UrbanIrrigationTool/src/SpreadSheetCalculator/spreadsheet.txt");
			// Get the object of DataInputStream
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				expressions.add(strLine);
			}
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return expressions;
	}
	public static ArrayList<Expression> convertToExpression(ArrayList<String> expStrList) throws Exception{
		ArrayList<Expression> expList = new ArrayList<Expression>();
		//setup config
		if(expStrList.size() > 0){
			//Expression conf = expStrList.get(0);
			Expression conf = new Expression();
			conf.setTokenList(expStrList.get(0));
			ArrayList<Token> tokenList = conf.getTokenList();
			col = (int)tokenList.get(0).getValue();
			row = (int)tokenList.get(1).getValue();
		}
		// except the first expression
		for(int i = 1; i < expStrList.size(); i++){
			Expression expr = new Expression(expStrList.get(i), i-1);
			expList.add(expr);
		}
		
		return expList;
	}
	
	/*
	 *  @param ArrayList<Expression> expList
	 *  @return topological sorted ArrayList<Express>
	 *  1. traverse the given expression list(A->B A depends on B), put every expression which contains CellNumToken to a Hashtable<Pos, Expression> Pos:A2
	 *  2. start from arbitrary node topological sort return topological sorted Arraylist
	 */
	public static ArrayList<Expression> topologicalSort(ArrayList<Expression> expList) throws Exception{
		ArrayList<Expression> sortedList = new ArrayList<Expression>();
		//initialize the dictionary
		setDict(expList);
		for(Expression exp: expList){
			topologicalSortVisit(exp, sortedList);
		}
		//calculate expression following the 
		for(Expression exp : sortedList){
			exp.calSetValue();
		}
		return sortedList;
	}
	
	public static void topologicalSortVisit(Expression exp, ArrayList<Expression> sortedList) throws Exception{
		if(exp == null) return;
		if(exp.status == Expression.VisitStatus.Unvisited){
			exp.status = Expression.VisitStatus.Visiting;
			ArrayList<Token> connectedToken = exp.getConnectedCellNumToken();
			for(Token cellToken: connectedToken){
				Expression connectedExp = dict.get(cellToken.cellNum);
				topologicalSortVisit(connectedExp, sortedList);
			}
			exp.status = Expression.VisitStatus.Visited;
			sortedList.add(exp);
		}else if(exp.status == Expression.VisitStatus.Visiting){
			throw new Exception("not a DAG");
		} 
	}
	
	
	//traverse the given expression list(A->B A depends on B), put every expression to a Hashtable<Pos, Expression> Pos:A2
	public static void setDict(ArrayList<Expression> expList){
		Hashtable<String, Expression> table = new Hashtable<String, Expression>();
		for(Expression exp: expList){
			String key = exp.getCellNum();
			table.put(key, exp);
		}
		dict = table;
	}
	public static void printOut(ArrayList<String> expStrList, ArrayList<Expression> expList){
		if(expStrList == null || expStrList.size() == 0) return;
		//print n m
		System.out.println(expStrList.get(0));
		for(int i = 0; i < expList.size(); i++){
			Expression exp = expList.get(i);
			//print result
			System.out.println(exp.getPrintValue());
		}
	}
	public static void main(String args[]) throws Exception{
		ArrayList<String> expStrList = Spreadsheet.load();
		ArrayList<Expression> expList = convertToExpression(expStrList);
		topologicalSort(expList);
		printOut(expStrList, expList);
	}
}
