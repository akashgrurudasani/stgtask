package com.stglabs.geometricoperations.service.impl;

import com.stglabs.geometricoperations.models.Line;
import com.stglabs.geometricoperations.models.Point;
import com.stglabs.geometricoperations.service.GeometricOperationsService;

@org.springframework.stereotype.Service
public class GeometricOperationsServiceImpl implements GeometricOperationsService {

	public Double getYIntercept(Line line) {
		Double slope = getSlope(line);
		// Rule : y = mx + c , identify c.
		return getDoubleY(line.getP1()) - (slope * getDoubleX(line.getP1()));
	}

	public Double calculateDistanceByTwoPoint(Line line) {
		double x1 = getDoubleX(line.getP1());
		double y1 = getDoubleY(line.getP1());
		double x2 = getDoubleX(line.getP2());
		double y2 = getDoubleY(line.getP2());
		return Math.sqrt(((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1)));
	}

	public String parallelism(Line l1, Line l2) {
		Double slope1 = getSlope(l1);
		Double slope2 = getSlope(l2);
		if (slope1.equals(slope2))
			return "lines are parallel";
		else
			return "lines are not parallel";
	}

	public String perpendicularity(Line l1, Line l2) {
		if (parallelism(l1, l2).equals("lines are parallel"))
			return "lines are parallel";
		Double slope1 = getSlope(l1);
		Double slope2 = getSlope(l2);
		int perpendicular = (int) (slope1 * slope2);
		if (perpendicular == -1)
			return "lines are perpendicular";
		return "lines are not perpendicular";
	}

	public String incidence(Line l1, Line l2) {
		if (parallelism(l1, l2).equals("lines are parallel"))
			return "lines are parallel";

		double a1 = getDoubleY(l1.getP2()) - getDoubleY(l1.getP1());
		double b1 = getDoubleX(l1.getP1()) - getDoubleX(l1.getP2());
		double c1 = ((a1 * (getDoubleX(l1.getP1()))) + (b1 * (getDoubleY(l1.getP1()))));

		double a2 = getDoubleY(l2.getP2()) - getDoubleY(l2.getP1());
		double b2 = getDoubleX(l2.getP1()) - getDoubleX(l2.getP2());
		double c2 = ((a2 * (getDoubleX(l2.getP1()))) + (b2 * (getDoubleY(l2.getP1()))));

		double determinant = a1 * b2 - a2 * b1;

		double x = (b2 * c1 - b1 * c2) / determinant;
		double y = (a1 * c2 - a2 * c1) / determinant;

		return "Lines intersect at(" + Double.toString(x) + "," + Double.toString(y) + ")";
	}

	private double getDoubleX(Point p) {
		return Double.parseDouble(p.getX());
	}

	private double getDoubleY(Point p) {
		return Double.parseDouble(p.getY());
	}

	private Double getSlope(Line l) {
		double diffY = getDoubleY(l.getP2()) - getDoubleY(l.getP1());
		double diffX = getDoubleX(l.getP2()) - getDoubleX(l.getP1());
		return diffY / diffX;
	}
}
