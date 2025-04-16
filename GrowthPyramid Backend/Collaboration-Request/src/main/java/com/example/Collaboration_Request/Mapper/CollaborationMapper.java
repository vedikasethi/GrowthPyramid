package com.example.Collaboration_Request.Mapper;

import com.example.Collaboration_Request.DTO.CollaborationRequestDTO;
import com.example.Collaboration_Request.entity.CollaborationRequest;;

public class CollaborationMapper {

    public static CollaborationRequestDTO toDTO(CollaborationRequest request) {
        return CollaborationRequestDTO.builder()
                .id(request.getId())
                .fromCompanyId(request.getFromCompanyId())
                .toCompanyId(request.getToCompanyId())
                .message(request.getMessage())
                .status(request.getStatus())
                .sentAt(request.getSentAt())
                .build();
    }
}
