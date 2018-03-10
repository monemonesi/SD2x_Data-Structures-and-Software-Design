
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.sun.javafx.binding.StringFormatter;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
    protected Set<Node> marked;
    protected Graph graph;

    public BreadthFirstSearch(Graph graphToSearch) {
	marked = new HashSet<Node>();
	graph = graphToSearch;
    }

    /**
     * This method was discussed in the lesson
     */
    public boolean bfs(Node start, String elementToFind) {
	if (!graph.containsNode(start)) {
	    return false;
	}
	if (start.getElement().equals(elementToFind)) {
	    return true;
	}
	Queue<Node> toExplore = new LinkedList<Node>();
	marked.add(start);
	toExplore.add(start);
	while (!toExplore.isEmpty()) {
	    Node current = toExplore.remove();
	    for (Node neighbor : graph.getNodeNeighbors(current)) {
		if (!marked.contains(neighbor)) {
		    if (neighbor.getElement().equals(elementToFind)) {
			return true;
		    }
		    marked.add(neighbor);
		    toExplore.add(neighbor);
		}
	    }
	}
	return false;
    }

    // Helper Method
    public int findDistance(String start, String elementToFind) {

	Node startNode = graph.getNode(start);
	if (!graph.containsNode(startNode))
	    return -1;
	if (startNode.getElement().equals(elementToFind))
	    return 0;
	
	Queue<Node> toExplore = new LinkedList<Node>(); //my queue with all the nodes to explore
	Map<Node, Integer> distances = new HashMap<Node, Integer>();
	
	marked.add(startNode);
	toExplore.add(startNode);
	distances.put(startNode, 0);
	
	while(!toExplore.isEmpty()) {
	    //TODO: implement this method and research way for find the minimumm distance.
	    
	}

	return -1;
    }

}
