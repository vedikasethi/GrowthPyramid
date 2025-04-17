package com.example.Collaboration_Request.Controller;


import com.example.Collaboration_Request.DTO.CollaborationRequestDTO;
import com.example.Collaboration_Request.DTO.CreateCollaborationRequestDTO;
import com.example.Collaboration_Request.entity.RequestStatus;
import com.example.Collaboration_Request.service.CollaborationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/collaboration")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000") // Frontend origin
public class CollaborationController {

    private final CollaborationService service;

    @PostMapping("/send")
    public ResponseEntity<?> sendRequest(@RequestBody CreateCollaborationRequestDTO dto) {
        try {
            CollaborationRequestDTO response = service.sendRequest(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/received/{companyId}")
    public ResponseEntity<?> getReceived(@PathVariable Long companyId) {
        try {
            List<CollaborationRequestDTO> requests = service.getRequestsReceived(companyId);
            return ResponseEntity.ok(requests);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/sent/{companyId}")
    public ResponseEntity<?> getSent(@PathVariable Long companyId) {
        try {
            List<CollaborationRequestDTO> requests = service.getRequestsSent(companyId);
            return ResponseEntity.ok(requests);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/respond/{requestId}")
    public ResponseEntity<?> respond(@PathVariable Long requestId, @RequestParam RequestStatus status) {
        try {
            CollaborationRequestDTO updatedRequest = service.respond(requestId, status);
            return ResponseEntity.ok(updatedRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
