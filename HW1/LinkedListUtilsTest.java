import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class LinkedListUtilsTest {



    @Test
    public void testInsertSorted() {
	//Test adding one element at the beginning
	LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(2,5,7,9));
	LinkedListUtils.insertSorted(list, 1);
	LinkedList<Integer> myList = new LinkedList<Integer>(Arrays.asList(1,2,5,7,9));
	
	assertEquals(myList, list);
    }
    @Test
    public void testInsertSorted2() {
	//Test adding one element at the end
	LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(2,5,7,9));
	LinkedListUtils.insertSorted(list, 10);
	LinkedList<Integer> myList = new LinkedList<Integer>(Arrays.asList(2,5,7,9,10));
	
	assertEquals(myList, list);
    }
    @Test
    public void testInsertSorted3() {
	//Test adding one element in the middle
	LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(2,5,7,9));
	LinkedListUtils.insertSorted(list, 4);
	LinkedList<Integer> myList = new LinkedList<Integer>(Arrays.asList(2,4,5,7,9));
	assertEquals(myList, list);
    }
    @Test
    public void testInsertSorted4() {
	//Test adding to empty list
	LinkedList<Integer> list = new LinkedList<Integer>();
	LinkedListUtils.insertSorted(list, 6);
	LinkedList<Integer> myList = new LinkedList<Integer>(Arrays.asList(6));
	assertEquals(myList, list);
    }
    @Test
    public void testInsertSorted5() {
	//Test adding to empty list
	LinkedList<Integer> list = null;
	LinkedListUtils.insertSorted(list, 6);
	
	assertEquals(null, list);
    }
    

    @Test
    public void testRemoveMaximumValues() {
	LinkedList<String> list = new LinkedList<String>(Arrays.asList("1","2","3","3","4","4","5"));
	LinkedListUtils.removeMaximumValues(list, 2);
	LinkedList<String> testList = new LinkedList<String>(Arrays.asList("1","2","3","3"));
	
	assertEquals(testList, list);
    }
    @Test
    public void testRemoveMaximumValues2() {
	LinkedList<String> list = new LinkedList<String>(Arrays.asList("1","2","3","3","4","4","5"));
	LinkedListUtils.removeMaximumValues(list, 1);
	LinkedList<String> testList = new LinkedList<String>(Arrays.asList("1","2","3","3","4","4"));
	
	assertEquals(testList, list);
    }
    @Test
    public void testRemoveMaximumValues3() {
	// remove with negative N value (should return the original list)
	LinkedList<String> list = new LinkedList<String>(Arrays.asList("1","2","3","3","4","4","5"));
	LinkedListUtils.removeMaximumValues(list, -1);
	LinkedList<String> testList = new LinkedList<String>(Arrays.asList("1","2","3","3","4","4","5"));
	
	assertEquals(testList, list);
    }
    @Test
    public void testRemoveMaximumValues4() {
	// remove with N values from null list (should return the original list)
	LinkedList<String> list = null;
	LinkedListUtils.removeMaximumValues(list, 1);
	
	assertEquals(null, list);
    }
    
    @Test
    public void testRemoveMaximumValues5() {
	// remove with N value bigger the list.size() (should return an empty List)
	LinkedList<String> list = new LinkedList<String>(Arrays.asList("1","2","3","3","4","4","5"));
	LinkedListUtils.removeMaximumValues(list, 100);
	LinkedList<String> testList = new LinkedList<String>(Arrays.asList());
	
	assertEquals(testList, list);
    }
    
    

    @Test
    public void testContainsSubsequence() {
	fail("Not yet implemented");
    }

}
