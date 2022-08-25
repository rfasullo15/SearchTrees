
public class TwoThreeTree {

	private Node root;
	private Node lastSearched;

	public TwoThreeTree(){
		root = null;
	}


	public void insert(int value){
		if(root == null){
			root = new TwoNode(value);
		} else if(!search(value)){
			Node current = lastSearched;
			Node parent = lastSearched.getParent();
			if(current.getClass() == TwoNode.class){
				current = turnIntoThree(current.getParent(), current.getValue(), value);
				if (parent!= null){
					if(parent.getLeft() == lastSearched){
						parent.setLeft(current);
					} else if (parent.getCenter() == lastSearched){
						parent.setCenter(current);
					} else {
						parent.setRight(current);
					}
				} else {
					root = current;
				}
			} else {
				if(value<current.getSmaller()){
					current = new FourNode(current.getParent(), value, current.getSmaller(), current.getLarger());
				} else if (value > current.getLarger()) {
					current = new FourNode(current.getParent(), current.getSmaller(), current.getLarger(), value);
				} else {
					current = new FourNode(current.getParent(), current.getSmaller(), value, current.getLarger());
				}
				if (parent!= null){
					if(parent.getLeft() == lastSearched){
						parent.setLeft(current);
					} else if (parent.getCenter() == lastSearched){
						parent.setCenter(current);
					} else {
						parent.setRight(current);
					}
				} 
				split((FourNode)current);
			}

		} else {
			System.out.println("duplicate value!!");
		}
	}

	@Override
	public String toString() {
		return "TwoThreeTree [root=" + root + ", lastSearched=" + lastSearched + "]";
	}


	private void split(FourNode current){
		Node temp = new TwoNode(current.getSmaller());
		Node temp2 = new TwoNode(current.getLarger());
		
		temp.setLeft(current.getLeft());
		temp.setRight(current.getMiddle1());
		
		temp2.setLeft(current.getMiddle2());
		temp2.setRight(current.getRight());
		
		if(current == root){
			root = new TwoNode(current.getMiddle());
			root.setLeft(temp);
			root.setRight(temp2);
		}


	}

	/*
	 * search is done!
	 */
	public boolean search(int value){
		if(root == null){
			return false;
		} else {
			return searchRecursive(root, value);
		}
	}

	public boolean searchRecursive(Node current, int value){
		if(current.getClass() == TwoNode.class){
			return search2(current, value);
		} else {
			return search3(current, value);
		}
	}

	public boolean search2(Node current, int value){
		if(current.getValue() == value){

			return true;
		} else {
			if(value<current.getValue()){
				if(current.getLeft() != null){
					return searchRecursive(current.getLeft(), value);
				} else {
					lastSearched = current;
					return false;
				}
			} else {
				if(current.getRight() != null){
					return searchRecursive(current.getRight(), value);
				} else {
					lastSearched = current;
					return false;
				}
			}
		}
	}

	public boolean search3(Node current, int value){
		if(value == current.getLarger()){

			return true;
		} else if (value == current.getSmaller()){

			return true;
		} else {
			if(value < current.getSmaller()){
				if(current.getLeft() != null){
					return searchRecursive(current.getLeft(), value);
				} else {
					lastSearched = current;
					return false;
				}
			} else if (value > current.getSmaller() && value< current.getLarger()){
				if(current.getCenter()!= null){
					return searchRecursive(current.getCenter(), value);
				} else {
					lastSearched = current;
					return false;
				}
			} else {
				if(current.getRight() != null){
					return searchRecursive(current.getRight(), value);
				} else {
					lastSearched = current;
					return false;
				}
			}
		}

	}

	public int getMax(){
		if(root == null){
			return Integer.MIN_VALUE;
		} else {
			Node current = root;
			while (current.getRight() != null){
				current = current.getRight();
			}
			if(current.getClass() == TwoNode.class){
				return current.getValue();
			} else {
				return current.getLarger();
			}
		}
	}

	public String displayInOrder(){
		if(root== null){
			return "Empty tree!";
		} else {
			return recurseInOrder(root);
		}
	}


	private String recurseInOrder(Node current){          // you are either a leaf or completely full
		if(current.getClass() == TwoNode.class){
			if(current.getLeft() == null && current.getRight() == null){
				return Integer.toString(current.getValue()) + ",";
			} else {
				return	recurseInOrder(current.getLeft()) + current.getValue() + "," + recurseInOrder(current.getRight());
			}
		} else {
			if(current.getLeft() == null && current.getRight() == null && current.getCenter() == null){
				return Integer.toString(current.getSmaller()) + "," + Integer.toString(current.getLarger()) + ",";
			} else {
				return recurseInOrder(current.getLeft()) + current.getSmaller() + "," + recurseInOrder(current.getCenter()) 
				+ current.getLarger() + "," + recurseInOrder(current.getRight());
			}
		}
	}

	public ThreeNode turnIntoThree(Node parent, int value2, int value3) {
		if(value2< value3){
			return new ThreeNode(parent, value3, value2);
		} else {
			return new ThreeNode(parent, value2, value3);
		}
	}
	public TwoNode turnIntoTwo(Node parent, int smaller2) {
		return new TwoNode(parent, smaller2);
	}

	public Node getLastSearched() {
		return lastSearched;
	}

	public void setLastSearched(Node lastSearched) {
		this.lastSearched = lastSearched;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}

//	public void insert(int value){
//		if(root == null){
//			root = new TwoNode(value);
//		} else {
//			insertRecursive(root, value);
//		}
//
//	}
//
//	/*
//	 * THIS METHOD IS NOT DONE. YOU NEED TO USE THE WHITEBOARD AND MAP THIS OUT
//	 */
//	private void insertRecursive(Node current, int value) {
//		if (isTwoLeaf(current)){ 
//
//			twoLeafInsert(current,value);
//
//		} else if (isThreeLeaf(current)){     
//
//			threeLeafInsert(current, value);
//
//		} else if(TwoNode.class == current.getClass()){   							//if we are currently looking at a two node
//			if(current.getRight() != null && current.getLeft() != null){                                //both right and left are NOT null
//
//				if(value> current.getValue()){				
//					insertRecursive(current.getRight(), value);
//				} else if(value < current.getValue()){
//					insertRecursive(current.getLeft(), value);
//				}
//			}else if (current.getRight() == null && value> current.getValue()){
//				Node temp = new TwoNode(current, value);
//				current.setRight(temp);
//			} else if (current.getLeft() == null && value < current.getValue()){
//				Node temp = new TwoNode(current, value);
//				current.setLeft(temp);
//			}
//		} else if (ThreeNode.class == current.getClass()){
//			if(current.getRight() != null && current.getLeft() != null && current.getCenter() != null){                                //both right and left are NOT null
//				if(value< current.getSmaller()){				
//					insertRecursive(current.getLeft(), value);
//				} else if(value>current.getSmaller() && value < current.getLarger()){
//					insertRecursive(current.getCenter(), value);
//				} else if(value>current.getLarger()){
//					insertRecursive(current.getRight(), value);
//				}
//			} else if (current.getRight() == null && value> current.getLarger()){
//				Node temp = new TwoNode(current, value);
//				current.setRight(temp);
//			} else if (current.getLeft() == null && value < current.getSmaller()){
//				Node temp = new TwoNode(current, value);
//				current.setLeft(temp);
//			} else if (current.getCenter() == null && value> current.getSmaller() && value < current.getLarger()){
//				Node temp = new TwoNode(current, value);
//				current.setCenter(temp);
//			}
//
//		}
//
//	}  // END OF RECURSIVE INSERT
//
//	private void twoLeafInsert(Node current, int value){
//		if( value != current.getValue()){
//			current = turnIntoThree(current.getParent(), value, current.getValue());
//		} else {
//			System.out.println("DUPLICATE VALUE");
//		}
//	}  // END OF TWO LEAF INSERT
//
//	private void threeLeafInsert(Node current, int value){
//		if(value<current.getSmaller()){                               
//			if(current.getParent() != null && current.getParent().getClass() == TwoNode.class){
//				Node sibling;
//				int topValue = current.getLarger();
//				int bottomValue = current.getSmaller();
//
//				int parentValue = current.getParent().getValue();
//				current.setParent(turnIntoThree(current.getParent().getParent(), bottomValue, parentValue));
//
//				/*
//				 * if you are the right child then your sibling is the left child and vice versa
//				 */
//				if(current.getParent().getRight().equals(current)){
//					sibling = current.getParent().getLeft();
//					current.getParent().setLeft(sibling);
//					current.getParent().setCenter(turnIntoTwo(current.getParent().getParent(), value));
//					current.getParent().setRight(turnIntoTwo(current.getParent().getParent(), topValue));
//				} else {
//					sibling = current.getParent().getRight();
//					current.getParent().setLeft(turnIntoTwo(current.getParent(), value));
//					current.getParent().setCenter(turnIntoTwo(current.getParent(), topValue));
//					current.getParent().setRight(sibling);
//
//				}
//			} else if (current.getParent() != null && current.getParent().getClass() == ThreeNode.class){
//				Node sibling1;
//				Node sibling2;
//
//				Node parentSibling;
//
//				int topValue = current.getLarger();
//				int bottomValue = current.getSmaller();
//
//				int parentTop = current.getParent().getLarger();
//				int parentBotton = current.getParent().getSmaller();
//
//				Node parent = current.getParent();
//				Node grandParent = parent.getParent();                           //BE CAREFUL!!! THIS COULD BE NULL
//
//				if(parent.getLeft().getClass() == ThreeNode.class && parent.getCenter().getClass() == ThreeNode.class && parent.getRight().getClass() == ThreeNode.class){
//					if(parent.getLeft().equals(current)){
//						sibling1 = parent.getCenter();
//						sibling2 = parent.getRight();
//
//						grandParent = turnIntoTwo(grandParent, parentBotton);
//
//						grandParent.setLeft(turnIntoTwo(grandParent, bottomValue));
//						grandParent.setRight(turnIntoTwo(grandParent, parentTop));
//
//						parent = grandParent.getLeft();
//
//						parent.setLeft(turnIntoTwo(parent, value));
//						parent.setRight(turnIntoTwo(parent, topValue));
//
//						parentSibling = grandParent.getRight();
//
//						parentSibling.setLeft(sibling1);
//						parentSibling.setRight(sibling2);
//					} else if (parent.getCenter().equals(current)){
//						sibling1 = parent.getLeft();
//						sibling2 = parent.getRight();
//
//
//					}
//
//
//
//
//				}
//			}// End of if value < current.getSmaller
//		} else if (value>current.getSmaller() && value<current.getLarger()){
//			int leftValue = current.getSmaller();
//			int rightValue = current.getLarger();
//
//			if(current.getParent() != null && current.getParent().getClass() == TwoNode.class){
//				Node sibling;
//				int topValue = current.getLarger();
//				int bottomValue = current.getSmaller();
//
//				int parentValue = current.getParent().getValue();
//				current.setParent(turnIntoThree(current.getParent().getParent(), value, parentValue));
//
//				/*
//				 * if you are the right child then your sibling is the left child and vice versa
//				 */
//				if(current.getParent().getRight().equals(current)){
//					sibling = current.getParent().getLeft();
//
//					current.getParent().setLeft(sibling);
//					current.getParent().setCenter(turnIntoTwo(current.getParent().getParent(), bottomValue));
//					current.getParent().setRight(turnIntoTwo(current.getParent().getParent(), topValue));
//
//				} else {
//					sibling = current.getParent().getRight();
//					current.getParent().setLeft(turnIntoTwo(current.getParent(), bottomValue));
//					current.getParent().setCenter(turnIntoTwo(current.getParent(), topValue));
//					current.getParent().setRight(sibling);
//
//				}
//			}
//
//		} else if (value > current.getLarger()){
//
//			if(current.getParent() != null && current.getParent().getClass() == TwoNode.class){
//				Node sibling;
//				int topValue = current.getLarger();
//				int bottomValue = current.getSmaller();
//
//				int parentValue = current.getParent().getValue();
//				current.setParent(turnIntoThree(current.getParent().getParent(), topValue, parentValue));
//
//				/*
//				 * if you are the right child then your sibling is the left child and vice versa
//				 */
//				if(current.getParent().getRight().equals(current)){
//					sibling = current.getParent().getLeft();
//					current.getParent().setLeft(sibling);
//					current.getParent().setCenter(turnIntoTwo(current.getParent().getParent(), bottomValue));
//					current.getParent().setRight(turnIntoTwo(current.getParent().getParent(), value));
//				} else {
//					sibling = current.getParent().getRight();
//					current.getParent().setLeft(turnIntoTwo(current.getParent(), bottomValue));
//					current.getParent().setCenter(turnIntoTwo(current.getParent(), value));
//					current.getParent().setRight(sibling);
//				}
//			}
//
//
//		} else {
//			System.out.println("DUPLICATE VALUE");
//		} 
//	} // END OF THREE LEAF INSERT
//
//	private boolean isThreeLeaf(Node current) {
//		return current.getClass() == ThreeNode.class && current.getRight() ==null && current.getLeft() == null;
//	}
//
//	private boolean isTwoLeaf(Node current){
//		return current.getClass() == TwoNode.class && current.getRight() ==null && current.getLeft() == null;
//	}
