package com.pinganfu.test.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = new int[] { 8, 7, 3, 5, 7, 6, 2, 9 };
		int min = 0;
		int x = 0;
		for (int i = 0; i < array.length; i++) {
			min = i;
             x++;
			for (int j = i + 1; j < array.length; j++) {
				x++;
				if (array[j] < array[min])
					min = j;
			}

			swap(array, i, min);
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");

		}

		
		System.out.print("    "+  x);

		
		
	}

	private static void swap(int[] array, int i, int min) {
		int temp = array[i];
		array[i] = array[min];
		array[min] = temp;
	}

}
