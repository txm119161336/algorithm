/*
  ResultSet.java     0.0.1 2013/04/04 
 * Copyright(C) 2013 db-iir RUC. All rights reserved. 
 */
import java.util.ArrayList;
import java.util.List;

/** 
 * This Class implements the loser tree algorithm.
 * 
 * @author  Hank Bian (bianhaoqiong@163.com)
 * @version 0.0.1, 2013/04/04
 */
public class LoserTree
{
	private int[] tree = null;// 以顺序存储方式保存所有非叶子结点
	private int size = 0;
	private ArrayList<Result> leaves = null;// 叶子节点

	
	public static void main(String[] args) {
		
		/*int[] arr = {9,7,4,5,2,3,6,1};
		/// = LoserTree();
		ArrayList<Result> initResults = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			   
			initResults.add(new Result(arr[i]));
			    //leav
		}
		
		System.out.println(new LoserTree(initResults).getWinner());*/
		
		int[] arr = {7,1,4,9,2,3,5,6};
		/// = LoserTree();
		//ArrayList<ListNode> initResults = new ArrayList();
		ArrayList<Result> initResults = new ArrayList();
		//initResults.iterator();
		//istNode[] initResults = new ListNode[15] ;

	/*	for (int i = 0; i <=6; i++) {
			//initResults[i]= new ListNode(0);
			    //leav
			initResults.add(new Result(Integer.MAX_VALUE));
		}*/
		
		
		for (int i = 0; i < arr.length; i++) {
			   
			//initResults[i]= new ListNode(arr[i]);
			    //leav
			initResults.add(new Result(arr[i]));

		}
		
		LoserTree l = new LoserTree(initResults);
		System.out.println(l.getWinner());
		//System.out.println(l.tree[l.getWinner()]);

		
		//l.mergeKLists(initResults);
		
		/*for(ListNode n :initResults) {
			System.out.println(n.val);
		}*/
		
	}
	
	
	
	
	
	
	
	
	
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		if (k == 0)
			return null;

		int finishCount = 0;

		int[] index_stack = new int[2 * k - 1];
		int[] shengli = new int[2 * k - 1];
		for (int i = 0; i < k; i++) {
			index_stack[i + k - 1] = i;
			shengli[i + k - 1] = i;
			if (lists[i] == null) {
				lists[i] = new ListNode(Integer.MAX_VALUE);
				finishCount = finishCount + 1;
			}
		}
		for (int i = k - 2; i >= 0; i--) {
			if (lists[shengli[2 * i + 1]].val > lists[shengli[2 * i + 2]].val) {
				index_stack[i] = shengli[2 * i + 1];
				shengli[i] = shengli[2 * i + 2];
			} else {
				index_stack[i] = shengli[2 * i + 2];
				shengli[i] = shengli[2 * i + 1];
			}
		}

		ListNode head = new ListNode(0);
		ListNode snode = head;
		int currentGet = shengli[0];
		while (finishCount < lists.length) {
			snode.next = lists[currentGet];
			snode = snode.next;
			lists[currentGet] = lists[currentGet].next;
			if (lists[currentGet] == null) {
				lists[currentGet] = new ListNode(Integer.MAX_VALUE);
				finishCount = finishCount + 1;
			}
			int lastPosition = k - 1 + currentGet;
			int cPosition = (lastPosition - 1) / 2;
			while (lastPosition != 0) {
				if (lists[index_stack[cPosition]].val < lists[currentGet].val) {
					int tmp = currentGet;
					currentGet = index_stack[cPosition];
					index_stack[cPosition] = tmp;
				}
				lastPosition = cPosition;
				cPosition = (cPosition - 1) / 2;
			}
		}
		return head.next;
	}
	
	
/*	public LoserTree()
	{
		
	}*/
	
	
	public LoserTree(ArrayList<Result> initResults)
	{
		this.leaves = initResults;
		this.size = initResults.size();
		this.tree = new int[size];
		for (int i = 0; i < size; ++i)
		{
			tree[i] = -1;
		}
		for (int i = size - 1; i >= 0; --i)
		{
			adjust(i);
		}
	}

	public void del(int s)
	{
		leaves.remove(s);
		size--;
		tree = new int[size];
		for (int i = 0; i < size; ++i)
		{
			tree[i] = -1;
		}
		for (int i = size - 1; i >= 0; --i)
		{
			adjust(i);
		}
	}

	public void add(Result leaf, int s)
	{
		leaves.set(s, leaf);// 调整叶子结点
		adjust(s);// 调整非叶子结点
	}

	public Result getLeaf(int i)
	{
		return leaves.get(i);
	}

	public int getWinner()
	{
		return tree[0];
	}

	private void adjust(int s)
	{
		// s指向当前的值最小的叶子结点（胜者）
		int t = (s + size) / 2;// t是s的双亲

		while (t > 0)
		{
			if (s >= 0
					&& (tree[t] == -1 || leaves.get(s).compareTo(
							leaves.get(tree[t])) > 0))
			{
				// 将树中的当前结点指向其子树中值最小的叶子
				int tmp = s;
				s = tree[t];
				tree[t] = tmp;
			}
			t /= 2;
		}
		tree[0] = s;// 树根指向胜者
	}
}
