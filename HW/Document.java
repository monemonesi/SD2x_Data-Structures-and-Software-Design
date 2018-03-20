import java.util.*;

public abstract class Document {
    private String title;
    private String author;
    private Date date;
    private PublishingLocation location;

    public Document(String title, String author, Date date, String city, String state, String postCode) {
	this.location = new PublishingLocation(city, state, postCode);
	this.title = title;
	this.author = author;
	this.date = date;
    }

    public String getTitle() {
	return title;
    }

    public String getAuthor() {
	return author;
    }

    public Date getDate() {
	return date;
    }

    public String getCity() {
	return location.getCity();
    }

    public String getState() {
	return location.getState();
    }

    public String getPostCode() {
	return location.getPostCode();
    }
    
    //Abstraction:
    public boolean sameAuthor(Document doc) {
	return this.author.equals(doc.author);
    }

    public int compareDates(Document doc) {
	return this.date.compareTo(doc.date);
    }

    public int compareWithGeneralDate(Date date) {
	return this.date.compareTo(date);
    }

}
