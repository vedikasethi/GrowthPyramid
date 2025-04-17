package com.example.CompanyManagement.service;

import com.example.CompanyManagement.entity.Company;
import com.example.CompanyManagement.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company registerCompany(Company company) {
        try {
            return companyRepository.save(company);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new IllegalArgumentException("error: " + e.getMostSpecificCause());
        }
    }

    // Delete a company by ID
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Update company details
  // Update company details
  public Company updateCompany(Long id, Company companyDetails) {
        return companyRepository.findById(id)
                .map(company -> {
                if (companyDetails.getUsername() != null) {
                    company.setUsername(companyDetails.getUsername());
                }
                if (companyDetails.getPassword() != null) {
                    company.setPassword(companyDetails.getPassword());
                }
                if (companyDetails.getCompanyName() != null) {
                    company.setCompanyName(companyDetails.getCompanyName());
                }
                if (companyDetails.getCategory() != null) {
                    company.setCategory(companyDetails.getCategory());
                }
                if (companyDetails.getDescription() != null) {
                    company.setDescription(companyDetails.getDescription());
                }
                if (companyDetails.getContactName() != null) {
                    company.setContactName(companyDetails.getContactName());
                }
                if (companyDetails.getContactNumber() != null) {
                    company.setContactNumber(companyDetails.getContactNumber());
                }
                if (companyDetails.getContactMailId() != null) {
                    company.setContactMailId(companyDetails.getContactMailId());
                }
                if (companyDetails.getContactDesignation() != null) {
                    company.setContactDesignation(companyDetails.getContactDesignation());
                }
                if (companyDetails.getBalance() != null) {
                    company.setBalance(companyDetails.getBalance());
                }
                    return companyRepository.save(company);
                }).orElse(null);
    }

    // Get company by ID
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


}