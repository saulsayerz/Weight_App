package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.Weight;
import com.example.service.WeightService;

import java.util.List;

@RestController
@RequestMapping("/weights")
public class WeightController {
    private final WeightService weightService;

    @Autowired
    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping
    public List<Weight> getAllWeights() {
        return weightService.getAllWeights();
    }

    @GetMapping("/{id}")
    public Weight getWeightById(@PathVariable Long id) {
        return weightService.getWeightById(id);
    }

    @PostMapping
    public Weight createWeight(@RequestBody Weight weight) {
        return weightService.createWeight(weight);
    }

    @PutMapping("/{id}")
    public Weight updateWeight(@PathVariable Long id, @RequestBody Weight weight) {
        return weightService.updateWeight(id, weight);
    }

    @DeleteMapping("/{id}")
    public void deleteWeight(@PathVariable Long id) {
        weightService.deleteWeight(id);
    }
}

