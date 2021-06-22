package com.stglabs.geometricoperations.service;

import com.stglabs.geometricoperations.models.Line;

public interface GeometricOperationsService {

	public Double calculateDistanceByTwoPoint(Line line);

	public String parallelism(Line l1, Line l2);

    public String perpendicularity(Line l1, Line l2);

    public String incidence(Line l1, Line l2);

	public Double getYIntercept(Line line);

}
