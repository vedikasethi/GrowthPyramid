package com.example.Analytics.repository;

import com.example.Analytics.entity.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticsRepository extends JpaRepository<Analytics, Long> {

    // 1️⃣ Total Sales Per Month
    @Query(value = "SELECT DATE_FORMAT(orderdate, '%Y-%m') AS month, SUM(amount) AS total_sales " +
            "FROM orders WHERE company_id = :companyId " +
            "GROUP BY DATE_FORMAT(orderdate, '%Y-%m')", nativeQuery = true)
    List<Object[]> getTotalSalesPerMonth(@Param("companyId") Long companyId);

    // 2️⃣ Top Selling Product
    @Query(value = "SELECT product_name, SUM(quantity) AS total_quantity " +
            "FROM orders WHERE company_id = :companyId " +
            "GROUP BY product_name " +
            "ORDER BY total_quantity DESC LIMIT 10", nativeQuery = true)
    List<Object[]> getTopSellingProduct(@Param("companyId") Long companyId);

    // 3️⃣ Sales by City
    @Query(value = "SELECT city, SUM(amount) AS total_sales " +
            "FROM orders WHERE company_id = :companyId " +
            "GROUP BY city", nativeQuery = true)
    List<Object[]> getSalesByCity(@Param("companyId") Long companyId);
}