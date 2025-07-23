package com.example.restdoc.company;

import com.example.restdoc.company.entity.Company;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyJpaRepository companyJpaRepository;
    public Company createCompany(Company company) {
        company.setId(1L);
        Company save = companyJpaRepository.save(company);
        log.info("company is created name = {} , address = {}", company.getName(), company.getAddress());
        return save;
    }

    public Company findOne(Long id){
        return companyJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("id" + id + " is not found"));
    }

}
