package com.example.OrderManagement.repository;

import com.example.OrderManagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.company.id = :companyId")
    List<Order> findOrdersByCompanyId(@Param("companyId") Long companyId);
}
