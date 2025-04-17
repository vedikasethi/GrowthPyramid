package com.example.CompanyManagement.companyDTO;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRegisterDTO {
    private String username;
    private String password;
    private String companyName;
    private String category;
    private String description;
    private String contactName;
    private String contactNumber;
    private String contactMailId;
    private String contactDesignation;
    private String balance;
}

