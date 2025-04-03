package com.example.CompanyManagement.mycontroller;

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

    private final CompanyService companyService;

    // Register a new company
    @PostMapping("/register")
    public ResponseEntity<Company> registerCompany(@RequestBody Company company) {
        Company savedCompany = companyService.registerCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    // Delete a company by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompany(id);
        return isDeleted ? ResponseEntity.ok("Company deleted successfully")
                : ResponseEntity.badRequest().body("Company not found");
    }

    // Update company details
    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company updatedCompany = companyService.updateCompany(id, companyDetails);
        return updatedCompany != null ? ResponseEntity.ok(updatedCompany)
                : ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        return company != null ? ResponseEntity.ok(company)
                : ResponseEntity.badRequest().build();
    }
}
