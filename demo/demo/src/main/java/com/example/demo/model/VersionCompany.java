package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "version_company")
public class VersionCompany {

    @Id
    @Column(name = "version_company_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "version_id")
    private Version version;

    @Column(name = "version_company_description")
    private String versionCompanyDescription;  // Añadido para corresponder con "version_company_description"

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getVersionCompanyDescription() {
        return versionCompanyDescription;
    }

    public void setVersionCompanyDescription(String versionCompanyDescription) {
        this.versionCompanyDescription = versionCompanyDescription;
    }
}
