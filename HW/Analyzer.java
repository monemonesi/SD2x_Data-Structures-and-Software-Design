import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	 * 
	 * This method should find all of the individual tokens/words in the text field of each Sentence
	 * in the List and create Word objects for each distinct word. 
	 * The Word objects should keep track of the number of occurrences of that word in all Sentences,
	 * and the total cumulative score of all Sentences in which it appears. 
	 * Return a Set of those Word objects.
	 * 
	 * If the input List of Sentences is null or is empty, the allWords method should return an empty Set.
	 * If a Sentence object in the input List is null, this method should ignore it
	 * and process the non-null Sentences.
	 * Ignores any token that does not start with a letter and convert all strings to lowercase. 
	 */
	 
    public static Set<Word> allWords(List<Sentence> sentences) {

	ArrayList<Word> wordList = new ArrayList<Word>();

	try {
	    for (Sentence sentence : sentences) {
		if (sentence != null) {
		    // split the sentence text (it must be case insensitive)
		    String[] tokens = sentence.getText().toLowerCase().split(" ");

		    for (String token : tokens) {
			Word word = new Word(token);
			// each word need to start with a letter
			if (Character.isLetter(token.charAt(0))) {
			    word.increaseTotal(sentence.getScore());
			    if (!wordList.contains(word)) {
				wordList.add(word);
			    } else {
				int index = wordList.indexOf(word);
				wordList.get(index).increaseTotal(sentence.getScore());
			    }
			}

		    }
		}

	    }

	} catch (Exception e) {
	    return new HashSet<Word>(wordList); 
	}
	/*
	 * I am creating the hashset at the end because it is easier build the ArrayList and get value at
	 * defined index
	 */
	return new HashSet<Word>(wordList);
    }
	
	/*
	 * Implement this method in Part 3
	 * 
	 * 
	 * This method should iterate over each Word in the input Set, 
	 * use the Word’s calculateScore method to get the average sentiment score for that Word, 
	 * and then place the text of the Word (as key) and calculated score (as value) in a Map.
	 *
	 *If the input Set of Words is null or is empty, the calculateScores method should return
	 * an empty Map.
	 *
	 *If a Word object in the input Set is null, 
	 *this method should ignore it and process the non-null Words.
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		Map<String, Double> mapScore = new HashMap<String, Double>();
		
		if(words!=null && !words.isEmpty()) {
		    for (Word word : words) {
			if(word!=null) mapScore.put(word.getText(), word.calculateScore());
		    }
		}
		
		return mapScore;
	}
	
	/*
	 * Implement this method in Part 4
	 * This method should use the Map to calculate and 
	 * return the average score of all the words in the input sentence.
	 * 
	 * If a word in the sentence does not start with a letter, then you can ignore it, 
	 * but if it starts with a letter and is not present in the Map, assign it a score of 0.
	 * 
	 * If the input Map is null or empty, or if the input sentence is null or empty or
	 *  does not contain any valid words, this method should return 0.
	 */
	
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
	
	double sentenceScore = 0;
	int count = 0;
	
	if (wordScores != null && !wordScores.isEmpty() && sentence != null && !sentence.isEmpty()) {
	    // split the sentence text (it must be case insensitive)
	    String[] tokens = sentence.toLowerCase().split(" ");
	    for (String token : tokens) {

		// each string need to start with a letter
		if (Character.isLetter(token.charAt(0))) {
		    count ++;
		    if(wordScores.containsKey(token)) {
			sentenceScore += wordScores.get(token);
		    }
		}

	    }
	    if (count!=0) return sentenceScore/count;
	} else return 0;
	return 0;

	//return sentenceScore; 

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
