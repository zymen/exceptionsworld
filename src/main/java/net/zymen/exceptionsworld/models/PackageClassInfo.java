package net.zymen.exceptionsworld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PackageClassInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String fullClassName;

    private String packageArtifactId;

    private String packageGroupId;

    private String packageVersion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    public String getPackageArtifactId() {
        return packageArtifactId;
    }

    public void setPackageArtifactId(String packageArtifactId) {
        this.packageArtifactId = packageArtifactId;
    }

    public String getPackageGroupId() {
        return packageGroupId;
    }

    public void setPackageGroupId(String packageGroupId) {
        this.packageGroupId = packageGroupId;
    }

    public String getPackageVersion() {
        return packageVersion;
    }

    public void setPackageVersion(String packageVersion) {
        this.packageVersion = packageVersion;
    }
}
