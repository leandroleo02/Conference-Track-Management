package com.thoughtworks.assignment.conference;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.assignment.conference.model.Talk;
import com.thoughtworks.assignment.conference.model.TalkSession;

public class KnapsackTest {

	@Test
	public void testKnapsack() {
		int val[] = new int[] {0, 60, 100, 120 };
		int wt[] = new int[] {0, 10, 20, 30 };
		int W = 50;
		int n = val.length - 1;

		int[] expected = { 3, 2 };

		assertThat(Knapsack.knapsack(W, wt, val, n), equalTo(expected));
	}
	
	@Test
	public void testSmallKnapsack1() {
		int val[] = new int[] {0, 2, 3, 4 };
		int wt[] = new int[] {0, 2, 3, 4 };
		int W = 5;
		int n = val.length - 1;

		int[] expected = { 2, 1 };

		assertThat(Knapsack.knapsack(W, wt, val, n), equalTo(expected));
	}
	
	@Test
	public void testSmallKnapsack() {
		int val[] = new int[] {2, 3, 4 };
		int wt[] = new int[] {2, 3, 4 };
		int W = 5;
		int n = val.length;

		// int[] expected = { 2, 1 };
		int expected = 5;

		assertThat(knapSack(W, wt, val, n), equalTo(expected));
	}
	
	private int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		
		for(int kk = 0;kk<n + 1;kk++) {
			for(int j = 0;j<W + 1;j++) {
				System.out.print(K[kk][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

		return K[n][W];
	}
	
	@Test
	public void testKnapsack1Item() {
		int val[] = new int[] { 0, 60 };
		int wt[] = new int[] { 0, 60 };
		int W = 180;
		int n = val.length - 1;

		int[] expected = { 1 };

		assertThat(Knapsack.knapsack(W, wt, val, n), equalTo(expected));
	}
	
	@Test
	public void testKnapsackSolve() {
		LocalTime start = LocalTime.of(9, 0);
		LocalTime finish = LocalTime.of(12, 0);
		TalkSession session = new TalkSession(start, finish);

		Talk talk1 = new Talk("Any talk", 60);
		Talk talk2 = new Talk("Another talk", 120);

		List<Talk> originalTalks = new ArrayList<>(Arrays.asList(talk1, talk2));
		
		List<Talk> talks = Knapsack.solve(session, originalTalks);
		
		assertThat("Scheduled talks list should have 2 items", talks.size(), equalTo(2));
	}
}
