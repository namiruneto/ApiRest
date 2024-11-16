package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column(name = "ID_COMPANY")
    private Long id;

    @Column(name = "CODIGO_COMPANY")
    private String codigoCompany;

    @Column(name = "NAME_COMPANY")
    private String nameCompany;

    @Column(name = "DESCRIPTION_COMPANY")
    private String descriptionCompany;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCompany() {
        return codigoCompany;
    }

    public void setCodigoCompany(String codigoCompany) {
        this.codigoCompany = codigoCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDescriptionCompany() {
        return descriptionCompany;
    }

    public void setDescriptionCompany(String descriptionCompany) {
        this.descriptionCompany = descriptionCompany;
    }
}
