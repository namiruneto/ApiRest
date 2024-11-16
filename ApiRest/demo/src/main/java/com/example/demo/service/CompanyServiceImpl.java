package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.CompanyVersionDTO;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public Company createCompany(CompanyDTO companyDTO) {
        Company company = new Company();
          company.setId(companyDTO.getIdCompany());
        company.setCodigoCompany(companyDTO.getCodigoCompany());  
        company.setNameCompany(companyDTO.getNameCompany()); 
        company.setDescriptionCompany(companyDTO.getDescriptionCompany());  
        return repository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + id));
    }

    @Override
    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    @Override
    public Company updateCompany(Long id, CompanyDTO companyDTO) {
        Company company = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + id));
        company.setCodigoCompany(companyDTO.getCodigoCompany());  // Usando camelCase
        company.setNameCompany(companyDTO.getNameCompany());  // Usando camelCase
        company.setDescriptionCompany(companyDTO.getDescriptionCompany());  // Usando camelCase
        return repository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + id));
        repository.delete(company); 
    }

     @Override
     public List<CompanyVersionDTO> getCompanyVersion(Long id) {
        return repository.findCompanyVersionById(id);
    }
}
