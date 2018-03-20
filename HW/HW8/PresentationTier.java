package HW8;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {

    private LogicTier logicTier; // link to the Logic Tier
    private Scanner sc = new Scanner(System.in);

    public PresentationTier(LogicTier logicTier) {
	this.logicTier = logicTier;
    }

    /*
     * This method asks the user which feature they would like to use and invokes
     * the appropriate methods in the appropriate classes. Once the output has been
     * displayed, the program should terminate. As above, you can handle error cases
     * in any way that you deem appropriate.
     */

    public void start() {

	System.out.println("Welcome on HW8");
	System.out.println("Avaiable features:");
	System.out.println("Press 1 for find the book titles by author");
	System.out.println("Press 2 for find the number of book published in a certain year");
	System.out.print("Which feature do you like to use?");

	String input = sc.nextLine();
	if (input.equals("1"))
	    showBookTitlesByAuthor();
	else if (input.equals("2"))
	    showNumberOfBooksInYear();
	else {
	    System.out.println("Input non recognized. Please digit 1 or 2");
	}

    }

    /*
     * using the command-line (i.e., reading from System.in), ask the user to enter
     * part or all of an author’s name, then display (using System.out) the titles
     * of those books whose author name includes the input name.
     */
    public void showBookTitlesByAuthor() {
	System.out.println("You have choose option 1");
	System.out.println("Choose your author:");
	String choosenAuthor = sc.nextLine();//.toLowerCase(); // shall I manage the lower case in LogicTier??
	Set<String> allbooksByAuthor = logicTier.findBookTitlesByAuthor(choosenAuthor);
	System.out.println("Here are the list of the books written by" + choosenAuthor + ":");
	for (String book : allbooksByAuthor) {
	    System.out.println(book);
	}
    }

    /*
     * using the command-line (i.e., reading from System.in), ask the user to enter
     * a year, then display (using System.out) the number of books published in that
     * year
     */
    public void showNumberOfBooksInYear() {
	System.out.println("You have choose option 2");
	System.out.println("Choose your year:");
	try {
	    int choosenYear = sc.nextInt();
	    int numOfBooks = logicTier.findNumberOfBooksInYear(choosenYear);
	    System.out.println("The number of Book published in "+choosenYear+" is "+numOfBooks);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
	
	

}
