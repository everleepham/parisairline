package com.pham_mishra.parisairline.controller;

import com.pham_mishra.parisairline.model.Plane;
import com.pham_mishra.parisairline.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @GetMapping
    public ResponseEntity<List<Plane>> getAllPlanes() {
        List<Plane> planes = planeService.getAllPlanes();
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Plane>> getPlaneById(@PathVariable Long id) {
        Optional<Plane> plane = planeService.getPlaneById(id);
        if (plane.isPresent()) {
            return new ResponseEntity<>(plane, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        Plane createdPlane = planeService.addPlane(plane);
        return new ResponseEntity<>(createdPlane, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable Long id, @RequestBody Plane updatedPlane) {
        Plane plane = planeService.updatePlane(id, updatedPlane);
        if (plane != null) {
            return new ResponseEntity<>(plane, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}