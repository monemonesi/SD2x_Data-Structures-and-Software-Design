package HW2;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		if(tags.isEmpty()) return null;
		
		Stack<HtmlTag> tagsInStack = new Stack<HtmlTag>();
		
		for (HtmlTag htmlTag : tags) {
		    if(htmlTag.isOpenTag()) tagsInStack.push(htmlTag);
		    else if (! htmlTag.isSelfClosing()) {
			if(tagsInStack.isEmpty())
			    return null;
			else if(htmlTag.matches(tagsInStack.peek())) 
			    tagsInStack.pop();
			 else 
			    return tagsInStack;
			
		    }
		}
		
		return tagsInStack;
	}
	

}

