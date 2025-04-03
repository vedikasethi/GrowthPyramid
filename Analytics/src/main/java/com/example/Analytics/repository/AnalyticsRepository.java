package com.example.Analytics.repository;

import com.example.Analytics.entity.AnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsRepository extends JpaRepository<AnalyticsEntity, Long> {
    // Custom query methods for analytics can be added here
}
