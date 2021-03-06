package fr.synapsegaming.stats.controller;

import org.junit.Test;

import fr.synapsegaming.commons.controller.AbstractControllerTest;

public class StatsControllerTest extends AbstractControllerTest {
	
	private static final String GET_HTTP_METHOD = "GET";
	private static final String STATS_VIEW_NAME = "Stats";
	private static final String STATS_ROUTE = "/stats";
	
	@Test
	public void testStatsRoute() throws Exception {
		testRoute(STATS_ROUTE, STATS_VIEW_NAME, GET_HTTP_METHOD);
	}
}