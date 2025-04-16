package com.example.Collaboration_Request.DTO;

import com.example.Collaboration_Request.entity.RequestStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollaborationRequestDTO {
    private Long id;
    private Long fromCompanyId;
    private Long toCompanyId;
    private String message;
    private RequestStatus status;
    private LocalDateTime sentAt;
}
