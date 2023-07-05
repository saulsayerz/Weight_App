package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weight")
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tanggal")
    private Date date;

    @Column(name = "berat_max")
    private double maxWeight;

    @Column(name = "berat_min")
    private double minWeight;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for date
    public Date getDate() {
        return date;
    }

    // Setter for date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter for maxWeight
    public double getMaxWeight() {
        return maxWeight;
    }

    // Setter for maxWeight
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    // Getter for minWeight
    public double getMinWeight() {
        return minWeight;
    }

    // Setter for minWeight
    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }
}
