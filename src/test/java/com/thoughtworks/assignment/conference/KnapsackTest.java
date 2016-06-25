package com.thoughtworks.assignment.conference;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {

	@Before
	public void setUp() throws Exception {
	}

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
	public void testKnapsack1Item() {
		int val[] = new int[] { 0, 60 };
		int wt[] = new int[] { 0, 60 };
		int W = 180;
		int n = val.length - 1;

		int[] expected = { 1 };

		assertThat(Knapsack.knapsack(W, wt, val, n), equalTo(expected));
	}
}
