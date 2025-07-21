package com.example.restdoc.company;

import com.example.restdoc.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyJpaRepository extends JpaRepository<Company,Long> {

}
