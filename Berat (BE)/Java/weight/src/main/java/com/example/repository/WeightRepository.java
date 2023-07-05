package com.example.repository;

import java.sql.Date;
import java.util.List;

import com.example.model.Weight;

public interface WeightRepository {
  int save(Weight weight);

  int update(Weight weight);

  Weight findById(int id);

  int deleteById(int id);

  List<Weight> findAll();

  List<Weight> findByDate(Date date);

  List<Weight> findByRange(int minWeight, int maxWeight);

  int deleteAll();
}
