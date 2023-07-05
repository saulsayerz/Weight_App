package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Weight;
import com.example.repository.WeightRepository;

@RestController
@RequestMapping("/api/weights")
public class WeightController {

  @Autowired
  private WeightRepository weightRepository;

  @GetMapping("/")
  public ResponseEntity<List<Weight>> getAllWeights() {
    try {
      List<Weight> weights = weightRepository.findAll();

      if (weights.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(weights, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Weight> getWeightById(@PathVariable("id") int id) {
    Weight weight = weightRepository.findById(id);

    if (weight != null) {
      return new ResponseEntity<>(weight, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/")
  public ResponseEntity<String> createWeight(@RequestBody Weight weight) {
    try {
      weightRepository.save(weight);
      return new ResponseEntity<>("Weight was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateWeight(@PathVariable("id") int id, @RequestBody Weight weight) {
    Weight existingWeight = weightRepository.findById(id);

    if (existingWeight != null) {
      weight.setId(id);
      weightRepository.update(weight);
      return new ResponseEntity<>("Weight was updated successfully.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Cannot find Weight with id=" + id, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteWeight(@PathVariable("id") int id) {
    try {
      int result = weightRepository.deleteById(id);
      if (result == 0) {
        return new ResponseEntity<>("Cannot find Weight with id=" + id, HttpStatus.OK);
      }
      return new ResponseEntity<>("Weight was deleted successfully.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot delete weight.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/")
  public ResponseEntity<String> deleteAllWeights() {
    try {
      int numRows = weightRepository.deleteAll();
      return new ResponseEntity<>("Deleted " + numRows + " Weight(s) successfully.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot delete weights.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/average")
  public ResponseEntity<Double> getWeightAverage() {
    try {
      List<Weight> weights = weightRepository.findAll();

      if (weights.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      double totalWeight = 0;
      for (Weight weight : weights) {
        totalWeight += weight.getMaxWeight() - weight.getMinWeight();
      }

      double average = totalWeight / weights.size();

      return new ResponseEntity<>(average, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
