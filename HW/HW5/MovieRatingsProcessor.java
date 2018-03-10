package HW5;

/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsProcessor {

    /*
     * return a List of movie titles in alphabetical order
     */

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {

	ArrayList<String> alphabeticalMovieList = new ArrayList<>();

	if (movieRatings != null && !movieRatings.isEmpty()) {
	    alphabeticalMovieList.addAll(movieRatings.keySet());
	}

	return alphabeticalMovieList;
    }

    /*
     * given an input int rating, return a List of movie titles in alphabetical
     * order, where all movies in the List do not have any ratings less than or
     * equal to rating (hint: the PriorityQueue is a min-heap, meaning that the
     * smallest rating is at the front of the queue!)
     */
    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings,
	    int rating) {

	ArrayList<String> alphabeticalMoviesAboveRating = new ArrayList<String>();
	if (movieRatings != null && !movieRatings.isEmpty() && rating >= 0) {
	    for (String movietitle : movieRatings.keySet()) {
		if (movieRatings.get(movietitle).peek() > rating)
		    alphabeticalMoviesAboveRating.add(movietitle);
	    }
	}

	return alphabeticalMoviesAboveRating;
    }

    /*
     * given an input int rating, modify the TreeMap object that was passed as an
     * argument so that you remove all ratings in the PriorityQueue that are below
     * (but not equal to) rating for every movie in the Map. If all ratings are
     * removed from a movie’s PriorityQueue, then remove the mapping from the
     * TreeMap. Additionally, this method should return a new TreeMap that maps a
     * movie title to the number of ratings that were removed from its corresponding
     * PriorityQueue; the TreeMap that is returned should only contain movies that
     * had ratings removed from its PriorityQueue.
     */
    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings,
	    int rating) {

	TreeMap<String, Integer> updatedMovieRating = new TreeMap<>();

	if (movieRatings != null && !movieRatings.isEmpty() && rating >= 0) {

	    // TODO: complete this method
	    Iterator<Map.Entry<String, PriorityQueue<Integer>>> entryMovies = movieRatings.entrySet().iterator();
	    while (entryMovies.hasNext()) {
		// Check each movie
		Map.Entry<String, PriorityQueue<Integer>> entryMovie = entryMovies.next();
		Iterator<Integer> movieRating = entryMovie.getValue().iterator();
		while (movieRating.hasNext()) {
		    if (movieRating.next() < rating) {
			movieRating.remove();
			// if my movie is already in the output map
			if (!updatedMovieRating.containsKey(entryMovie.getKey())) {
			    updatedMovieRating.put(entryMovie.getKey(), 1);
			} else {
			    updatedMovieRating.put(entryMovie.getKey(),
				    updatedMovieRating.get(entryMovie.getKey()) + 1);
			}
		    }
		} // end movieRating while loop
		 // Remove all the elements
		if (entryMovie.getValue().isEmpty()) {
		    entryMovies.remove();
		}
	    } // end entryMovies While loop

	}

	return updatedMovieRating;
    }
}
