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
    public Company updateCompany(Long id, Company companyDetails) {
        return companyRepository.findById(id)
                .map(company -> {
                    company.setCategory(companyDetails.getCategory());
                    company.setDescription(companyDetails.getDescription());
                    company.setContactName(companyDetails.getContactName());
                    company.setContactNumber(companyDetails.getContactNumber());
                    company.setContactMailId(companyDetails.getContactMailId());
                    company.setContactDesignation(companyDetails.getContactDesignation());
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