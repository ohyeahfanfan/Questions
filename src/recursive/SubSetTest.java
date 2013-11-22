package Recursive;

import java.util.ArrayList;

import junit.framework.TestCase;


public class SubSetTest extends TestCase {
	public void testSubSet() {
		 ArrayList<ArrayList<Integer>> sets;
		 int[] S;
		 //Test Case 1
		 sets = SubSet.subsets(null);
		 assertTrue("size should be 0",0 == sets.size());
		 //Test Case 2
		 S = new int[0];
		 sets = SubSet.subsets(S);
		 assertTrue("size should be 1",1 == sets.size());
		 //Test Case 3
		 S = new int[1];
		 S[0] = 1;
		 sets = SubSet.subsets(S);
		 assertTrue("size should be 2 instead of "+ sets.size() ,2 == sets.size());
		 //Test Case 4
		 S = new int[2];
		 S[0] = 1;
		 S[1] = 2;
		 sets = SubSet.subsets(S);
		 assertTrue("size should be 4",4 == sets.size());
	}

}
