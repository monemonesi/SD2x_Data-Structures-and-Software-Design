
/*
 * SD2x Homework #9
 * This class represents a newspaper article.
 * Refactor the code according to the suggestions in the assignment description.
 */
import java.util.*;

/*
 * Activity Part 1: Applying Extract Class
 * Use the Extract Class refactoring pattern to create a new class called PublishingLocation
 * and implement that class so that it contains the city, state, and postCode fields and any
 * other necessary methods. Then modify NewspaperArticle accordingly by removing fields and methods as needed,
 * and then setting up the appropriate relationship between NewspaperArticle
 * and this newly created PublishingLocation class.
 */

/*
 * Activity Part 2: Fixing a Large Class
 * Refactor NewspaperArticle and apply either the Extract Class or Extract Superclass pattern
 * (you need to decide which!) to create a new class called Document that contains the fields and methods
 * that would be common to all types of documents. In particular, move the title, author, date,
 * and publishing location fields and related methods to the new Document class,
 * but leave the rest in NewspaperArticle.
 * 
 */

public class NewspaperArticle extends Document {
    private int startPage;
    private int endPage;
    private Set<String> editors;
    private String newspaper;

    public NewspaperArticle(String title, String author, int startPage, int endPage, Set<String> editors,
	    String newspaper, Date date, String city, String state, String postCode) {
	super(title, author, date, city, state, postCode);
	this.startPage = startPage;
	this.endPage = endPage;
	this.editors = editors;
	this.newspaper = newspaper;
    }

    public int getStartPage() {
	return startPage;
    }

    public int getEndPage() {
	return endPage;
    }

    public Set<String> getEditors() {
	return editors;
    }

    public String getNewspaper() {
	return newspaper;
    }

    public int numPages() {
	return endPage - startPage + 1;
    }

    public boolean sameNewspaper(NewspaperArticle article) {
	return this.newspaper.equals(article.newspaper);
    }

    public int numEditors() {
	return editors.size();
    }

    public Set<String> commonEditors(NewspaperArticle article) {
	Set<String> sameEditors = new HashSet<String>();
	for (String ed : article.editors) {
	    if (this.editors.contains(ed)) {
		sameEditors.add(ed);
	    }
	}
	return sameEditors;
    }

}
