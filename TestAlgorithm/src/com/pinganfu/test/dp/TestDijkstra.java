package com.pinganfu.test.dp;
import java.util.List;

public class TestDijkstra {

	public static int INF = 999999;

	
	//List U = new ArrayList() {"B","C","D","E","F"};
	
	//String[] s = new String[];
	//int[]
	
	
	
	public static void main(String[] args) {

		// System.out.println(caculateF(10));
		System.out.println(caculateShortPath(10, 1, 3, 5));

	}

	private static double caculateShortPath(int n, int from, int to, int t) {

		int[][] map = new int[11][11];
		int[][][] dist = new int[11][11][11];

		int i, j, k;
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				map[i][j] = (i == j) ? 0 : INF;
        
		int startPoint = 1;
		map[1][2] = 6;
		map[1][3] = 3;
		map[2][4] = 5;
		map[3][2] = 2;
		map[3][4] = 3;
		map[3][5] = 4;
		map[4][5] = 2;
		map[4][6] = 3;
		map[5][6] = 5;
        
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++) {
				/*if (map[i][j] != INF && map[i][j] != 0) {
                      map[startPoint][j]
				}*/
			}

		return 0;

	}

}
