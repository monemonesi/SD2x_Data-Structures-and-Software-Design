import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	/*
	 * read the data file containing information about the books,
	 * create Book objects for each, and then return the Book objects.
	 */
	public List<Book> getAllBooks() {
	    List<Book> books = new ArrayList<>();
	    List<String> lines  = null;
	    

	    
	    try {
		lines = Files.readAllLines(Paths.get(fileName));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    
	    //Create a new object Book foreach Line
	    for (String line : lines) {
		String [] token = line.split("\t");
		books.add(new Book(token[0], token[1], Integer.parseInt(token[2])));
	    }
	    
	    return books;
	}

}
