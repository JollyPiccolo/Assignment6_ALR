/**
 * 
 */
import java.util.Stack;
/**
 * @author AdelineLR
 *
 */
public class DepthFirstSearch {       
    /**
     * Variable Instantiation   
     */
	Stack<Node> visited = new Stack<Node>();
	Stack<Node> toVisit = new Stack<Node>();
	int maxHeight = 0;
	int count = 1;
      
	/**
	 * Constructor
	 */
	public DepthFirstSearch(){               
                   System.out.println("\nCall DFS with root node to do a Depth First Search.");
       }
    /**
     * DFS
     * Traverses the nodes of the tree, and prints out each node's data once visited
     * @param node
     */
    public void DFS(Node node){
    
    	//Visitation - If unvisited, node is printed along with the total search count
    	if(!visited.contains(node)) {
    		System.out.println("\nNode: " + node.getData()); 
    		System.out.println("Number of Nodes Searched: " + count);
    		
    		//tracks the max height of the tree
    		if(node.getHeight() > maxHeight) {
    			maxHeight = node.getHeight();
    		}
    		
    		//adds the visited node to the visited stack, preventing it from being printed again; search count is updated
    		visited.push(node);
    		count++;
    	}
    	
    	/*
    	 * Child checker - checks the node to see if it contains any unvisited children;
    	 * If so, the node is added to "toVisit" stack, and the leftmost node is visited 
    	 */
    	
    	if(this.pendingChildren(node) == true && !node.isLeaf()) {
    		toVisit.push(node);
    		this.DFS(this.lmostChild(node));
    
    	}

    	//If no unvisited children are found, and the toVisit stack has nodes in it, the stack is popped and the popped node is visited
    	if(!toVisit.isEmpty()) {
    		this.DFS(toVisit.pop());
    	}

    }
 
    /**
     * printData
     * prints the maxHeight and total number of nodes traversed, before clearing these values for the next DFS
     */
    public void printData() {
    	//When the tree has been completely searched, the total number of nodes visited and the tree's height is printed
    	
		System.out.println("\nTotal Nodes Visited: " + (count - 1));
    	System.out.println("Tree Height: " + maxHeight);
    	
    	//count and maxHeight are then cleared for the next run
    	count = 0;
    	maxHeight = 0;
    }
    
    /**
     * pendingChildren
     * returns a boolean variable, indicating whether the current node has children who haven't been visited within the search
     * @param Node root
     * @return true, if root contains an unvisited child; false, if both children have been visited
     */
    private boolean pendingChildren(Node root) {
    	boolean result = true;
    	
    	//checks the visited stack for the children of the node
    	if(visited.contains(root.getlChild()) && visited.contains(root.getrChild())) {
    		result = false;
    	}
    	
    	return result;
    }
    
    /**
     * lmostChild
     * seeks out the leftmost unvisited child of the root, and returns them 
     * @param Node root 
     * @return Node result - left child, if it's present and unvisited; right, if the left child is not an option
     */
    private Node lmostChild(Node root) {
    	Node result = null;
    	
    	/*
    	 * checks the visited stack for the root's left child; 
    	 * if its not there, the left child is made the result
    	 */
    	if(!visited.contains(root.getlChild())) {
    		result = root.getlChild();
    	}
    	/*
    	 * checks the visited stack for the root's right child, if left child is in the stack; 
    	 *if its not there, the right child is made the result
    	 */
    	else if(!visited.contains(root.getrChild())) {
    		result = root.getrChild();
    	}
    	
    	return result;
    }

}