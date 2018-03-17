/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	
	/*
	 * This method asks the user which feature they would like to use and invokes the appropriate methods
	 * in the appropriate classes. Once the output has been displayed, the program should terminate.
	 * As above, you can handle error cases in any way that you deem appropriate.
	 */
	
	public void start() {
		
		/* IMPLEMENT THIS METHOD */
	}
	
	
	/*
	 * using the command-line (i.e., reading from System.in), ask the user to enter part or
	 * all of an author’s name, then display (using System.out) 
	 * the titles of those books whose author name includes the input name.
	 */
	public void showBookTitlesByAuthor() {
	    
	}
	
	
	/*
	 * using the command-line (i.e., reading from System.in), ask the user to enter a year,
	 * then display (using System.out) the number of books published in that year
	 */
	public void showNumberOfBooksInYear() {
	    
	}
	

}
