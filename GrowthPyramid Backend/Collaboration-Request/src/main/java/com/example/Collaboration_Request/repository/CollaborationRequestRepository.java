package com.example.Collaboration_Request.repository;

import com.example.Collaboration_Request.entity.CollaborationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaborationRequestRepository extends JpaRepository<CollaborationRequest, Long> {
    List<CollaborationRequest> findByToCompanyId(Long toCompanyId);
    List<CollaborationRequest> findByFromCompanyId(Long fromCompanyId);
}

