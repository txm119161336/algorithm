package com.pinganfu.test.dp;


public class BinaryTree {
 
 int data;      //���ڵ�����
 BinaryTree left;    //������
 BinaryTree right;   //������
 
 public BinaryTree(int data)    //ʵ������������
 {
  this.data = data;
  left = null;
  right = null;
 }
 
 public void insert(BinaryTree root,int data){     //��������в����ӽڵ�
  if(data>root.data)                               //����������ڵ㶼�ȸ��ڵ�С
  {
   if(root.right==null){
    root.right = new BinaryTree(data);
   }else{
    this.insert(root.right, data);
   }
  }else{                                          //���������ҽڵ㶼�ȸ��ڵ��
   if(root.left==null){
    root.left = new BinaryTree(data);
   }else{
    this.insert(root.left, data);
   }
  }
 }
 
 public static void preOrder(BinaryTree root){  //�ȸ�����
	  if(root!=null){
	   System.out.print(root.data+"-");
	   preOrder(root.left);
	   preOrder(root.right);
	  }
	 }
 
 public static void main(String[] str){
	  int[] array = {12,76,35,22,16,48,90,46,9,40};
	  BinaryTree root = new BinaryTree(array[0]);   //����������
	  for(int i=1;i<array.length;i++){
	   root.insert(root, array[i]);       //��������в�������
	  }
	  System.out.println("�ȸ�������");
	  preOrder(root);
	 /* System.out.println();
	  System.out.println("�и�������");
	  inOrder(root);
	  System.out.println();
	  System.out.println("���������");
	  postOrder(root);*/
 
 }
 
 

}