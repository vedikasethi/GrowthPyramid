package com.example.Analytics.mycontroller;

import com.example.Analytics.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    // Get total sales per month
    @GetMapping("/sales/monthly/{companyId}")
    public ResponseEntity<Map<String, Double>> getTotalSalesPerMonth(@PathVariable Long companyId) {
        return ResponseEntity.ok(analyticsService.getTotalSalesPerMonth(companyId));
    }

    // Get top-selling product
    @GetMapping("/sales/top-product/{companyId}")
    public ResponseEntity<String> getTopSellingProduct(@PathVariable Long companyId) {
        return ResponseEntity.ok(analyticsService.getTopSellingProduct(companyId));
    }

    // Get sales by city
    @GetMapping("/sales/city/{companyId}")
    public ResponseEntity<Map<String, Double>> getSalesByCity(@PathVariable Long companyId) {
        return ResponseEntity.ok(analyticsService.getSalesByCity(companyId));
    }
}
