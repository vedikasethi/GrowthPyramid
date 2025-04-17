package com.example.Analytics.mycontroller;

import com.example.Analytics.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "http://localhost:3000") // Frontend origin
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/totalsalespermonth/{companyId}")
    public List<Object[]> getTotalSalesPerMonth(@PathVariable Long companyId) {
        return analyticsService.getTotalSalesPerMonth(companyId);
    }

    @GetMapping("/topsellingproduct/{companyId}")
    public List<Object[]> getTopSellingProduct(@PathVariable Long companyId) {
        return analyticsService.getTopSellingProduct(companyId);
    }

    @GetMapping("/totalsalesbycity/{companyId}")
    public List<Object[]> getSalesByCity(@PathVariable Long companyId) {
        return analyticsService.getSalesByCity(companyId);
    }
}