package com.example.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weights")
@Data
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "max_weight")
    private double maxWeight;

    @Column(name = "min_weight")
    private double minWeight;
}