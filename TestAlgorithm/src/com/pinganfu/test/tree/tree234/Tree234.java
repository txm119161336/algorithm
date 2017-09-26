package com.pinganfu.test.tree.tree234;
class Tree234
{
private Node root = new Node();            // �������ĸ�
//-------------------------------------------------------------
//��ȡ���ҵ���һ���ڵ�
public Node getNextChild(Node theNode, long theValue)
{
int j;
// ��������ڵ㲻��Ҷ���
int numItems = theNode.getNumItems();//��õ�ǰ�ڵ����������Ŀ
for(j=0; j<numItems; j++)          
   {                             
   if( theValue < theNode.getItem(j).dData )
      return theNode.getChild(j);  // ������Ӧ�Ľڵ�
   }  // end for                   
return theNode.getChild(j);        // ��ʱj=numItems
}
//-------------------------------------------------------------
public int find(long key)
   {
   Node curNode = root;
   int childNumber;
   while(true)
      {
      if(( childNumber=curNode.findItem(key) ) != -1)//ÿ��ѭ�����һ��ִ��
         return childNumber;               // found it
      else if( curNode.isLeaf() )//Ҷ�����Ҳû�ҵ�
         return -1;                        // can't find it
      else                                 // ����Ҷ��㣬��������²���
         curNode = getNextChild(curNode, key);
      }  // end while
   }
//-------------------------------------------------------------
// ����������
public void insert(long dValue)
   {
   Node curNode = root;//��ǰ�ڵ��־
   DataItem tempItem = new DataItem(dValue);//�����������װ

   while(true)
      {
      if( curNode.isFull() )               // �����ڵ�
         {
         split(curNode);                   // ����
         curNode = curNode.getParent();    // �ص����ѳ��ĸ��ڵ���
                                           // �������²���
         curNode = getNextChild(curNode, dValue);
         }  // end if(node is full)
//����Ĳ����нڵ㶼δ����������ִ������Ĵ���
      else if( curNode.isLeaf() )          // ��Ҷ��㣬����
         break;                            // ������ֱ�Ӳ���
   
      else
         curNode = getNextChild(curNode, dValue);//���²���
      }  // end while

   curNode.insertItem(tempItem);       // ��ʱ�ڵ�һ��������ֱ�Ӳ��������
   }  // end insert()
//-------------------------------------------------------------
public void split(Node thisNode)     // ����
   {
   // �����нڵ�һ�������ڵ㣬���򲻻�ִ�иò���
   DataItem itemB, itemC;
   Node parent, child2, child3;
   int itemIndex;

   itemC = thisNode.removeItem();    // �Ƴ����ұߵ����������������ΪB��C
   itemB = thisNode.removeItem();    // 
   child2 = thisNode.disconnectChild(2); // //�Ͽ����ұ������ӽڵ������
   child3 = thisNode.disconnectChild(3); // 

   Node newRight = new Node();       //�½�һ���ڵ㣬��Ϊ��ǰ�ڵ���ֵܽڵ�

   if(thisNode==root)                // �Ǹ�
      {
      root = new Node();                // �½�һ����
      parent = root;                    // ���¸���Ϊ���ڵ�
      root.connectChild(0, thisNode);   // ���Ӹ��ڵ���ӽڵ�
      }
   else                              // ���Ǹ�
      parent = thisNode.getParent();    // ��ȡ���ڵ�

  
   itemIndex = parent.insertItem(itemB); // ��B���븸�ڵ��У����ز���λ��
   int n = parent.getNumItems();         // �������������Ŀ

   for(int j=n-1; j>itemIndex; j--)          //�Ӻ���ǰ�Ƴ�
      {                                    
      Node temp = parent.disconnectChild(j); // �Ͽ�����
      parent.connectChild(j+1, temp);        // ���ӵ��µ�λ��
      }
                           
   parent.connectChild(itemIndex+1, newRight);//���ӵ���λ��

   // �����ֵܽڵ�
   newRight.insertItem(itemC);       // ��C�����ֵܽڵ���
   newRight.connectChild(0, child2); // ���ӽڵ������ұߵ��������ӵ��ֵܽڵ���
   newRight.connectChild(1, child3); //
   }  // end split()
//-------------------------------------------------------------
// gets appropriate child of node during search for value

public void displayTree()
   {
   recDisplayTree(root, 0, 0);
   }
//-------------------------------------------------------------
private void recDisplayTree(Node thisNode, int level,
                                           int childNumber)
   {
   System.out.print("level="+level+" child="+childNumber+" ");
   thisNode.displayNode();               // display this node

   // call ourselves for each child of this node
   int numItems = thisNode.getNumItems();
   for(int j=0; j<numItems+1; j++)
      {
      Node nextNode = thisNode.getChild(j);
      if(nextNode != null)
         recDisplayTree(nextNode, level+1, j);
      else
         return;
      }
   }  // end recDisplayTree()
//-------------------------------------------------------------\
}  // end class Tree234
////////////////////////////////////////////////////////////////