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
	 * �ڲ���ʵ�ֽ���࣬����߰�ȫ��
	 * 
	 * @author nishiting
	 * 
	 */

	private static class Node {
		Node left;//����
		Node right;//�Һ���
		Node middle;//�м���
		int keyAmount;//��ֵ��
		int data[];//��ֵ
		int size=0;//���㵱ǰ�Ľ�ֵ��
		
		/**
		 * ��ʼ�����
		 * @param newData ��ֵ
		 * @param keyAmount	�����
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
		 * ��Ӽ�ֵ������position��λ����λ
		 * @param newData	��ֵ
		 * @param position	λ��
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
	 * ����һ���յĶ�����
	 */

	public BinaryTree(int keyAmount) {
		root = null;
		this.keyAmount = keyAmount;
	}

	/**
	 * �ݹ�Ĳ�����ֵ
	 * 
	 * @param data
	 *            Ҫ�������ֵ
	 */

	public void insert(int data) {
		root = insert(root, data);
		
		System.out.println("-------"+data+"����"+"------------------");
	}

	/**
	 * ����ֵ���뵽�������У��ȵ�ǰ���С����ڵ�ǰ���Ĳ��ڵ�ǰ������࣬�ȵ�ǰ����������ڵ�ǰ�����Ҳ࣬ÿ�δӸ���㿪ʼ�ݹ�Ƚ�
	 * 
	 * @param node
	 *            ��ǰ�Ľ�㣬���Ǹ���㣬ֻ��ÿ�θ����������������
	 * @param data
	 *            Ҫ�������ֵ
	 * @return ���źõĶ�����
	 */

	private Node insert(Node node, int data) {

		if (node == null) {

			node = new Node(data, keyAmount);

		} else {

			if (isFull(node)) {
				for (int i = 0; i < node.size; i++) {

					if (data <= node.data[i]) {
						System.out.println("����������");
						node.left = insert(node.left, data);
						
						return node;
					} else {
						if (data <= node.data[i + 1]) {
							System.out.println("�����м���");
							node.middle = insert(node.middle, data);
							
							return node;
						} else {
							System.out.println("����������");
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
	 * �жϽ���Ƿ��п��пռ�
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
	 * ����ֵ���빹��������
	 * 
	 * @param data
	 *            Ҫ�������ֵ
	 */

	public void buildTree(int[] data) {

		for (int i = 0; i < data.length; i++) {

			insert(data[i]);

		}

	}

	/**
	 * �ݹ��ӡ��������
	 */

	public void printTree() {

		printTree(root);

		System.out.println();

	}

	/**
	 * �Ӹ���㿪ʼ��������������߲�Ҷ�ӽ�㿪ʼ�������������,���û���м�ָ��Ļ��Ƚ������������
	 * 
	 * @param node
	 *            ��ǰ�Ľ��
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
