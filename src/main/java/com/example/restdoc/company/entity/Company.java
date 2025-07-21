package com.example.restdoc.company.entity;

import com.example.restdoc.company.dto.CompanyCreateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    public static Company create(CompanyCreateRequest request){
        return Company.builder().name(request.getCompanyName())
                .address(request.getAddress())
                .build();
    }
}
