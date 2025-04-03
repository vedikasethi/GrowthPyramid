package com.example.Analytics.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

public interface AnalyticsService {
    Map<String, Double> getTotalSalesPerMonth(Long companyId);
    String getTopSellingProduct(Long companyId);
    Map<String, Double> getSalesByCity(Long companyId);
}
