
public class TwoNode extends Node{

	private Node parent;
	private Node left;
	private Node right;
	private int value;
	
	public TwoNode(int value) {
		this.value = value;
	}
	public TwoNode(Node parent, int value) {
		this.parent = parent;
		this.value = value;
	}
	public TwoNode(Node parent, Node left, Node right, int value) {
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public TwoNode( int value, Node left, Node right){
		this.left = left;
		this.right = right;
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "TwoNode [left=" + left + ", right=" + right + ", value=" + value + "]";
	}
	
	
}
