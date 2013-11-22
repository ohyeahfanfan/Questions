package Recursive;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MagicIndexTest {
	@BeforeClass
	  public static void testSetup() {
	  }

	  @AfterClass
	  public static void testCleanup() {
	    // Teardown for data used by the unit tests
	  }

	 
	  @Test
	  public void testMagicIndex() {
		int[] arr = {0,1};
	    MagicIndex tester = new MagicIndex();
	    ArrayList<Integer> indice = new ArrayList<Integer>();
	    tester.getMagicIndexNoDup(arr, 0, arr.length-1, indice);
	    assertEquals("return should be arraylist 2", 2, indice.size());
	  }
	 


}
