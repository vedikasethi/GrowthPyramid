package com.example.Collaboration_Request.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCollaborationRequestDTO {
    private Long fromCompanyId;
    private Long toCompanyId;
    private String message;
}
