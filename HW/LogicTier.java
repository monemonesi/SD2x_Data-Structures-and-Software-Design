import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	/*
	 * for a given name, search through all of the books and return 
	 * the titles of those books whose author name includes the input name.
	 */
	public Set<String> findBookTitlesByAuthor() {
	    Set<String> bookTitleByAuthor = new HashSet<String>();
	    
	    return bookTitleByAuthor;
	}
	
	
	/*
	 * for a given year, search through all of the books and 
	 * return the number of books published in that year
	 */
	public int findNumberOfBooksInYear() {
	    int numberOfBookInYear = 0;
	    
	    return numberOfBookInYear; 
	}

}