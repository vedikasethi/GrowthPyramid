package com.example.CompanyManagement.mycontroller;

import com.example.CompanyManagement.Mapping.CompanyMapping;
import com.example.CompanyManagement.companyDTO.CompanyDTO;
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
    public ResponseEntity<CompanyDTO> registerCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = CompanyMapping.toEntity(companyDTO);
        Company savedCompany = companyService.registerCompany(company);
        return ResponseEntity.ok(CompanyMapping.toDTO(savedCompany));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompany(id);
        return isDeleted ? ResponseEntity.ok("Company deleted successfully")
                : ResponseEntity.badRequest().body("Company not found");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        Company companyDetails = CompanyMapping.toEntity(companyDTO);
        Company updatedCompany = companyService.updateCompany(id, companyDetails);
        return updatedCompany != null
                ? ResponseEntity.ok(CompanyMapping.toDTO(updatedCompany))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        return company != null
                ? ResponseEntity.ok(CompanyMapping.toDTO(company))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyDTO> companyDTOs = companies.stream()
                .map(CompanyMapping::toDTO)
                .toList();
        return ResponseEntity.ok(companyDTOs);
    }




}