package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.CompanyVersionDTO;
import com.example.demo.model.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(CompanyDTO companyDTO);
    Company getCompanyById(Long id);
    List<CompanyVersionDTO> getCompanyVersion(Long id);
    List<Company> getAllCompanies();
    Company updateCompany(Long id, CompanyDTO companyDTO);
    void deleteCompany(Long id);
}
