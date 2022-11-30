
/**
 * @author Nathan Johnson, Bellarmine University
 *
 */
public class Node {
	private int data;
	private Node lChild;
	private Node rChild;
	private int height;
	
	public Node(int data)
	{
		lChild=null;
		rChild=null;
		this.data=data;
		height = 1;
	}
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data - the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	
	/**
	 * getHeight
	 * returns the height of the node
	 * @return int height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * setHeight
	 * sets the height of the node
	 * @param int h
	 */
	public void setHeight(int h) {
		 this.height = h;
	}
	
	/**
	 * @return the lChild
	 */
	public Node getlChild() {
		return lChild;
	}
	/**
	 * @param lChild the lChild to set
	 */
	public void setlChild(Node lChild) {
		this.lChild = lChild;
		lChild.setHeight(this.getHeight() + 1);
	}
	/**
	 * @return the rChild
	 */
	public Node getrChild() {
		return rChild;
	}
	/**
	 * @param rChild the rChild to set
	 */
	public void setrChild(Node rChild) {
		this.rChild = rChild;
		rChild.setHeight(this.getHeight() + 1);
	}
	
    /**
     * isLeaf
     * returns a boolean value - true if no children are present on the node, and false if children are detected
     * @param Node node
     * @return boolean result
     */
    
    public boolean isLeaf() {
    	boolean result = true;
    	if(this.getlChild() != null || this.getrChild() != null) {
    		result = false;
    	}
    	return result;
    }
    
    
}