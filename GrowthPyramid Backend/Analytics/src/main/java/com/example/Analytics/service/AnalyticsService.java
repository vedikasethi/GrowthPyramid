package com.example.Analytics.service;

import com.example.Analytics.repository.AnalyticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public List<Object[]> getTotalSalesPerMonth(Long companyId) {
        return analyticsRepository.getTotalSalesPerMonth(companyId);
    }

    public List<Object[]> getTopSellingProduct(Long companyId) {
        return analyticsRepository.getTopSellingProduct(companyId);
    }

    public List<Object[]> getSalesByCity(Long companyId) {
        return analyticsRepository.getSalesByCity(companyId);
    }
}