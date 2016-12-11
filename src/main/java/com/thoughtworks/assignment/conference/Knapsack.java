package com.thoughtworks.assignment.conference;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.thoughtworks.assignment.conference.model.Session;
import com.thoughtworks.assignment.conference.model.Talk;

/**
 * Knapsack algorithm limited 0/1 implementation.
 */
public class Knapsack {

	public static List<Talk> solve(Session session, List<Talk> talks) {
		int maxWeight = (int) Duration.between(session.getStart(), session.getFinish()).toMinutes();
		
		List<Talk> validTalks = getValidTalks(talks, maxWeight);
		int numItems = validTalks.size();

		int[] value = new int[numItems + 1];
		int[] weight = new int[numItems + 1];

		int i = 1;
		// fill the profit and weight
		for (Talk talk : validTalks) {
			value[i] = weight[i] = talk.getDuration();
			i++;
		}
		int[] elementsUsed = knapsack(maxWeight, weight, value, numItems);

		List<Talk> scheduleTalks = null;
		if (elementsUsed.length > 0) {
			scheduleTalks = new ArrayList<>();
			for (int index : elementsUsed) {
				Talk talk = validTalks.get(index - 1);
				scheduleTalks.add(talk);
			}
		}
		return scheduleTalks;
	}
	
	private static List<Talk> getValidTalks(List<Talk> talks, int maxWeight) {
		return talks.stream().filter(t -> t.getDuration() <= maxWeight).collect(Collectors.toList());
	}

	/**
	 * Using the Knapsack algorithm, get the the maximum value that can be put
	 * in a knapsack of capacity W, and returns the elements that were put in
	 * the bag.
	 * 
	 * https://cgi.csc.liv.ac.uk/~martin/teaching/comp202/Java/Knapsack-code.html
	 *
	 * @param maxWeight
	 * @param weight
	 * @param values
	 * @param numItems
	 * @return
	 */
	public static int[] knapsack(int maxWeight, int weight[], int values[], int numItems) {
		int[][] knapsack = new int[numItems + 1][maxWeight + 1];

		for (int k = 1; k <= numItems; k++) {
			// System.out.println(maxWeight + " >= " + weight[k]);
			for (int w = maxWeight; w >= weight[k]; w--) {
				// System.out.println("values[k] + knapsack[k - 1][w - weight[k]] > knapsack[k - 1][w] = " + values[k] + knapsack[k - 1][w - weight[k]] + " > " + knapsack[k - 1][w]);
				if (values[k] + knapsack[k - 1][w - weight[k]] > knapsack[k - 1][w])
					knapsack[k][w] = values[k] + knapsack[k - 1][w - weight[k]];
				else
					knapsack[k][w] = knapsack[k - 1][w];
			}
			for (int w = 0; w < weight[k]; w++) {
				knapsack[k][w] = knapsack[k - 1][w];
			}
		}
		
		return getUsedItems(knapsack, weight, values, numItems, maxWeight);
	}

	private static int[] getUsedItems(int[][] knapsack, int weight[], int values[], int numItems, int maxWeight) {
		List<Integer> list = new ArrayList<>();
		for (int k = numItems, remainingWeight = maxWeight; k > 0; k--) {
			if (remainingWeight >= weight[k]) {
				if (knapsack[k][remainingWeight] == (values[k] + knapsack[k - 1][remainingWeight - weight[k]])) {
					// System.out.print(" " + k);
					list.add(k);
					remainingWeight -= weight[k];
				}
			}
		}
		// use mapToInt to create a dynamic array
		return list.stream().mapToInt(i -> i).toArray();
	}
}