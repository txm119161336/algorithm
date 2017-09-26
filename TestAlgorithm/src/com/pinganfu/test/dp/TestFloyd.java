package com.pinganfu.test.dp;

public class TestFloyd {

	public static int INF = 999999;

	public static void main(String[] args) {
    
		// System.out.println(caculateF(10));
		System.out.println(caculateShortPath(10,1,3,5));                    

	}

	private static double caculateShortPath(int n,int from ,int to,int t) { 

		int[][] map = new int[11][11];
		int[][][] dist = new int[11][11][11];

		int i, j, k;
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				map[i][j] = (i == j) ? 0 : INF;

		map[1][2] = 2;
		map[1][4] = 20;
		map[2][5] = 1;
		map[3][1] = 3;
		map[4][3] = 8;
		map[4][6] = 6;
		map[4][7] = 4;
		map[5][3] = 7;
		map[5][8] = 3;
		map[6][3] = 1;
		map[7][8] = 1;
		map[8][6] = 2;
		map[8][10] = 2;
		map[9][7] = 2;
		map[10][9] = 1;

		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				dist[i][j][0] = map[i][j];
		
		for (k = 1; k <= n; k++)
			for (i = 1; i <= n; i++)
				for (j = 1; j <= n; j++) {
					dist[i][j][k] = dist[i][j][k - 1];
					if (dist[i][k][k - 1] + dist[k][j][k - 1] < dist[i][j][k])
						dist[i][j][k] = dist[i][k][k - 1] + dist[k][j][k - 1];
				}
		
		/*return map[from][to];*/
		return dist[from][to][t];

	}

	private static double caculateF(int n) {

		double[] a = new double[n];
		a[0] = 0;
		a[1] = 1;
		for (int i = 2; i < n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}

		return a[n - 1];

	}

}
