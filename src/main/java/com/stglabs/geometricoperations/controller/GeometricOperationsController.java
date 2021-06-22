package com.stglabs.geometricoperations.controller;

import com.stglabs.geometricoperations.models.IncomingRequestBody;
import com.stglabs.geometricoperations.service.GeometricOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geometric/")
public class GeometricOperationsController {

    @Autowired
    private GeometricOperationsService service;

    @PostMapping("/calculateDistance")
    public Double calculateDistanceByTwoPoint(@RequestBody IncomingRequestBody incomingRequestBody) {
        return service.calculateDistanceByTwoPoint(incomingRequestBody.getL1());
    }

    @PostMapping("/yIntercept")
    public Double getYIntercept(@RequestBody IncomingRequestBody incomingRequestBody) {
        return service.getYIntercept(incomingRequestBody.getL1());
    }

    @PostMapping("/parallelism")
    public String parallelism(@RequestBody IncomingRequestBody incomingRequestBody) {
        return service.parallelism(incomingRequestBody.getL1(), incomingRequestBody.getL2());
    }

    @PostMapping("/perpendicularity")
    public String perpendicularity(@RequestBody IncomingRequestBody incomingRequestBody) {
        return service.perpendicularity(incomingRequestBody.getL1(), incomingRequestBody.getL2());
    }

    @PostMapping("/incidence")
    public String incidence(@RequestBody IncomingRequestBody incomingRequestBody) {
        return service.incidence(incomingRequestBody.getL1(), incomingRequestBody.getL2());
    }
}
