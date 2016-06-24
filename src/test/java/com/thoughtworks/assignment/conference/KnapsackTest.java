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
	public void testKnapsackExpect220() {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;

		boolean[] expected = { false, true, true, false };

		assertThat(Knapsack.solve(W, wt, val, n), equalTo(expected));
	}
}
