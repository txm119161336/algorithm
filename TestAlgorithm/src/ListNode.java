public  class ListNode//用node来存储竞赛排序过程中的节点，包括里面的数据和数据在数组中的ID
	{
		public int data;
		public int id;
		public int val;
		public ListNode next;
		
		public ListNode(int _data)//
		{
			val = _data;
			//id = _id;
		}
	}