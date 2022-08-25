
public class FourNode extends Node {
	
	private Node parent;
	private Node left;
	private Node middle1;
	private Node middle2; 
	private Node right;
	private int smallest;
	private int middle;
	private int largest;
	
	
	public FourNode(Node parent,  int smallest, int middle, int largest) {
		parent = parent;
		this.smallest = smallest;
		this.middle = middle;
		this.largest = largest;
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
	public Node getMiddle1() {
		return middle1;
	}
	public void setMiddle1(Node middle1) {
		this.middle1 = middle1;
	}
	public Node getMiddle2() {
		return middle2;
	}
	public void setMiddle2(Node middle2) {
		this.middle2 = middle2;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getSmallest() {
		return smallest;
	}
	public void setSmallest(int smallest) {
		this.smallest = smallest;
	}
	public int getMiddle() {
		return middle;
	}
	public void setMiddle(int middle) {
		this.middle = middle;
	}
	public int getLargest() {
		return largest;
	}
	public void setLargest(int largest) {
		this.largest = largest;
	}
	@Override
	public String toString() {
		return "FourNode [left=" + left + ", middle1=" + middle1 + ", middle2=" + middle2 + ", right=" + right
				+ ", smallest=" + smallest + ", middle=" + middle + ", largest=" + largest + "]";
	}
	
	
	

}
