
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.javafx.geom.Area;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

    /*
     * minDistance: Given a Graph, this method returns the shortest distance (in
     * terms of number of edges) from the node labeled src to the node labeled dest.
     * The method should return -1 for any invalid inputs, including: null values
     * for the Graph, src, or dest; there is no node labeled src or dest in the
     * graph; there is no path from src to dest. Keep in mind that this method does
     * not just return the distance of any path from src to dest, it must be the
     * shortest path.
     */

    public static int minDistance(Graph graph, String src, String dest) {

	if (graph == null || src == null || dest == null || !graph.containsElement(src)
		|| !graph.containsElement(dest)) {
	    return -1;
	} else {
	    int minDist = new BreadthFirstSearch(graph).findDistance(src, dest);
	    return minDist;
	}
    }

    /*
     * nodesWithinDistance: Given a Graph, this method returns a Set of the values
     * of all nodes within the specified distance (in terms of number of edges) of
     * the node labeled src, i.e. for which the minimum number of edges from src to
     * that node is less than or equal to the specified distance. The value of the
     * node itself should not be in the Set, even if there is an edge from the node
     * to itself. The method should return null for any invalid inputs, including:
     * null values for the Graph or src; there is no node labeled src in the graph;
     * distance less than 1. However, if distance is greater than or equal to 1 and
     * there are no nodes within that distance (meaning: src is the only node in the
     * graph), the method should return an empty Set.
     */
    public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

	if (graph == null || src == null || distance < 1 || !graph.containsElement(src)) {
	    return null;
	} else {
	    return new BreadthFirstSearch(graph).nodesWithinDist(src, distance);
	}

    }

    /*
     * isHamiltonianPath: Given a Graph, this method indicates whether the List of
     * node values represents a Hamiltonian Path. A Hamiltonian Path is a valid path
     * through the graph in which every node in the graph is visited exactly once,
     * except for the start and end nodes, which are the same, so that it is a
     * cycle. If the values in the input List represent a Hamiltonian Path, the
     * method should return true, but the method should return false otherwise, e.g.
     * if the path is not a cycle, if some nodes are not visited, if some nodes are
     * visited more than once, if some values do not have corresponding nodes in the
     * graph, if the input is not a valid path (i.e., there is a sequence of nodes
     * in the List that are not connected by an edge), etc. The method should also
     * return false if the input Graph or List is null.
     */

    public static boolean isHamiltonianPath(Graph g, List<String> values) {

	if (g == null || values == null || values.isEmpty())
	    return false;

	String src = values.get(0);
	Set<String> marked = new HashSet<>();
	marked.add(src);
	
	  if (!src.equals(values.get(values.size() - 1))) // check start and end node
	  return false;
	 

	for (int i = 1; i < values.size(); i++) {
	    // Are there any cycle condition not respected?
	    if ((marked.contains(values.get(i)) && i != (values.size() - 1)) // already visited except for the last node 
		    || !g.containsElement(values.get(i)) //contain the elements?
		    || !g.getNodeNeighbors(g.getNode(values.get(i - 1))).contains(g.getNode(values.get(i)))
	    // nodes not connected
	    ) {
		return false;
	    } else {
		marked.add(values.get(i));
	    }
	    

	} // End of ForLoop

	// Have they the same size?
	return g.getNumNodes() == marked.size();
    }

}
