package com.example.Analytics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String metric;
    private double value;

    // Constructors
    public AnalyticsEntity() {}

    public AnalyticsEntity(String metric, double value) {
        this.metric = metric;
        this.value = value;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMetric() { return metric; }
    public void setMetric(String metric) { this.metric = metric; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}
