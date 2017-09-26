package com.pinganfu.test.dp;
/*
public class TestCoins {
  
	
	public static void main(String[] args) {
		int coinVaule = 9;
		int[] coins = {0,1,3,5};
		int[][] min = new int[coins.length][coinVaule+1];
		
		for(int i = 1 ; i < coins.length ;i++ )
			for (int j = 1; j <= coinVaule; j++) {
				if(j < coins[i])
					min[i][j] = min[i - 1][j];
				else {
					if(j % coins[i] == 0)
					   min[i][j]=j/coins[i];
					else
					   min[i][j]= j/coins[i] + min[i-1][j%coins[i]];
				}
			}
		
		for(int i = 1 ; i < coins.length ;i++ )
			for (int j = 1; j <= coinVaule; j++) {
				System.out.println("i : "+ i + " j : " + j + "  max value : " + min[i][j]);

        }
		
		
	}
	
	
	
}
*/