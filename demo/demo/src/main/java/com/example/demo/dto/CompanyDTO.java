package com.example.demo.dto;

public class CompanyDTO {
    private Long idCompany;  // Cambiar nombre de "ID_COMPANY"
    private String codigoCompany;
    private String nameCompany;
    private String descriptionCompany;

    // Constructor vacío
    public CompanyDTO() {
    }

    // Constructor con todos los campos
    public CompanyDTO(Long idCompany, String codigoCompany, String nameCompany, String descriptionCompany) {
        this.idCompany = idCompany;
        this.codigoCompany = codigoCompany;
        this.nameCompany = nameCompany;
        this.descriptionCompany = descriptionCompany;
    }

    // Getters y Setters
    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
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
