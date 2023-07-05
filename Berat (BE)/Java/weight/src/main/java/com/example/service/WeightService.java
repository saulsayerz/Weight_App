package com.example.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Weight;
import com.example.repository.WeightRepository;

@Repository
public class WeightService implements WeightRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(Weight weight) {
    return jdbcTemplate.update("INSERT INTO weights (date, max_weight, min_weight) VALUES(?,?,?)",
        new Object[] { weight.getDate(), weight.getMaxWeight(), weight.getMinWeight() });
  }

  @Override
  public int update(Weight weight) {
    return jdbcTemplate.update("UPDATE weights SET date=?, max_weight=?, min_weight=? WHERE id=?",
        new Object[] { weight.getDate(), weight.getMaxWeight(), weight.getMinWeight(), weight.getId() });
  }

  @Override
  public Weight findById(int id) {
    try {
      Weight weight = jdbcTemplate.queryForObject("SELECT * FROM weights WHERE id=?",
          BeanPropertyRowMapper.newInstance(Weight.class), id);

      return weight;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(int id) {
    return jdbcTemplate.update("DELETE FROM weights WHERE id=?", id);
  }

  @Override
  public List<Weight> findAll() {
    return jdbcTemplate.query("SELECT * from weights", BeanPropertyRowMapper.newInstance(Weight.class));
  }

  @Override
  public List<Weight> findByDate(Date date) {
    return jdbcTemplate.query("SELECT * from weights WHERE date=?",
        BeanPropertyRowMapper.newInstance(Weight.class), date);
  }

  @Override
  public List<Weight> findByRange(int minWeight, int maxWeight) {
    return jdbcTemplate.query("SELECT * from weights WHERE min_weight >= ? AND max_weight <= ?",
        BeanPropertyRowMapper.newInstance(Weight.class), minWeight, maxWeight);
  }

  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from weights");
  }
}
