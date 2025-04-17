package com.example.Collaboration_Request.entity;
import com.example.CompanyManagement.entity.Company;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "collaboration_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollaborationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "from_company_id", nullable = false)
    private Company fromCompany;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "to_company_id", nullable = false)
    private Company toCompany;

    @Column(length = 500)
    private String message;

    @Enumerated(EnumType.STRING)
    private RequestStatus status; // PENDING, ACCEPTED, REJECTED

    private LocalDateTime sentAt;
}
