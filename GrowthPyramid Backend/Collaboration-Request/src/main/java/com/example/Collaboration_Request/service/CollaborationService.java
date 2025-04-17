package com.example.Collaboration_Request.service;


import com.example.Collaboration_Request.DTO.CollaborationRequestDTO;
import com.example.Collaboration_Request.DTO.CreateCollaborationRequestDTO;
import com.example.Collaboration_Request.Mapper.CollaborationMapper;
import com.example.Collaboration_Request.entity.CollaborationRequest;
import com.example.Collaboration_Request.entity.RequestStatus;
import com.example.Collaboration_Request.repository.CollaborationRequestRepository;
import com.example.CompanyManagement.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollaborationService {

    private final CollaborationRequestRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public CollaborationRequestDTO sendRequest(CreateCollaborationRequestDTO dto) {
        Company fromCompany = getManagedCompany(dto.getFromCompanyId());
        Company toCompany = getManagedCompany(dto.getToCompanyId());

        CollaborationRequest request = CollaborationRequest.builder()
                .fromCompany(fromCompany)
                .toCompany(toCompany)
                .message(dto.getMessage())
                .status(RequestStatus.PENDING)
                .sentAt(LocalDateTime.now())
                .build();
        return CollaborationMapper.toDTO(repository.save(request));
    }

    public List<CollaborationRequestDTO> getRequestsReceived(Long companyId) {
        Company toCompany = getManagedCompany(companyId);
        return repository.findByToCompany(toCompany)
                .stream()
                .map(CollaborationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CollaborationRequestDTO> getRequestsSent(Long companyId) {
        Company fromCompany = getManagedCompany(companyId);
        return repository.findByFromCompany(fromCompany)
                .stream()
                .map(CollaborationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CollaborationRequestDTO respond(Long requestId, RequestStatus status) {
        CollaborationRequest request = repository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request with ID " + requestId + " not found"));
        request.setStatus(status);
        return CollaborationMapper.toDTO(repository.save(request));
    }

    private Company getManagedCompany(Long companyId) {
        Company managedCompany = entityManager.find(Company.class, companyId);
        if (managedCompany == null) {
            throw new IllegalArgumentException("Company with ID: " + companyId + " does not exist in the database.");
        }
        return managedCompany;
    }
}


