

public class BinaryTree {
 
 int data;      //根节点数据
 BinaryTree left;    //左子树
 BinaryTree right;   //右子树
 
 public BinaryTree(int data)    //实例化二叉树类
 {
  this.data = data;
  left = null;
  right = null;
 }
 
 public void insert(BinaryTree root,int data){     //向二叉树中插入子节点
  if(data>root.data)                               //二叉树的左节点都比根节点小
  {
   if(root.right==null){
    root.right = new BinaryTree(data);
   }else{
    this.insert(root.right, data);
   }
  }else{                                          //二叉树的右节点都比根节点大
   if(root.left==null){
    root.left = new BinaryTree(data);
   }else{
    this.insert(root.left, data);
   }
  }
 }
 
 public static void preOrder(BinaryTree root){  //先根遍历
	  if(root!=null){
	   System.out.print(root.data+"-");
	   preOrder(root.left);
	   preOrder(root.right);
	  }
	 }
 
 public static void main(String[] str){
	  int[] array = {12,76,35,22,16,48,90,46,9,40};
	  BinaryTree root = new BinaryTree(array[0]);   //创建二叉树
	  for(int i=1;i<array.length;i++){
	   root.insert(root, array[i]);       //向二叉树中插入数据
	  }
	  System.out.println("先根遍历：");
	  preOrder(root);
	 /* System.out.println();
	  System.out.println("中根遍历：");
	  inOrder(root);
	  System.out.println();
	  System.out.println("后根遍历：");
	  postOrder(root);*/
 
 }
 
 

}