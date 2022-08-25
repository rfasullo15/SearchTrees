
public class ThreeNode extends Node{

	private Node parent;
	private Node left;
	private Node right;
	private Node center;
	private int larger;
	private int smaller;
	
	
	public ThreeNode(int larger, int smaller) {
		this.larger = larger;
		this.smaller = smaller;
	}

	public ThreeNode(Node parent, int larger, int smaller) {
		this.parent = parent;
		this.larger = larger;
		this.smaller = smaller;
	}

	public ThreeNode(Node parent, Node left, Node right, Node center, int larger, int smaller) {
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.center = center;
		this.larger = larger;
		this.smaller = smaller;
	}
	
	public ThreeNode(int larger, int smaller, Node left, Node right, Node center){
		this.left = left;
		this.right = right;
		this.center = center;
		this.larger = larger;
		this.smaller = smaller;
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

	@Override
	public String toString() {
		return "ThreeNode [left=" + left + ", right=" + right + ", center=" + center + ", larger=" + larger
				+ ", smaller=" + smaller + "]";
	}
	
	
	
	
	
}
