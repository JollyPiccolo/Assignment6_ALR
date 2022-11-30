/**
 * 
 */

/**
 * @author Nathan Johnson, Bellarmine University
 *
 */
public class Application {

	/**
	 * @param args Tree Height
	 */
	public static void main(String[] args)
	{
		//System.out.println("Creating a tree of height "+ args[0]+".");
		
		//Creates a tree with root
		Tree aTree=new Tree();
		
		Node root=aTree.generatePracticeTree(5);
		
		DepthFirstSearch aSearch=new DepthFirstSearch();
		aSearch.DFS(root);
		aSearch.printData();
	}

}