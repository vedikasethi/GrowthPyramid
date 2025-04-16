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

    @GetMapping("/totalsalespermonth/{companyId}")
    public ResponseEntity<Map<String, Double>> getTotalSalesPerMonth(@PathVariable Long companyId) {
        return ResponseEntity.ok(analyticsService.getTotalSalesPerMonth(companyId));
    }

    @GetMapping("/topsellingproduct/{companyId}")
    public ResponseEntity<Map<String, Double>> getTopSellingProduct(@PathVariable Long companyId) {
        return ResponseEntity.ok(analyticsService.getTopSellingProduct(companyId));
    }

    @GetMapping("/totalsalesbycity/{companyId}")
    public ResponseEntity<Map<String, Double>> getSalesByCity(@PathVariable Long companyId) {
        return ResponseEntity.ok(analyticsService.getSalesByCity(companyId));
    }
}
