package com.pinganfu.test.tree.losertree.important;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
 
/**
 * ������,�Զ�����������Դ���й鲢����<br>
 * 
 * @author skyfalling
 * @param <T>
 */
public class LoserTree<T> {
    /**
     * ��Ҷ�ӽڵ�, ��¼����Դ������λ��, ���ݽڵ��ֵ���Զ�λ����ָ�������Դ
     */
    private int[] tree;
    /**
     * Ҷ�ӽڵ�, Ҷ�ӽڵ������Դ��һһ��Ӧ��, ����һ��Ҷ�ӽڵ��¼��һ������Դ�ĵ�ǰ����
     */
    private Object[] nodes;
    /**
     * ����Դ�б�,ΪҶ�ӽڵ��ṩ����, ����Դ�����˳����������Һ�Ԫ�صıȽϽ������һ��
     */
    private Iterator<T>[] branches;
    /**
     * Ҷ�ӽڵ����ݵıȽ϶���
     */
    private Comparator<T> comparator;
    
    public static void main(String[] args) {
    	//int[] arr = {7,1,4,9,2,3,5,6};
    	int[] arr = {7};
    	int[] arr1 = {1,2};
    	int[] arr2 = {4};
    	int[] arr3 = {6};
    	
    	int[] arr4 = {9};
    	int[] arr5 = {2};
    	int[] arr6 = {3};
    	int[] arr7 = {5};
    	
        
    	List l = new ArrayList();
    	//It = Arrays.asList(arr).iterator();
    	l.add(getList(arr));
    	l.add(getList(arr1));
    	l.add(getList(arr2));
    	l.add(getList(arr3));
    	l.add(getList(arr4));
    	l.add(getList(arr5));
    	l.add(getList(arr6));
    	l.add(getList(arr7));
    	
    	LoserTree loserTree = new LoserTree(l);
        
    	loserTree.top();
    	loserTree.pop();
		System.out.println("");

	}
    
    public static Iterator<Integer> getList(int[] arr) {
    	List l = new ArrayList();

    	//List<int[]> l  = Arrays.asList(arr);
    	for (int i = 0; i < arr.length; i++) {
    		l.add(arr[i]);
		}
    
        Iterator<Integer>	it = l.iterator();
        
        return it;
    }
    
    
    
    
    
    /**
     * ���췽��,����Ԫ�ص�Comparable�ӿ�ʵ�ֽ�������
     * 
     */
    public LoserTree(List<Iterator<T>> branches) {
        this(branches, new Comparator<T>() {
 
            @SuppressWarnings("unchecked")
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable<T>) o1).compareTo(o2);
            }
        });
    }
 
    /**
     * ���췽��, ָ������Դ��֧�ĵ�������Ԫ�رȽ϶���<br>
     * �����������������������Comparator����ıȽϽ������һ��
     * 
     * @param branches
     * @param comparator
     */
    @SuppressWarnings("unchecked")
    public LoserTree(List<Iterator<T>> branches, Comparator<T> comparator) {
        this.branches = branches.toArray(new Iterator[0]);
        this.comparator = comparator;
        this.init();
    }
 
    /**
     * ���ζ�ȡ����Դ�����ݽ��й鲢����, ���������������б�<br>
     * 
     * @return
     */
    public List<T> merge() {
        List<T> list = new ArrayList<T>();
        T top = null;
        while ((top = get(tree[0])) != null) {
            list.add(top);
            put(tree[0]);
            adjust(tree[0]);
        }
        return list;
    }
 
    /**
     * ��ȡ���Ƴ���ǰ�ھ��ڵ�<br>
     * 
     * @return
     */
    public T pop() {
        T result = get(tree[0]);
        if (result != null) {
            put(tree[0]);
            adjust(tree[0]);
        }
        return result;
    }
 
    /**
     * ��ȡ��ǰ�ھ��ڵ�<br>
     * 
     * @return
     */
    public T top() {
        return get(tree[0]);
    }
 
    /**
     * ��ʼ������������<br>
     */
    private void init() {
        int size = this.branches.length;
        this.tree = new int[size];
        this.nodes = new Object[size];
        // ΪҶ�ӽڵ㸳ֵ
        for (int i = 0; i < size; i++) {
            this.put(i);
        }
        int winner = 0;
        for (int i = 1; i < size; i++) {
            if (beat(i, winner)) {
                winner = i;
            }
        }
        // ��Ҷ�ӽڵ��ʼ��Ϊ�ھ��ڵ�
        Arrays.fill(tree, winner);
        // �Ӻ���ǰ���ε�����Ҷ�ӽڵ�
        for (int i = size - 1; i >= 0; i--)
            adjust(i);
    }
 
    /**
     * ������index��Ҷ�ӽڵ�<br>
     * �����������Ϊ: Ҷ�ӽڵ�͸��ڵ�Ƚ�, �������ڸ��ڵ�λ��, ʤ�߼����͸��ڵ�ĸ��ڵ�Ƚ�,ֱ���������ĸ��ڵ�
     * 
     * @param index
     */
    private void adjust(int index) {
        int size = this.branches.length;
        int t = (size + index) / 2;
        while (t > 0) {
            // �������ڸ��ڵ��λ��
            if (beat(tree[t], index)) {
                int temp = tree[t];
                tree[t] = index;
                index = temp;
            }
            t /= 2;
        }
        tree[0] = index;
    }
 
    /**
     * ��ȡ��index��Ҷ�ӽڵ�ĵ�ǰ����<br>
     * �������null,���ʾ����Դ����
     * 
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    private T get(int index) {
        return (T) nodes[index];
    }
 
    /**
     * ���õ�index��Ҷ�ӽڵ����һ������<br>
     * �������Դ�ѽ���,������Ϊnull
     * 
     * @param index
     */
    private void put(int index) {
        Iterator<T> branch = this.branches[index];
        this.nodes[index] = branch.hasNext() ? branch.next() : null;
    }
 
    /**
     * �ж�index1��Ӧ�Ľڵ��Ƿ��ܴ��index2��Ӧ�Ľڵ�
     * 
     * @param index1
     * @param index2
     * @return
     */
    private boolean beat(int index1, int index2) {
        T t1 = get(index1);
        T t2 = get(index2);
        if (t1 == null)
            return false;
        if (t2 == null)
            return true;
        // ����, ��Ҷ�ڵ��������ʱ�ȽϷ�֧������Ϊ��ʵ�������㷨���ȶ���
        int n = comparator.compare(t1, t2);
        return n != 0 ? n < 0 : index1 < index2;
    }
 
}