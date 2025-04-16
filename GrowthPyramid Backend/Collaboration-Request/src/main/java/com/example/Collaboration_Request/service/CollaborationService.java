package com.example.Collaboration_Request.service;


import com.example.Collaboration_Request.DTO.CollaborationRequestDTO;
import com.example.Collaboration_Request.DTO.CreateCollaborationRequestDTO;
import com.example.Collaboration_Request.Mapper.CollaborationMapper;
import com.example.Collaboration_Request.entity.CollaborationRequest;
import com.example.Collaboration_Request.entity.RequestStatus;
import com.example.Collaboration_Request.repository.CollaborationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollaborationService {

    private final CollaborationRequestRepository repository;

    public CollaborationRequestDTO sendRequest(CreateCollaborationRequestDTO dto) {
        CollaborationRequest request = CollaborationRequest.builder()
                .fromCompanyId(dto.getFromCompanyId())
                .toCompanyId(dto.getToCompanyId())
                .message(dto.getMessage())
                .status(RequestStatus.PENDING)
                .sentAt(LocalDateTime.now())
                .build();
        return CollaborationMapper.toDTO(repository.save(request));
    }

    public List<CollaborationRequestDTO> getRequestsReceived(Long companyId) {
        return repository.findByToCompanyId(companyId)
                .stream()
                .map(CollaborationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CollaborationRequestDTO> getRequestsSent(Long companyId) {
        return repository.findByFromCompanyId(companyId)
                .stream()
                .map(CollaborationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CollaborationRequestDTO updateStatus(Long requestId, RequestStatus status) {
        CollaborationRequest request = repository.findById(requestId).orElseThrow();
        request.setStatus(status);
        return CollaborationMapper.toDTO(repository.save(request));
    }
}
