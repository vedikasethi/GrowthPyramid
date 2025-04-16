package com.example.Analytics.service;

import com.example.Analytics.repository.AnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    @Override
    public Map<String, Double> getTotalSalesPerMonth(Long companyId) {
        List<Object[]> results = analyticsRepository.getTotalSalesPerMonth(companyId);
        return toMap(results);
    }

    @Override
    public Map<String, Double> getTopSellingProduct(Long companyId) {
        List<Object[]> results = analyticsRepository.getTopSellingProduct(companyId);
        return toMap(results);
    }

    @Override
    public Map<String, Double> getSalesByCity(Long companyId) {
        List<Object[]> results = analyticsRepository.getSalesByCity(companyId);
        return toMap(results);
    }

    private Map<String, Double> toMap(List<Object[]> results) {
        return results.stream().collect(Collectors.toMap(
                row -> String.valueOf(row[0]),              // key (month, product name, or city)
                row -> ((Number) row[1]).doubleValue()      // value
        ));
    }
}
