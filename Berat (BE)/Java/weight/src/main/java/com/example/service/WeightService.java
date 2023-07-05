package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Weight;
import com.example.repository.WeightRepository;

import java.util.List;

@Service
public class WeightService {
    private final WeightRepository weightRepository;

    @Autowired
    public WeightService(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    public List<Weight> getAllWeights() {
        return weightRepository.findAllByOrderByDateDesc();
    }

    public Weight getWeightById(Long id) {
        return weightRepository.findById(id).orElse(null);
    }

    public Weight createWeight(Weight weight) {
        return weightRepository.save(weight);
    }

    public Weight updateWeight(Long id, Weight weightDetails) {
        Weight weight = weightRepository.findById(id).orElse(null);
        if (weight != null) {
            weight.setDate(weightDetails.getDate());
            weight.setMaxWeight(weightDetails.getMaxWeight());
            weight.setMinWeight(weightDetails.getMinWeight());
            return weightRepository.save(weight);
        }
        return null;
    }

    public void deleteWeight(Long id) {
        weightRepository.deleteById(id);
    }
}


