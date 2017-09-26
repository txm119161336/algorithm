
public class InsertSort {
	
    public static void main(String[] args) {
    	for(int i : insertSort(new int[] {8,7,3,5,7,6,2,9}))
		     System.out.println(i);
	}
    
    public static int[] insertSort(int[] arr)
    {
        int i, j;
        int n = arr.length;
        int target;
     
        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++)
        {
            j = i;
            target = arr[i];
     
            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }
     
            arr[j] = target;
        }
        
        return arr;
        
        
    }
}
