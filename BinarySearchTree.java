import java.lang.reflect.Array;

public class BinarySearchTree {

	private BinaryNode root;


	public BinarySearchTree(){
		root = null;

	}

	public void insert(int value){
		if(root ==null){
			root = new BinaryNode(value, null, null, null);
		} else {
			recursiveInsert(value, root);
		}

	}

	private void recursiveInsert(int value, BinaryNode current){
		if(value<current.getValue()){            //if the value given is less than the current nodes value
			if(current.getLeft() == null){          // if the current left node is null
				current.setLeft(new BinaryNode(value, null, null, current));            //make a new node
			} else {
				BinaryNode temp = current.getLeft();                          //otherwise reset current to be whatever the left of current is
				current = temp;
				recursiveInsert(value, current);
			}
		} else if (value>current.getValue()){
			if(current.getRight() ==null){
				current.setRight(new BinaryNode(value, null, null, current));
			} else {
				BinaryNode temp = current.getRight();
				current = temp;
				recursiveInsert(value, current);
			}
		} else {
			System.out.println("DUPLICATE VALUE");
		}

	}

	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}

	public boolean search(int value){

		if(root == null){
			return false;
		} else {
			return searchRecursive(value, root);
		}
	}
	private boolean searchRecursive(int value, BinaryNode current){

		if(value<current.getValue()){            //if the value given is less than the current nodes value
			if(current.getLeft() == null){          // if the current left node is null
				return false;
			} else {
				current = current.getLeft();
				return searchRecursive(value, current);
			}
		} else if (value>current.getValue()){
			if(current.getRight() ==null){
				return false;
			} else {
				current = current.getRight();
				return searchRecursive(value, current);
			}
		} else {                                       //This situation only happens when current.getValue() == value
			return true;
		}


	}

	public int getMax(){
		if(root == null){
			return Integer.MIN_VALUE;
		} else if (root.getRight() == null){
			return root.getValue();
		} else {
			return goRight(root);
		}
	}

	private int goRight(BinaryNode current){
		BinaryNode temp = current.getRight();
		if(temp != null){
			return goRight(temp);
		}
		return current.getValue();

	}


	public void delete(int value){
		if(!search(value)){
			System.out.println("Node does not exist!!");
		} else if (root.getLeft() == null && root.getRight() == null){        // we know that the value is in the tree, and if the root is the only node in the tree
			root = null;                                                           // then we just delete the root of the tree
		} else {
			deleteRecursive(value, root);
		}
	}

	private void deleteRecursive(int value, BinaryNode current){
		if(value == current.getValue()){
			if(isLeaf(current)){
				System.out.println(current);
				if(current.getParent().getRight() ==current){
					current.getParent().setRight(null);
				} else {
					current.getParent().setLeft(null);
				}
			} else if(hasOnlyRight(current)){
				current.getParent().setRight(current.getRight());
				current.getRight().setParent(current.getParent());
			} else if(hasOnlyLeft(current)){
				current.getParent().setLeft(current.getLeft());
				current.getLeft().setParent(current.getParent());
			} else {
				current.getRight().setLeft(current.getLeft());             // the left of current becomes the left of the right child
				current.getRight().setParent(current.getParent());
				if(value<current.getParent().getValue()){                     //If the current node is to the left of the parent	
					current.getParent().setLeft(current.getRight());            // the right child becomes the left of the parent
				} else {
					current.getParent().setRight(current.getRight());
				}
			}
		} else if(value<current.getValue()){           // don't need to check if the left is null, we already know the value is in the tree
			deleteRecursive(value, current.getLeft());
		} else if (value>current.getValue()){
			deleteRecursive(value, current.getRight());
		}
	}

	private boolean hasOnlyRight(BinaryNode current) {

		return current.getRight() !=null && current.getLeft() == null;
	}

	private boolean hasOnlyLeft(BinaryNode current) {

		return current.getRight() ==null && current.getLeft() != null;
	}

	private boolean isLeaf(BinaryNode current) {
		return current.getLeft()==null && current.getRight() ==null;
	}

	public String displayInOrder(){
		if(root== null){
			return "Empty tree!";
		} else if (isLeaf(root)){
			return Integer.toString(root.getValue());
		} else {
			return recurseInOrder(root);
		}
	}

	private String recurseInOrder(BinaryNode current){
		if(isLeaf(current)){
			return Integer.toString(current.getValue()) + ",";
		} else if (hasOnlyRight(current)){
			return current.getValue() + "," + recurseInOrder(current.getRight());
		} else if (hasOnlyLeft(current)){
			return recurseInOrder(current.getLeft()) + "," + current.getValue();
		} else {
			return	recurseInOrder(current.getLeft()) + current.getValue() + "," + recurseInOrder(current.getRight());
		}
	}



	public String displayPreOrder(){
		if(root== null){
			return "Empty tree!";
		} else if (isLeaf(root)){
			return Integer.toString(root.getValue());
		} else {
			return recursePreOrder(root);
		}
	}
	
	private String recursePreOrder(BinaryNode current){
		if(isLeaf(current)){
			return Integer.toString(current.getValue());
		} else if (hasOnlyRight(current)){
			return current.getValue() + "," + recursePreOrder(current.getRight()) ;
		} else if (hasOnlyLeft(current)){
			return current.getValue() + "," + recursePreOrder(current.getLeft());
		} else {
			return	current.getValue() + "," + recursePreOrder(current.getLeft()) +","+ recursePreOrder(current.getRight());
		}
	}

	public String displayPostOrder(){
		if(root== null){
			return "Empty tree!";
		} else if (isLeaf(root)){
			return Integer.toString(root.getValue());
		} else {
			return recursePostOrder(root);
		}
	}
	
	private String recursePostOrder(BinaryNode current){
		if(isLeaf(current)){
			return Integer.toString(current.getValue());
		} else if (hasOnlyRight(current)){
			return  recursePostOrder(current.getRight()) + "," + current.getValue();
		} else if (hasOnlyLeft(current)){
			return  recursePostOrder(current.getLeft()) + "," + current.getValue() ;
		} else {
			return	 recursePostOrder(current.getLeft()) +","+ recursePostOrder(current.getRight()) + "," + current.getValue();
		}
	}

	@Override
	public String toString() {
		return "BinarySearchTree [root=" + root + "]";
	}
}
