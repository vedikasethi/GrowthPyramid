package com.example.Collaboration_Request.repository;

import com.example.Collaboration_Request.entity.CollaborationRequest;
import com.example.CompanyManagement.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaborationRequestRepository extends JpaRepository<CollaborationRequest, Long> {
    List<CollaborationRequest> findByToCompany(Company toCompany);
    List<CollaborationRequest> findByFromCompany(Company fromCompany);
}

