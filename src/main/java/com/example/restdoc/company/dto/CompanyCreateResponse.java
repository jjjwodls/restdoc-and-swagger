package com.example.restdoc.company.dto;

import com.example.restdoc.company.entity.Company;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyCreateResponse {

    private Long id;
    private String companyName;
    private String companyAddress;

    public static CompanyCreateResponse from(Company company) {
        return CompanyCreateResponse.builder()
                .id(company.getId())
                .companyName(company.getName())
                .companyAddress(company.getAddress())
                .build();
    }
}
