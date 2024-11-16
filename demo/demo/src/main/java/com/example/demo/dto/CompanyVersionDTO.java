package com.example.demo.dto;

public class CompanyVersionDTO {
    private String codigoCompany;
    private String nameCompany;
    private String appName;
    private String version;

    // Constructor
    public CompanyVersionDTO(String codigoCompany, String nameCompany, String appName, String version) {
        this.codigoCompany = codigoCompany;
        this.nameCompany = nameCompany;
        this.appName = appName;
        this.version = version;
    }

    // Getters and setters
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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
