package com.pinganfu.test.tree.tree234;
class Node
{
private static final int ORDER = 4;
private int numItems;//�ڵ���ʵ�ʴ洢����������Ŀ����ֵһ��������3
private Node parent;
private Node childArray[] = new Node[ORDER];//�ӽڵ�����
private DataItem itemArray[] = new DataItem[ORDER-1];//�洢����������
//-------------------------------------------------------------
// �Ѳ����еĽڵ���Ϊ�ӽڵ㣬�뵱ǰ�ڵ��������
public void connectChild(int childNum, Node child)
   {
   childArray[childNum] = child;
   if(child != null)
      child.parent = this;//��ǰ�ڵ���Ϊ���ڵ�
   }
//-------------------------------------------------------------
// �Ͽ�����ȷ���Ľڵ��뵱ǰ�ڵ�����ӣ�����ڵ�һ���ǵ�ǰ�ڵ���ӽڵ㡣
public Node disconnectChild(int childNum)
   {
   Node tempNode = childArray[childNum];
   childArray[childNum] = null; //�Ͽ�����
   return tempNode;//����Ҫ����ӽڵ�
   }
//-------------------------------------------------------------
public Node getChild(int childNum)//��ȡ��Ӧ���ӽڵ�
   { return childArray[childNum]; }
//-------------------------------------------------------------
public Node getParent()//��ȡ���ڵ�
   { return parent; }
//-------------------------------------------------------------
public boolean isLeaf()//�Ƿ���Ҷ���
   { return (childArray[0]==null) ? true : false; }//Ҷ���û���ӽڵ�
//-------------------------------------------------------------
public int getNumItems()//��ȡʵ�ʴ洢����������Ŀ
  { return numItems; }
//-------------------------------------------------------------
public DataItem getItem(int index)   // ��ȡ�����������
   { return itemArray[index]; }
//-------------------------------------------------------------
public boolean isFull()//�ýڵ��Ƿ�����
   { return (numItems==ORDER-1) ? true : false; }
//-------------------------------------------------------------
public int findItem(long key)       // ����
   {                                    
   for(int j=0; j<ORDER-1; j++)         // ��������
      {                                 
      if(itemArray[j] == null)          // ����δ����δ�ҵ�
         break;
      else if(itemArray[j].dData == key)
         return j;
      }
   return -1;
   }  // end findItem
//-------------------------------------------------------------
public int insertItem(DataItem newItem)//�ڵ�δ���Ĳ���
   {
   numItems++;                          
   long newKey = newItem.dData;         // ��ùؼ���

   for(int j=ORDER-2; j>=0; j--)        // ��Ϊ�ڵ�δ�������Դӵ����ڶ�����ǰ����
      {                              
      if(itemArray[j] == null)          // û������
         continue;                      
      else                              
         {                              
         long itsKey = itemArray[j].dData;//��ùؼ���
         if(newKey < itsKey)            //����λ������ǰ�棬��δ������
            itemArray[j+1] = itemArray[j]; //��ǰ���������
         else
            {
            itemArray[j+1] = newItem;   // �����λ�ò���
            return j+1;                 // ���ز����λ���±�
            }                           //    new item
         }  // end else (not null)
      }  // end for                     // shifted all items,
   //����������û��ִ�з��ز�������ô���ǿսڵ㣨ֻ�г�ʼʱ������������
   itemArray[0] = newItem;              // insert new item
   return 0;
   }  // end insertItem()
//-------------------------------------------------------------
public DataItem removeItem()        // �Ƴ�������Ӻ���ǰ�Ƴ�
   {
   // ����ڵ�ǿ�
   DataItem temp = itemArray[numItems-1];  // Ҫ�Ƴ���������
   itemArray[numItems-1] = null;           // �Ƴ�
   numItems--;                             // ��������Ŀ��һ
   return temp;                            // ����Ҫ�Ƴ���������
   }
//-------------------------------------------------------------
public void displayNode()           // format "/24/56/74/"
   {
   for(int j=0; j<numItems; j++)
      itemArray[j].displayItem();   // "/56"
   System.out.println("/");         // final "/"
   }
//-------------------------------------------------------------
}  // end class Node
////////////////////////////////////////////////////////////////