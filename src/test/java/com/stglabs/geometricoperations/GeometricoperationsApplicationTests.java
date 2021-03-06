package com.stglabs.geometricoperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stglabs.geometricoperations.models.Line;
import com.stglabs.geometricoperations.models.Point;
import com.stglabs.geometricoperations.service.GeometricOperationsService;

@SpringBootTest
class GeometricoperationsApplicationTests {

	@Autowired
    GeometricOperationsService service;

	@Test
	public void testGetYIntercept() {
		Line line = new Line(new Point("3", "9"), new Point("2", "7"));
		Double response = service.getYIntercept(line);
		assertEquals(3, response,"The response data does not match");
	}

	@Test
	public void testCalculateDistance() {
		Line line = new Line(new Point("3", "4"), new Point("7", "1"));
		double distance = service.calculateDistanceByTwoPoint(line);
		assertEquals(distance, 5, 0.001);
	}

	@Test
	void testParallel() {
		String check = service.parallelism(new Line(new Point("44", "8"), new Point("4", "123")),
				new Line(new Point("2", "4"), new Point("2", "6")));
		assertEquals("lines are not parallel", check);
	}

	@Test
	void testPerpendicular() {
		String check = service.perpendicularity(new Line(new Point("1", "1"), new Point("6", "6")),
				new Line(new Point("1", "1"), new Point("6", "-4")));
		assertEquals("lines are perpendicular", check);
	}

	@Test
	void testIntersection() {
		String check = service.incidence(new Line(new Point("1", "1"), new Point("4", "4")),
				new Line(new Point("1", "8"), new Point("2", "4")));
		assertEquals("Lines intersect at(2.4,2.4)", check);
	}

}
