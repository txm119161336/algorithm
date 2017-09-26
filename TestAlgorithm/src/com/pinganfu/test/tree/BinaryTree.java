package com.pinganfu.test.tree;

/**
 * 
 * @author nishiting
 * 
 */

public class BinaryTree {

	private Node root;
	private int keyAmount;

	/**
	 * 内部类实现结点类，可提高安全性
	 * 
	 * @author nishiting
	 * 
	 */

	private static class Node {
		Node left;//左孩子
		Node right;//右孩子
		Node middle;//中间结点
		int keyAmount;//键值数
		int data[];//键值
		int size=0;//计算当前的健值数
		
		/**
		 * 初始化结点
		 * @param newData 键值
		 * @param keyAmount	结点数
		 */

		Node(int newData, int keyAmount) {
			++size;
			data = new int[2];
			left = null;
			right = null;
			middle = null;
			data[0] = newData;
			keyAmount = keyAmount;
		}
		
		/**
		 * 添加键值，根据position的位置移位
		 * @param newData	键值
		 * @param position	位置
		 */

		void addKey(int newData, int position) {

			++size;
			for(int z =position;z<size-1;z++){
				data[z+1] = data[z];
			}
			data[position] = newData;

		}

	}

	/**
	 * 创建一个空的二叉树
	 */

	public BinaryTree(int keyAmount) {
		root = null;
		this.keyAmount = keyAmount;
	}

	/**
	 * 递归的插入数值
	 * 
	 * @param data
	 *            要插入的数值
	 */

	public void insert(int data) {
		root = insert(root, data);
		
		System.out.println("-------"+data+"结束"+"------------------");
	}

	/**
	 * 将数值插入到二叉树中，比当前结点小或等于当前结点的插在当前结点的左侧，比当前结点大的数插在当前结点的右侧，每次从根结点开始递归比较
	 * 
	 * @param node
	 *            当前的结点，就是根结点，只是每次根结点的左右子孙更新
	 * @param data
	 *            要插入的数值
	 * @return 新排好的二叉树
	 */

	private Node insert(Node node, int data) {

		if (node == null) {

			node = new Node(data, keyAmount);

		} else {

			if (isFull(node)) {
				for (int i = 0; i < node.size; i++) {

					if (data <= node.data[i]) {
						System.out.println("进入左子数");
						node.left = insert(node.left, data);
						
						return node;
					} else {
						if (data <= node.data[i + 1]) {
							System.out.println("进入中间数");
							node.middle = insert(node.middle, data);
							
							return node;
						} else {
							System.out.println("进入右子数");
							node.right = insert(node.right, data);
							
							return node;
						}

					}

				}
			}else{
				for(int k =0;k < node.size;k++){
					
					if(data <= node.data[k]){
						node.addKey(data, k);
						return node;
					}
					
				}
				
					node.addKey(data, node.size);
			}

		}
		return (node);
	}

	/**
	 * 判断结点是否还有空闲空间
	 * 
	 * @param node
	 * @return
	 */
	private boolean isFull(Node node) {
		if (node.size >= keyAmount) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将数值输入构建二叉树
	 * 
	 * @param data
	 *            要输入的数值
	 */

	public void buildTree(int[] data) {

		for (int i = 0; i < data.length; i++) {

			insert(data[i]);

		}

	}

	/**
	 * 递归打印出二叉树
	 */

	public void printTree() {

		printTree(root);

		System.out.println();

	}

	/**
	 * 从根结点开始遍历，从树的最高层叶子结点开始输出，从左至右,如果没有中间指针的话先将结点的左部输出，
	 * 
	 * @param node
	 *            当前的结点
	 */

	private void printTree(Node node) {

		if (node == null)
			return;

		printTree(node.left);
		
		if(node.middle == null){
			
			for(int z = 0;z<node.size;z++){
				
				System.out.print(node.data[z] + "  ");
				
			}
			
		}else{
			System.out.println(node.data[0]);
		}
		


		printTree(node.middle);
		
		if(node.middle != null){
			System.out.println(node.data[1]);
		}


		printTree(node.right);

	}

	
	public static void main(String[] args) {
		  BinaryTree b = new BinaryTree(9);
		  b.insert(4);
		  b.insert(5);
		  b.insert(56);
		  b.insert(33);
		  b.insert(13);
		  b.insert(34);
		  b.insert(21);
		  b.insert(32);
		  b.insert(17);

		  b.printTree();
		  
		  
	}
	
	
	
}
