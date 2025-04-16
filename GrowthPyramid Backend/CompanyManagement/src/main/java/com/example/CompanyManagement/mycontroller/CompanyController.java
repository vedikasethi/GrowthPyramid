package com.example.CompanyManagement.mycontroller;

import com.example.CompanyManagement.Mapping.CompanyMapping;
import com.example.CompanyManagement.companyDTO.CompanyDTO;
import com.example.CompanyManagement.companyDTO.CompanyIdDTO;
import com.example.CompanyManagement.entity.Company;
import com.example.CompanyManagement.repository.CompanyRepository;
import com.example.CompanyManagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;
    private final CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<CompanyIdDTO> registerCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = CompanyMapping.toEntity(companyDTO);
        Company savedCompany = companyService.registerCompany(company);
        return ResponseEntity.ok(CompanyMapping.toCompanyIDDTO(savedCompany));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompany(id);
        return isDeleted ? ResponseEntity.ok("Company deleted successfully")
                : ResponseEntity.badRequest().body("Company not found");
    }

@PutMapping("/update/{id}")
public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
    Company existingCompany = companyService.getCompanyById(id);
    if (existingCompany == null) {
        return ResponseEntity.badRequest().build();
    }

    // Update only the fields that are not null
    if (companyDTO.getUsername() != null) {
        existingCompany.setUsername(companyDTO.getUsername());
    }
    if (companyDTO.getPassword() != null) {
        existingCompany.setPassword(companyDTO.getPassword());
    }
    if (companyDTO.getCompanyName() != null) {
        existingCompany.setCompanyName(companyDTO.getCompanyName());
    }
    if (companyDTO.getCategory() != null) {
        existingCompany.setCategory(companyDTO.getCategory());
    }
    if (companyDTO.getDescription() != null) {
        existingCompany.setDescription(companyDTO.getDescription());
    }
    if (companyDTO.getContactName() != null) {
        existingCompany.setContactName(companyDTO.getContactName());
    }
    if (companyDTO.getContactNumber() != null) {
        existingCompany.setContactNumber(Long.valueOf(companyDTO.getContactNumber()));
    }
    if (companyDTO.getContactMailId() != null) {
        existingCompany.setContactMailId(companyDTO.getContactMailId());
    }
    if (companyDTO.getContactDesignation() != null) {
        existingCompany.setContactDesignation(companyDTO.getContactDesignation());
    }

    Company updatedCompany = companyService.updateCompany(id, existingCompany);
    return ResponseEntity.ok(CompanyMapping.toDTO(updatedCompany));
}

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        return company != null
                ? ResponseEntity.ok(CompanyMapping.toDTO(company))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyIdDTO>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyIdDTO> companyDTOs = companies.stream()
                .map(CompanyMapping::toCompanyIDDTO)
                .toList();
        return ResponseEntity.ok(companyDTOs);
    }




}