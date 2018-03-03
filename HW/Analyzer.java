import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;



/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1:
	 * 
	 * Takes the name of the file to read and read it one line at a time, creating Sentence objects
	 *  and putting them into the List. 
	 * Returns a List containing Sentence objects.
	 */
	 
    public static List<Sentence> readFile(String filename) {

	ArrayList<Sentence> sentencesFromFile = new ArrayList<Sentence>();
	List<String> fileLines = new ArrayList<String>();

	/*
	 * if the file cannot be opened for reading or if the input filename is null,
	 * this method should return an empty List.
	 */

	try {
	    fileLines = Files.lines(Paths.get(filename)).collect(Collectors.toList());
	} catch (Exception e) {
	    return sentencesFromFile;
	    //return new ArrayList<Sentence>();
	}

	for (String fileLine : fileLines) {
	    int spaceIndex = fileLine.indexOf(" ");
	    try {
		int score = Integer.parseInt(fileLine.substring(0, spaceIndex));

		String text = fileLine.substring(spaceIndex + 1);
		if (!text.isEmpty() && -2 <= score && score <= 2) {
		    sentencesFromFile.add(new Sentence(score, text));
		}
	    } catch (Exception e) {
		continue;
	    }
	}

	return sentencesFromFile;
	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		
		return 0; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
