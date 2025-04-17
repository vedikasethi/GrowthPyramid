package com.example.CompanyManagement.repository;

import com.example.CompanyManagement.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByUsername(String username);
}
