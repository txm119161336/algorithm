import java.util.ArrayList;

public class TournamentSort {


public static void main(String[] args) {
		
		int[] arr = {9,7,4,5,2/*,3,6,1,8,55*/};
		
		TournamentSort s = new TournamentSort();
		s.Sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		//S//ystem.out.println(arr.);

		
		
		
		/// = LoserTree();
		/*ArrayList<Result> initResults = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			   
			initResults.add(new Result(arr[i]));
			    //leav
		}
		
		System.out.println(new LoserTree(initResults).getWinner());*/
	}
	
	
	private class Node//用node来存储竞赛排序过程中的节点，包括里面的数据和数据在数组中的ID
	{
		public int data;
		public int id;
		
		public Node()
		{
			
		}
		public Node(int _data, int _id)//
		{
			data = _data;
			id = _id;
		}
	}
	public void Adjust(Node[] data, int idx)//当去除最小元素以后，我们要调整数组
	{
		while(idx != 0)
		{
			if(idx % 2 == 1)//当前id是奇数，说明并列的是idx + 1, 父节点是 (idx-1)/2
			{
				if(data[idx].data < data[idx + 1].data)
				{
					data[(idx - 1)/2] = data[idx];
				}
				else
				{
					data[(idx-1)/2] = data[idx + 1];
				}
				idx = (idx - 1)/2;
			}
			else
			{
				if(data[idx-1].data < data[idx].data)
				{
					data[idx/2 - 1] = data[idx-1];
				}
				else
				{
					data[idx/2 - 1] = data[idx];
				}
				idx = (idx/2 - 1);
			}
		}
	}
	
	
	public void Sort(int[] data)
	{
		int nNodes = 1;
		int nTreeSize;
		while(nNodes < data.length)
		{
			nNodes *= 2;
		}
		nTreeSize = 2 * nNodes - 1;//竞赛树节点的个数, nNode算出来是为了做成满二叉树
		
		Node[] nodes = new Node[nTreeSize];//竞赛树用数组存储
		//initialize the data
		
		int i, j;
		int idx;
		for( i = nNodes - 1; i < nTreeSize; i++) //初始化竞赛树数据
		{
			idx = i - (nNodes - 1);
			if(idx < data.length)
			{
				nodes[i] = new Node(data[idx], i);
			}
			else
			{
			    nodes[i] = new Node(Integer.MAX_VALUE, -1);//对于补充的数据，我们初始化成最大。
			}
			
		}
		
		for( i = nNodes - 2; i >= 0; i--)//
		{
			nodes[i] = new Node();
			if(nodes[i * 2 + 1].data < nodes[i * 2 + 2].data)
			{
				nodes[i] = nodes[i*2 + 1];
			}
			else
			{
				nodes[i] = nodes[i*2 + 2];
			}
		}
		//the real sorting procedure
		for( i = 0; i < data.length; i++)//实际排序的过程
		{
			data[i] = nodes[0].data;//取出最小的
			nodes[nodes[0].id].data = Integer.MAX_VALUE;
			Adjust(nodes, nodes[0].id);
			
		}
		
		
		
	}
}
