
public class TestKnapSack {

	public static void main(String[] args) {

		int knapsackWeight = 14;

		GoodItem[] goods = { new GoodItem(0, 0), new GoodItem(1, 5), new GoodItem(3, 9), new GoodItem(7, 4),
				new GoodItem(3, 8) };

		int[][] maxValue = new int[goods.length][knapsackWeight + 1];
		// maxValue[3][2]= 44;
		System.out.println("ff : " + (goods.length - 1) + "  k w :" + knapsackWeight);

		for (int i = 1; i < goods.length; i++)
			for (int j = 1; j <= knapsackWeight; j++) {
				if(i == 1) {
					if (goods[i].weight <= j) {
						maxValue[i][j] = goods[i].value;
					}else {
						maxValue[i][j] = 0; 
					}
				}
				else {
				   //if (goods[i].weight < j) {
					System.out.println("e : " + i + "  w :" + j);
                    if(j - goods[i].weight > 0) {
                    	if(j==14 && i==4)
	                    	System.out.println("tt : " + maxValue[i - 1][j] + "next : "+ (maxValue[i - 1][j - goods[i].weight] + goods[i].value));

					     maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i - 1][j - goods[i].weight] + goods[i].value);
	                    	System.out.println("value : " + maxValue[i][j]);
	                    	
                    }else
                    	maxValue[i][j] = maxValue[i - 1][j];
				}
				/*} else {
					System.out.println("0  e : " + i + "  w :" + j);

					maxValue[i][j] = 0;
				}*/
			}
		
		for (int i = 1; i < goods.length; i++)
			for (int j = 1; j <= knapsackWeight; j++) { 
				System.out.println("i : "+ i + " j : " + j + "  max value : " + maxValue[i][j]);

        }
		//System.out.println("ff : " + maxValue[goods.length - 1][knapsackWeight]);

	}

	public static class GoodItem {

		private int weight;
		private int value;

		public GoodItem(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}
