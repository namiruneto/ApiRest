package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "version")
public class Version {

    @Id
    @Column(name = "version_id")
    private Long versionId;

    @Column(name = "version")
    private String version;

    @Column(name = "version_description")
    private String versionDescription;  // Añadido para corresponder con "version_description"

    @ManyToOne
    @JoinColumn(name = "app_id")
    private Application application;

    // Getters and setters
    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
