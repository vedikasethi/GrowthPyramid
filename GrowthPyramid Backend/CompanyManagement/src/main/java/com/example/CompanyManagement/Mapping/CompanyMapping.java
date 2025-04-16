package com.example.CompanyManagement.Mapping;

import com.example.CompanyManagement.companyDTO.CompanyDTO;
import com.example.CompanyManagement.companyDTO.CompanyIdDTO;
import com.example.CompanyManagement.entity.Company;

public class CompanyMapping {

    // ✅ Convert Entity to DTO
    public static CompanyDTO toDTO(Company company) {
        if (company == null) return null;

        return CompanyDTO.builder()
                .username(company.getUsername())                  // Map username
                .password(String.valueOf(company.getPassword()))                  // Directly map password
                .companyName(company.getCompanyName())            // Map companyName
                .category(company.getCategory())                  // Map category
                .description(company.getDescription())            // Map description
                .contactName(company.getContactName())            // Map contactName
                .contactNumber(String.valueOf(company.getContactNumber()))        // Map contactNumber
                .contactMailId(company.getContactMailId())        // Map contactMailId
                .contactDesignation(company.getContactDesignation())
               // Map contactDesignation
                .build();
    }

    // ✅ Convert Entity to DTO
    public static CompanyIdDTO toCompanyIDDTO(Company company) {
        if (company == null) return null;

        return CompanyIdDTO.builder()
                .companyId(String.valueOf(company.getCompanyID()))                  // Map companyID
                .username(company.getUsername())                  // Map username
                .password(String.valueOf(company.getPassword()))                  // Directly map password
                .companyName(company.getCompanyName())            // Map companyName
                .category(company.getCategory())                  // Map category
                .description(company.getDescription())            // Map description
                .contactName(company.getContactName())            // Map contactName
                .contactNumber(String.valueOf(company.getContactNumber()))        // Map contactNumber
                .contactMailId(company.getContactMailId())        // Map contactMailId
                .contactDesignation(company.getContactDesignation())
                // Map contactDesignation
                .build();
    }

    // ✅ Convert DTO to Entity
    public static Company toEntity(CompanyDTO dto) {
        if (dto == null) return null;

        return Company.builder()
                .username(dto.getUsername())                      // Map username
                .password(String.valueOf(dto.getPassword()))                      // Directly map password
                .companyName(dto.getCompanyName())                // Map companyName
                .category(dto.getCategory())                      // Map category
                .description(dto.getDescription())                // Map description
                .contactName(dto.getContactName())                // Map contactName
                .contactNumber(Long.valueOf(dto.getContactNumber())) // Map contactNumber
                .contactMailId(dto.getContactMailId())            // Map contactMailId
                .contactDesignation(dto.getContactDesignation())// Map contactDesignation

                .build();
    }
}

