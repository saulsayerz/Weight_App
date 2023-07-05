package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Weight;

import java.util.List;

@Repository
public interface WeightRepository extends CrudRepository<Weight, Long> {
    List<Weight> findAllByOrderByDateDesc();
}