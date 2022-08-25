
public class BinaryNode {

	private int value;
	private BinaryNode right;
	private BinaryNode left;
	private BinaryNode parent;
	
	

	public BinaryNode(int value, BinaryNode right, BinaryNode left, BinaryNode parent){
		this.value = value; 
		this.right = right;
		this.left = left;
		this.parent = parent;
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}
	
	
	public BinaryNode getParent() {
		return parent;
	}

	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "BinaryNode [value=" + value + ", right=" + right + ", left=" + left + ", parent= " + parent.value + "]";
	}
}
