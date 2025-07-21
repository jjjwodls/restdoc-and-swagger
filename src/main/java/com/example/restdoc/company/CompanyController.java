package com.example.restdoc.company;

import com.example.restdoc.company.dto.CompanyCreateRequest;
import com.example.restdoc.company.dto.CompanyCreateResponse;
import com.example.restdoc.company.dto.CompanyResponse;
import com.example.restdoc.company.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("")
    public ResponseEntity<CompanyCreateResponse> createCompany(
            @RequestBody
            @Validated CompanyCreateRequest request) {
        Company createdCompany = companyService.createCompany(Company.create(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CompanyCreateResponse.from(createdCompany));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> findOne(@PathVariable Long id){
        return ResponseEntity.ok(CompanyResponse.from(companyService.findOne(id)));
    }
}
