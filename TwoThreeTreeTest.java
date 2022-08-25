import static org.junit.Assert.*;

import org.junit.Test;

public class TwoThreeTreeTest {

		@Test
		public void testInsertSad(){
			TwoThreeTree tree = new TwoThreeTree();
			tree.setRoot(new TwoNode(1234));
			tree.insert(1234);
		}
		@Test
		public void testInsertEdge() {
			TwoThreeTree tree = new TwoThreeTree();
			tree.insert(12);
			
			assertNotNull(tree.getRoot());
			assertEquals(TwoNode.class, tree.getRoot().getClass());
			
			tree.insert(14);
			
			assertEquals(ThreeNode.class, tree.getRoot().getClass());
			assertEquals(14, tree.getRoot().getLarger());
			assertEquals(12, tree.getRoot().getSmaller());
		}
		
		@Test
		public void testInsertHappy(){
			
		}

	@Test
	public void testSearchSad(){
		TwoThreeTree tree = new TwoThreeTree();

		assertFalse(tree.search(20));

	}

	@Test
	public void testSearchEdge(){
		TwoThreeTree tree = new TwoThreeTree();
		tree.setRoot(new TwoNode(20));

		assertTrue(tree.search(20));

		tree.setRoot(new ThreeNode(25, 30));
		assertTrue(tree.search(25));
	}

	@Test
	public void testSearchHappy(){
		TwoThreeTree tree = new TwoThreeTree();

		Node lleft1 = new TwoNode(12);
		Node lright1 = new ThreeNode(18, 15);
		Node left2 = new TwoNode(14, lleft1, lright1);
		lleft1.setParent(left2);
		lright1.setParent(left2);

		Node rleft1 = new ThreeNode(80, 67);
		Node rright1 = new TwoNode(90);
		Node rcenter1 = new TwoNode(87);
		Node right2 = new ThreeNode(89, 81, rleft1, rright1, rcenter1);
		rleft1.setParent(right2);
		rright1.setParent(right2);
		rcenter1.setParent(right2);

		Node root = new TwoNode(20, left2, right2);
		left2.setParent(root);
		right2.setParent(root);

		tree.setRoot(root);

		assertTrue(tree.search(90));


	}

	@Test
	public void testGetMaxSad(){
		TwoThreeTree tree = new TwoThreeTree();
		assertEquals(Integer.MIN_VALUE, tree.getMax());
	}

	@Test 
	public void testGetMaxEdge(){
		TwoThreeTree tree = new TwoThreeTree();
		tree.setRoot(new ThreeNode(34, 5));

		assertEquals(34, tree.getMax());

		tree.setRoot(new TwoNode(45));

		assertEquals(45, tree.getMax());
	}

	@Test
	public void testGetMaxHappy(){
		TwoThreeTree tree = new TwoThreeTree();

		Node lleft1 = new TwoNode(12);
		Node lright1 = new ThreeNode(18, 15);
		Node left2 = new TwoNode(14, lleft1, lright1);
		lleft1.setParent(left2);
		lright1.setParent(left2);

		Node rleft1 = new ThreeNode(80, 67);
		Node rright1 = new TwoNode(90);
		Node rcenter1 = new TwoNode(87);
		Node right2 = new ThreeNode(89, 81, rleft1, rright1, rcenter1);
		rleft1.setParent(right2);
		rright1.setParent(right2);
		rcenter1.setParent(right2);

		Node root = new TwoNode(20, left2, right2);
		left2.setParent(root);
		right2.setParent(root);

		tree.setRoot(root);

		assertEquals(90, tree.getMax());
	}

	@Test
	public void testDisplayInOrderSad(){
		TwoThreeTree tree = new TwoThreeTree();
		assertEquals("Empty tree!", tree.displayInOrder());

	}

	@Test
	public void testDisplayInOrderEdge(){
		TwoThreeTree tree = new TwoThreeTree();
		tree.setRoot(new ThreeNode(5436, 1));

		assertEquals("1,5436,", tree.displayInOrder());
	}

	@Test
	public void testDisplayInOrderHappy(){
		TwoThreeTree tree = new TwoThreeTree();

		Node lleft1 = new TwoNode(12);
		Node lright1 = new ThreeNode(18, 15);
		Node left2 = new TwoNode(14, lleft1, lright1);
		lleft1.setParent(left2);
		lright1.setParent(left2);

		Node rleft1 = new ThreeNode(80, 67);
		Node rright1 = new TwoNode(90);
		Node rcenter1 = new TwoNode(87);
		Node right2 = new ThreeNode(89, 81, rleft1, rright1, rcenter1);
		rleft1.setParent(right2);
		rright1.setParent(right2);
		rcenter1.setParent(right2);

		Node root = new TwoNode(20, left2, right2);
		left2.setParent(root);
		right2.setParent(root);

		tree.setRoot(root);

		assertEquals("12,14,15,18,20,67,80,81,87,89,90,", tree.displayInOrder());
	}

}
