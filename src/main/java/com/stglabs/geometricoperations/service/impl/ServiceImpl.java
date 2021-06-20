package com.stglabs.geometricoperations.service.impl;

import com.stglabs.geometricoperations.models.Line;
import com.stglabs.geometricoperations.models.Point;
import com.stglabs.geometricoperations.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	double getDoubleX(Point p) {
		return Double.parseDouble(p.getX());
	}

	double getDoubleY(Point p) {
		return Double.parseDouble(p.getY());
	}

	public String getSlope(Line l) {

		try {
			double diffY = 0.0;
			double diffX = 0.0;
			double sloped = 0.0;
			diffY = getDoubleY(l.getP2()) - getDoubleY(l.getP1());
			diffX = getDoubleX(l.getP2()) - getDoubleX(l.getP1());

			if (diffX == 0.0)
				return "Line is vertical";

			if (diffX == 0.0)
				return "Line is horizontal";

			sloped = diffY / diffX;

			return Double.toString(sloped);
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String parallelism(Line l1, Line l2) {
		try {
			String slope1 = getSlope(l1);
			String slope2 = getSlope(l2);

			if (slope1.equals(slope2))
				return "lines are parallel";
			else
				return "lines are not parallel";
		} catch (Exception e) {
			return e.toString();
		}

	}

	public String perpendicularity(Line l1, Line l2) {
		try {
			if (parallelism(l1, l2).equals("lines are parallel"))
				return "lines are parallel";
			String slope1 = getSlope(l1);
			String slope2 = getSlope(l2);

			if (((slope1.equals("Line is vertical") && slope2.equals("Line is horizontal"))
					|| ((slope2.equals("Line is vertical") && slope1.equals("Line is horizontal")))))
				return "lines are perpendicular";

			try {
				if (Double.parseDouble(slope1) * Double.parseDouble(slope2) == -1)
					return "lines are perpendicular";
			} catch (Exception e) {

			}

			return "lines are not perpendicular";
		} catch (Exception e) {
			return e.toString();
		}

	}

	public String incidence(Line l1, Line l2) {
		try {

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
		} catch (Exception e) {
			return e.toString();
		}

	}

}
