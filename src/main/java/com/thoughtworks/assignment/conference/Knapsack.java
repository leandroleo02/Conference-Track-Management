package com.thoughtworks.assignment.conference;


/**
 * Knapsack algorithm limited 0/1 implementation.
 */
public class Knapsack {

	/**
	 * Using the Knapsack algorithm, get the the maximum value that can be put in a knapsack of capacity W, and returns the elements that were put in the bag.
	 *
	 * @param W
	 * @param weight
	 * @param values
	 * @param N
	 * @return
	 */
	public static boolean[] solve(int W, int weight[], int values[], int N) {
		int i, w;
		int[][] K = new int[N + 1][W + 1];
		boolean[][] flagTakenElments = new boolean[N + 1][W + 1];

		for (i = 1; i <= N; i++) {
			for (w = 1; w <= W; w++) {
				if (weight[i - 1] <= w) {
					K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
				} else {
					K[i][w] = K[i - 1][w];
				}
				flagTakenElments[i][w] = K[i][w] > K[i - 1][w];
			}
		}
		return getTakenElements(flagTakenElments, weight, W, N);
	}

	/**
	 * Find out the elements that were put in the bag.
	 *
	 * @param flagTakenElments
	 * @param weight
	 * @param W
	 * @param N
	 * @return
	 */
	private static boolean[] getTakenElements(boolean[][] flagTakenElments, int weight[], int W, int N) {
		boolean[] take = new boolean[N + 1];
		for (int n = N - 1, w = W; n >= 0; n--) {
			if (flagTakenElments[n][w]) {
				take[n] = true;
				w = w - weight[n];
			} else {
				take[n] = false;
			}
		}
		return take;
	}
}