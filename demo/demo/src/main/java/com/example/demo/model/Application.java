package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @Column(name = "app_id")
    private Long appId;

    @Column(name = "app_code")
    private String appCode;  // Correspondencia con "app_code" en la tabla

    @Column(name = "app_name")
    private String appName;

    @Column(name = "app_description")
    private String appDescription;  // Correspondencia con "app_description"

    // Getters and setters
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }
}
