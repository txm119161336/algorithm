package com.pinganfu.test.tree.redblacktree2;
/**
 * Java ����: ���������
 *
 * @author skywang
 * @date 2013/11/07
 */
public class RBTreeTest {

    //private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    //private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};

   // private static final int a[] = {7, 8, 9, 10,11};
    private static final int a[] = {12,1,9,2,0,11,7,19,4,15,18,5,14,13,10,16,6,3,8,17};
	
    private static final boolean mDebugInsert = false;    // "����"�����ļ�⿪��(false���رգ�true����)
    private static final boolean mDebugDelete = false;    // "ɾ��"�����ļ�⿪��(false���رգ�true����)

    public static void main(String[] args) {
        int i, ilen = a.length;
        RBTree<Integer> tree = new RBTree<Integer>();

        System.out.printf("== ԭʼ����: ");
        for(i=0; i<ilen; i++)
        	tree.insert(a[i]);
           // System.out.printf("%d ", a[i]);
        //System.out.printf("\n");

        
       /* for(i=7; i<=100; i++) {
            tree.insert(i);
            // ����mDebugInsert=true,����"���Ӻ���"
            if (mDebugInsert) {
                System.out.printf("== ���ӽڵ�: %d\n", a[i]);
                System.out.printf("== ������ϸ��Ϣ: \n");
                tree.print();
                System.out.printf("\n");
            }
        }*/
        
        
        
        
       /* for(i=0; i<ilen; i++) {
            tree.insert(a[i]);
            // ����mDebugInsert=true,����"���Ӻ���"
            if (mDebugInsert) {
                System.out.printf("== ���ӽڵ�: %d\n", a[i]);
                System.out.printf("== ������ϸ��Ϣ: \n");
                tree.print();
                System.out.printf("\n");
            }
        }*/

       /* System.out.printf("== ǰ�����: ");
        tree.preOrder();

        System.out.printf("\n== �������: ");
        tree.inOrder();

        System.out.printf("\n== �������: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== ��Сֵ: %s\n", tree.minimum());
        System.out.printf("== ���ֵ: %s\n", tree.maximum());
        System.out.printf("== ������ϸ��Ϣ: \n");
        tree.print();
        System.out.printf("\n");

        // ����mDebugDelete=true,����"ɾ������"
        if (mDebugDelete) {
            for(i=0; i<ilen; i++)
            {
                tree.remove(a[i]);

                System.out.printf("== ɾ���ڵ�: %d\n", a[i]);
                System.out.printf("== ������ϸ��Ϣ: \n");
                tree.print();
                System.out.printf("\n");
            }
        }*/
        tree.print();
        // ���ٶ�����
        tree.clear();
    }
}