package com.example.restdoc.company.dto;

import com.example.restdoc.company.entity.Company;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyResponse {

    private Long id;
    private String companyName;
    private String companyAddress;

    public static CompanyResponse from(Company company){
        return CompanyResponse.builder()
                .id(company.getId())
                .companyAddress(company.getAddress())
                .companyName(company.getName())
                .build();
    }

}
