package com.pinganfu.test.tree.avl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class TestAVL {

	private Node root;

	public static class Node {

		private Node left;
		private Node right;

		private int value;
		private int height;

		public Node(int value) {
			super();
			this.value = value;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getLeft() {
			return left;
		}

		public int getVal() {
			// TODO Auto-generated method stub
			return value;
		}

	}

	public void insert(int value) {

		// if (root == null) {
		// root = new Node(value);
		// } else {
		root = insertNode(root, value);
		// }

	}

	private Node insertNode(Node node, int value) {
		// Node node = null;
		if (node == null) {
			node = new Node(value);
		} else if (value < node.value) {
			node.left = insertNode(node.left, value);
			if (Math.abs(height(node.left) - height(node.right)) == 2) {
				if (value < node.left.value) {
					node = rotateRight(node);
				} else if (value > node.left.value) {
					node = doubleRotatewithRight(node);
				}
			}

		} else if (value > node.value) {
			node.right = insertNode(node.right, value);
			if (Math.abs(height(node.left) - height(node.right)) == 2) {
				if (value > node.right.value) {
					node = rotateLeft(node);
				} else if (value < node.right.value) {
					node = doubleRotatewithLeft(node);
				}
			}
		}

		node.height = maxHeight(height(node.left), height(node.right)) + 1;

		return node;
	}

	public int height(Node n) {
		if (n == null)
			return -1;
		else
			return n.height;
	}

	public int maxHeight(int lefth, int righth) {
		return lefth > righth ? lefth : righth;
	}

	private Node rotateRight(Node node) {
		// System.out.println(node.value );
		// System.out.println(node.left );
		// if(node.left == null)
		Node l = node.left;
		node.left = l.right;
		l.right = node;

		node.height = maxHeight(height(node.left), height(node.right)) + 1;
		l.height = maxHeight(height(l.left), height(l.right)) + 1;

		return l;

	}

	private Node rotateLeft(Node node) {
		Node r = node.right;
		node.right = r.left;
		r.left = node;

		/*
		 * AvlTree R = T->m_pRight; T->m_pRight = R->m_pLeft; R->m_pLeft = T;
		 */

		node.height = maxHeight(height(node.left), height(node.right)) + 1;
		r.height = maxHeight(height(r.left), height(r.right)) + 1;

		return r;
	}

	private Node doubleRotatewithRight(Node node) {

		node.left = rotateLeft(node.left);

		return rotateRight(node);
	}

	private Node doubleRotatewithLeft(Node node) {

		node.right = rotateRight(node.right);

		return rotateLeft(node);
	}

	private void appendHegiht(StringBuilder sb, int h) {

		// int h = root.height;
		while (h > 0) {
			sb.append("  ");
			h--;
		}
	}

	private void iter(StringBuilder sb, ArrayBlockingQueue<Node> queue) {

		if (queue.isEmpty())
			return;
		Node last = queue.peek();
		// Iterator<Node> it = queue.iterator();
		Node nlast = null;
		while (!queue.isEmpty()) {
			Node n = (Node) queue.poll();
			if (n.left != null) {
				queue.offer(n.left);
				nlast = n.left;
				// appendHegiht(sb,n.left.height);
				// sb.append(n.left.value);
			}

			// sb.append(" ");
			if (n.right != null) {
				queue.offer(n.right);
				nlast = n.right;
				// sb.append(n.right.value);
			}

			System.out.print("  " + n.value);
			// 当当前打印节点为当前行最右节点时换行
			if (last.equals(n)) {
				System.out.println();
				last = nlast;
			}
			// sb.append("\n");
			// it = queue.iterator();

		}

		// iter(sb,queue);

	}

	public void pirntTree() {
		Queue queue = new LinkedList();
		Node last = null;
		Node nlast = null;
		Node tmpNode = null;
		if (root != null)
			queue.add(root);
		last = root;
		// System.out.print();
		while (!queue.isEmpty()) {
			tmpNode = (Node) queue.poll();
			if (null != tmpNode.getLeft()) {
				queue.add(tmpNode.getLeft());
				nlast = tmpNode.getLeft();
			}

			if (null != tmpNode.getRight()) {
				queue.add(tmpNode.getRight());
				nlast = tmpNode.getRight();
			}
			System.out.print(tmpNode.getVal());
			if (tmpNode.equals(last)) {
				System.out.print("\n");
				last = nlast;
			} else {
				continue;
			}
		}
	}

	public void middleOrderPrint() {
		ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue(500);
		StringBuilder sb = new StringBuilder();
		// queue.offer(root);

		// appendHegiht(sb, root.height);
		// sb.append(root.value);
		// sb.append("\n");

		// iter(sb,queue);
		if(root == null )
			System.out.println("value empty");

		pirntTree();

		// sb.append(root.value + " " + root.height + " ");

		// print(sb,root);
		// System.out.println(sb.toString());
	}

	public void print(StringBuilder sb, Node node) {

		// if(node == null)
		// return ;

		// sb.append(node.value + " ");

		if (node.left != null) {
			sb.append(node.left.value + " " + node.left.height + " ");
			// if(node.left.left != null)
			print(sb, node.left);
		}

		if (node.right != null) {
			sb.append(node.right.value + " " + node.right.height + " ");
			// if(node.right.left != null)
			print(sb, node.right);
		}
	}

	public void testC(Node r) {
		r = new Node(3);
		// return r;
	}

	private Node findMin(Node node) {
		Node min = node.right;
		while (min.left != null) {
			min = min.left;
			// r = r.left;
		}

		return min;
	}

	public void remove(int value) {
		root = removeNode(root, value);
	}

	private Node rebanlance(Node node) {
		
		if (height(node.right) - height(node.left) == 2) {
			if(node.right == null)
				System.out.println("l : "+ height(node.left) +" r : "+ height(node.right));
			if(height(node.right.left) > height(node.right.right)) {
				node = doubleRotatewithLeft(node);
			}else {
				node = rotateLeft(node);
			}
			//if (node.right.right != null)
			//else if (node.right.left != null) {
				
			//}
		}
		
		if (height(node.left) - height(node.right) == 2) {
			if(node.left == null)
				System.out.println("l : "+ height(node.left) +" r : "+ height(node.right));
			
			if(height(node.left.right) > height(node.left.left)) {
				node = doubleRotatewithRight(node);
			}else {
				node = rotateRight(node);
			}
		}
		
		return node;
	}
	
	public Node removeNode(Node node, int value) {

		if (node == null)
			return node;
		else if (value < node.value) {
			node.left = removeNode(node.left, value);
			rebanlance(node);
			/*if (Math.abs(height(node.left) - height(node.right)) == 2) {
				if(node.right == null)
					System.out.println("l : "+ height(node.left) +" r : "+ height(node.right));
				if(height(node.right.left) > height(node.right.right)) {
					node = doubleRotatewithLeft(node);
				}else {
					node = rotateLeft(node);
				}*/
				//if (node.right.right != null)
				//else if (node.right.left != null) {
					
				//}
			//}
		} else if (value > node.value) {
			node.right = removeNode(node.right, value);
			rebanlance(node);
			/*if (Math.abs(height(node.left) - height(node.right)) == 2) {
				if(node.left == null)
					System.out.println("l : "+ height(node.left) +" r : "+ height(node.right));
				
				if(height(node.left.right) > height(node.left.left)) {
					node = doubleRotatewithRight(node);
				}else {
					node = rotateRight(node);
				}
				/*
				if (node.left.left != null) {
					node = rotateRight(node);
				} else if (node.left.right != null) {
					node = doubleRotatewithRight(node);
				}
			}*/
		} else {
			if (node.left != null && node.right != null) {
				Node min = findMin(node);
				node.value = min.value;
				node.right = removeNode(node.right, node.value);
				rebanlance(node);
			} else if (node.left != null) {
				node = node.left;
				node.left = null;
				//node.left = removeNode(node.left, node.value);
			} else if (node.right != null) {
				node = node.right;
				node.right =null;
				//node.right = removeNode(node.right, node.value);
			} else {
				node = null;
			}
		}

		if (node != null) {
		/*	if (height(node.left) - height(node.right) == 2) {
				if (node.left.left != null) {
					node = rotateRight(node);
				} else if (node.left.right != null) {
					node = doubleRotatewithRight(node);
				}
			} else if (height(node.right) - height(node.left) == 2) {
				if (node.right.right != null)
					node = rotateLeft(node);
				else if (node.right.left != null) {
					node = doubleRotatewithLeft(node);
				}
			}*/
		//}
		// }
		node.height = maxHeight(height(node.left), height(node.right)) + 1;
	    }

	return node;

	}
	
	
	private void test1() {
		TestAVL test = new TestAVL();
		Node s = new Node(7);
		test.testC(s);

		Random r = new Random(1000);
		
		int[] a1 = {76,35,87,24,45,92,41,49};
		
		for(int i:a1) {
			test.insert(i);
		}
		test.middleOrderPrint();

		for (Integer i : a1) {
			//System.out.println(i);
			test.remove(i.intValue());
		}
		
		test.middleOrderPrint();
	}
	
	
    private static void test2() {
    	TestAVL test = new TestAVL();
		Random r = new Random();

    	List<Integer> a = new ArrayList();
		for (int i = 16; i < 127; i++) {
			int rn = r.nextInt(105);
			test.insert(rn);
			a.add(rn);
			// test.remove(i);
		}

		test.middleOrderPrint();

		System.out.println("-------------------------");

		for (Integer i : a) {
			System.out.println(i);
			test.remove(i.intValue());
		}

		System.out.println("-------------------------");
		test.middleOrderPrint();

	}

	public static void main(String[] args) {
		
         test2();
		/*
		List<Integer> a = new ArrayList();
		for (int i = 16; i < 24; i++) {
			int rn = r.nextInt(100);
			test.insert(rn);
			a.add(rn);
			// test.remove(i);
		}

		test.middleOrderPrint();

		System.out.println("-------------------------");

		for (Integer i : a) {
			System.out.println(i);
			test.remove(i.intValue());
		}

		System.out.println("-------------------------");

		// test.middleOrderPrint();

		// test.insert(r.nextInt());
		for (int i = 16; i < 21; i++) {
			// test.middleOrderPrint();

		}

		test.middleOrderPrint();*/

		// test.middleOrderPrint();

	}

}
