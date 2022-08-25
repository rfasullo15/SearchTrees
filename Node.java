
public class Node {	
	private Node parent;
	private Node left;
	private Node right;
	private Node center;
	private int larger;
	private int smaller;
	private int value;
	
	
	public Node(Node parent, int larger, int smaller, int value) {
		super();
		this.parent = parent;
		this.larger = larger;
		this.smaller = smaller;
		this.value = value;
	}
	public Node() {
		super();
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getCenter() {
		return center;
	}
	public void setCenter(Node center) {
		this.center = center;
	}
	public int getLarger() {
		return larger;
	}
	public void setLarger(int larger) {
		this.larger = larger;
	}
	public int getSmaller() {
		return smaller;
	}
	public void setSmaller(int smaller) {
		this.smaller = smaller;
	}
	
	
	
}
