package com.example.Analytics.service;

import java.util.Map;

public interface AnalyticsService {
    Map<String, Double> getTotalSalesPerMonth(Long companyId);
    Map<String, Double> getTopSellingProduct(Long companyId);
    Map<String, Double> getSalesByCity(Long companyId);
}
