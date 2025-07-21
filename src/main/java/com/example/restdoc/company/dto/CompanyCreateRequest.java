package com.example.restdoc.company.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyCreateRequest {

    @NotEmpty(message = "companyName is required")
    private String companyName;
    @NotEmpty(message = "address is required")
    private String address;
}
