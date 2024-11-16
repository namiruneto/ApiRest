package com.example.demo.controller;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import com.example.demo.dto.CompanyVersionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @PostMapping
    public Company createCompany(@RequestBody CompanyDTO companyDTO) {
        return service.createCompany(companyDTO);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        return service.updateCompany(id, companyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        service.deleteCompany(id);
    }

    @GetMapping("/{id}")
    public List<CompanyVersionDTO> getCompanyVersion(@PathVariable Long id) {
        return service.getCompanyVersion(id);
    }
}
