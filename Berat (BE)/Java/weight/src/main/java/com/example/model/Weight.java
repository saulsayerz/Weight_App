package com.example.model;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "weights")
public class Weight {

  private int id;
  private Date date;
  @Column(name = "max_weight", nullable = false)
  private int maxWeight;
  @Column(name = "min_weight", nullable = false)
  private int minWeight;

  public Weight() {

  }

  public Weight(int id, Date date, int maxWeight, int minWeight) {
    this.id = id;
    this.date = date;
    this.maxWeight = maxWeight;
    this.minWeight = minWeight;
  }

  public Weight(Date date, int maxWeight, int minWeight) {
    this.date = date;
    this.maxWeight = maxWeight;
    this.minWeight = minWeight;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getMaxWeight() {
    return maxWeight;
  }

  public void setMaxWeight(int maxWeight) {
    this.maxWeight = maxWeight;
  }

  public int getMinWeight() {
    return minWeight;
  }

  public void setMinWeight(int minWeight) {
    this.minWeight = minWeight;
  }

  @Override
  public String toString() {
    return "Weight [id=" + id + ", date=" + date + ", maxWeight=" + maxWeight + ", minWeight=" + minWeight + "]";
  }
}

