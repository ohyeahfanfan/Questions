package Recursive;

import java.util.ArrayList;

import junit.framework.TestCase;


public class SubSetIITest extends TestCase {
	public void testSubSet() {
		 ArrayList<ArrayList<Integer>> sets;
		 int[] S;
		 //Test Case 1
		 S = new int[2];
		 S[0] = 2;
		 S[1] = 2;
		 sets = SubSetII.subsetsWithDup(S);
	}

}
