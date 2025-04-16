package com.example.Collaboration_Request.Controller;


import com.example.Collaboration_Request.DTO.CollaborationRequestDTO;
import com.example.Collaboration_Request.DTO.CreateCollaborationRequestDTO;
import com.example.Collaboration_Request.entity.RequestStatus;
import com.example.Collaboration_Request.service.CollaborationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collaboration")
@RequiredArgsConstructor
public class CollaborationController {

    private final CollaborationService service;

    @PostMapping("/send")
    public CollaborationRequestDTO sendRequest(@RequestBody CreateCollaborationRequestDTO dto) {
        return service.sendRequest(dto);
    }

    @GetMapping("/received/{companyId}")
    public List<CollaborationRequestDTO> getReceived(@PathVariable Long companyId) {
        return service.getRequestsReceived(companyId);
    }

    @GetMapping("/sent/{companyId}")
    public List<CollaborationRequestDTO> getSent(@PathVariable Long companyId) {
        return service.getRequestsSent(companyId);
    }

    @PostMapping("/respond/{requestId}")
    public CollaborationRequestDTO respond(
            @PathVariable Long requestId,
            @RequestParam RequestStatus status) {
        return service.updateStatus(requestId, status);
    }
}
