import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTester {

	@Test
	public void testInsertHappy() {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(10);
		assertEquals(10, tree.getRoot().getValue());

		tree.insert(9);
		assertEquals(9, tree.getRoot().getLeft().getValue());

		tree.insert(11);
		assertEquals(11, tree.getRoot().getRight().getValue());

		tree.insert(8);
		assertEquals(8, tree.getRoot().getLeft().getLeft().getValue());

		tree.insert(12);
		assertEquals(12, tree.getRoot().getRight().getRight().getValue());
	}

	@Test
	public void testInsertEdge() {
		BinarySearchTree tree = new BinarySearchTree();

		tree.setRoot(new BinaryNode(10, null,null, null));

	}
	
	@Test
	public void testInsertSad(){
		BinarySearchTree tree = new BinarySearchTree();

		tree.setRoot(new BinaryNode(10, null,null, null));

		tree.insert(10);
	}

	@Test
	public void testSearchHappy(){
		BinarySearchTree tree = new BinarySearchTree();

		tree.setRoot(new BinaryNode(10, null, null,null));
		assertTrue(tree.search(10));

		tree.getRoot().setLeft(new BinaryNode(6, null, null, tree.getRoot()));
		assertTrue(tree.search(6));

		tree.getRoot().setRight(new BinaryNode(11, null, null, tree.getRoot()));
		assertTrue(tree.search(11));

	}

	@Test
	public void testSearchSad(){
		BinarySearchTree tree = new BinarySearchTree();

		assertFalse(tree.search(23));
		assertFalse(tree.search(18));

	}

	@Test
	public void testGetMaxHappy(){
		BinarySearchTree tree = new BinarySearchTree();
		BinaryNode root = new BinaryNode(10, null, null, null);
		BinaryNode temp1 = new BinaryNode(11, null, null, root);
		BinaryNode temp2 = new BinaryNode(6, null, null, root);
		root.setRight(temp1);
		root.setLeft(temp2);
		tree.setRoot(root);

		assertEquals(11, tree.getMax());


		BinaryNode temp3 = new BinaryNode(1234, null, null, temp1);
		temp1.setRight(temp3);
		//		
		//		root.setRight(temp1);
		//		tree.setRoot(root);
		BinaryNode temp5 = new BinaryNode(2345, null, null, temp3);
		temp3.setRight(temp5);
		BinaryNode temp4 = new BinaryNode(2344, null,null, temp5);
		temp5.setLeft(temp4);

		assertEquals(2345, tree.getMax());

	}

	@Test 
	public void testGetMaxEdge(){
		BinarySearchTree tree = new BinarySearchTree();
		BinaryNode root = new BinaryNode(10, null, null, null);
		tree.setRoot(root);

		assertEquals(10, tree.getMax());

		tree.getRoot().setLeft(new BinaryNode(5, null, null, root));

		assertEquals(10, tree.getMax());
	}
	@Test
	public void testGetMaxSad(){
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(Integer.MIN_VALUE, tree.getMax());
	}

	@Test
	public void testDeleteHappy(){

		BinarySearchTree tree = new BinarySearchTree();
		BinaryNode root = new BinaryNode(10, null, null, null);

		BinaryNode temp5 = new BinaryNode(6, null, null, root);
		BinaryNode temp6 = new BinaryNode(13, null, null, root);

		BinaryNode temp1 = new BinaryNode(36, null,null, temp6);
		BinaryNode temp2 = new BinaryNode(3, null, null, temp5);
		BinaryNode temp3 = new BinaryNode(7, null, null, temp5);
		BinaryNode temp4 = new BinaryNode(12, null, null, temp6);

		BinaryNode temp7 = new BinaryNode(2, null, null, temp2);
		BinaryNode temp8 = new BinaryNode(4, null, null, temp2);
		BinaryNode temp9 = new BinaryNode(8, null, null, temp3);

		temp2.setRight(temp8);
		temp2.setLeft(temp7);
		temp3.setRight(temp9);

		temp5.setRight(temp3);
		temp5.setLeft(temp2);
		temp6.setRight(temp1);
		temp6.setLeft(temp4);

		root.setRight(temp6);
		root.setLeft(temp5);
		tree.setRoot(root);

		tree.delete(12);

		BinaryNode tester = tree.getRoot().getRight().getLeft();
		assertNull(tester);

		tree.delete(13);
		tester = tree.getRoot().getRight();
		assertEquals(36, tester.getValue());

		tree.delete(3);
		tester = tree.getRoot().getLeft().getLeft();
		BinaryNode tester2 = tester.getLeft();

		assertEquals(4, tester.getValue());
		assertEquals(2, tester2.getValue());

	}

	@Test
	public void testDeleteEdge(){

		BinarySearchTree tree = new BinarySearchTree();
		tree.setRoot(new BinaryNode(10, null, null, null));

		tree.delete(10);

		assertNull(tree.getRoot());

	}
	@Test
	public void testDeleteSad(){

		BinarySearchTree tree = new BinarySearchTree();
		tree.delete(24);

		tree.setRoot(new BinaryNode(10, null, null, null));
		tree.getRoot().setLeft(new BinaryNode(6, null, null, tree.getRoot()));
		tree.getRoot().setRight(new BinaryNode(11, null, null, tree.getRoot()));

		tree.delete(12);
	}
	
	@Test
	public void testDisplayInOrderHappy(){
		BinarySearchTree tree = new BinarySearchTree();
		BinaryNode root = new BinaryNode(10, null, null, null);
		
		BinaryNode temp6 = new BinaryNode(13, null, null, root);
		BinaryNode temp5 = new BinaryNode(6, null, null, root);
		

		BinaryNode temp1 = new BinaryNode(36, null,null, temp6);
		BinaryNode temp2 = new BinaryNode(3, null, null, temp5);
		BinaryNode temp3 = new BinaryNode(7, null, null, temp5);
		BinaryNode temp4 = new BinaryNode(12, null, null, temp6);

		BinaryNode temp7 = new BinaryNode(2, null, null, temp2);
		BinaryNode temp8 = new BinaryNode(4, null, null, temp2);
		BinaryNode temp9 = new BinaryNode(8, null, null, temp3);

		temp2.setRight(temp8);
		temp2.setLeft(temp7);
		temp3.setRight(temp9);

		temp5.setRight(temp3);
		temp5.setLeft(temp2);
		temp6.setRight(temp1);
		temp6.setLeft(temp4);

		root.setRight(temp6);
		root.setLeft(temp5);
		tree.setRoot(root);
		
		assertEquals("2,3,4,6,7,8,10,12,13,36,", tree.displayInOrder());
		
		
	}
	
	@Test
	public void testDisplayInOrderEdge(){
		BinarySearchTree tree = new BinarySearchTree();
		tree.setRoot(new BinaryNode(10, null, null, null));
		
		assertEquals("10", tree.displayInOrder());
	}

	@Test
	public void testDisplayInOrderSad(){
		BinarySearchTree tree = new BinarySearchTree();

		assertEquals("Empty tree!", tree.displayInOrder());

	}
	
	@Test
	public void testDisplayPreOrderHappy(){
		BinarySearchTree tree = new BinarySearchTree();
		BinaryNode root = new BinaryNode(10, null, null, null);
		
		BinaryNode temp6 = new BinaryNode(13, null, null, root);
		BinaryNode temp5 = new BinaryNode(6, null, null, root);
		

		BinaryNode temp1 = new BinaryNode(36, null,null, temp6);
		BinaryNode temp2 = new BinaryNode(3, null, null, temp5);
		BinaryNode temp3 = new BinaryNode(7, null, null, temp5);
		BinaryNode temp4 = new BinaryNode(12, null, null, temp6);

		BinaryNode temp7 = new BinaryNode(2, null, null, temp2);
		BinaryNode temp8 = new BinaryNode(4, null, null, temp2);
		BinaryNode temp9 = new BinaryNode(8, null, null, temp3);

		temp2.setRight(temp8);
		temp2.setLeft(temp7);
		temp3.setRight(temp9);

		temp5.setRight(temp3);
		temp5.setLeft(temp2);
		temp6.setRight(temp1);
		temp6.setLeft(temp4);

		root.setRight(temp6);
		root.setLeft(temp5);
		tree.setRoot(root);
		
		assertEquals("10,6,3,2,4,7,8,13,12,36", tree.displayPreOrder());
		
		
	}
	
	@Test
	public void testDisplayPreOrderEdge(){
		BinarySearchTree tree = new BinarySearchTree();
		tree.setRoot(new BinaryNode(10, null, null, null));
		
		assertEquals("10", tree.displayPreOrder());
	}

	@Test
	public void testDisplayPreOrderSad(){
		BinarySearchTree tree = new BinarySearchTree();

		assertEquals("Empty tree!", tree.displayPreOrder());

	}
	
	@Test
	public void testDisplayPostOrderHappy(){
		BinarySearchTree tree = new BinarySearchTree();
		BinaryNode root = new BinaryNode(10, null, null, null);
		
		BinaryNode temp6 = new BinaryNode(13, null, null, root);
		BinaryNode temp5 = new BinaryNode(6, null, null, root);
		

		BinaryNode temp1 = new BinaryNode(36, null,null, temp6);
		BinaryNode temp2 = new BinaryNode(3, null, null, temp5);
		BinaryNode temp3 = new BinaryNode(7, null, null, temp5);
		BinaryNode temp4 = new BinaryNode(12, null, null, temp6);

		BinaryNode temp7 = new BinaryNode(2, null, null, temp2);
		BinaryNode temp8 = new BinaryNode(4, null, null, temp2);
		BinaryNode temp9 = new BinaryNode(8, null, null, temp3);

		temp2.setRight(temp8);
		temp2.setLeft(temp7);
		temp3.setRight(temp9);

		temp5.setRight(temp3);
		temp5.setLeft(temp2);
		temp6.setRight(temp1);
		temp6.setLeft(temp4);

		root.setRight(temp6);
		root.setLeft(temp5);
		tree.setRoot(root);
		
		assertEquals("2,4,3,8,7,6,12,36,13,10", tree.displayPostOrder());
		
		
	}
	
	@Test
	public void testDisplayPostOrderEdge(){
		BinarySearchTree tree = new BinarySearchTree();
		tree.setRoot(new BinaryNode(10, null, null, null));
		
		assertEquals("10", tree.displayPostOrder());
	}

	@Test
	public void testDisplayPostOrderSad(){
		BinarySearchTree tree = new BinarySearchTree();

		assertEquals("Empty tree!", tree.displayPostOrder());

	}
}
