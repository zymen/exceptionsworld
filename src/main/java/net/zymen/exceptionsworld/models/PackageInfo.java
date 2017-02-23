package net.zymen.exceptionsworld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PackageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String artifactId;

    private String groupId;

    private String version;

    private boolean isAnalyzed = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isAnalyzed() {
        return isAnalyzed;
    }

    public void setAnalyzed(boolean analyzed) {
        isAnalyzed = analyzed;
    }

    public String getJarUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("https://repo.maven.apache.org/maven2/");
        builder.append(getGroupId().replace(".", "/")).append("/");
        builder.append(getArtifactId()).append("/");
        builder.append(getVersion()).append("/");
        builder.append(getArtifactId()).append("-").append(getVersion()).append(".jar");

        return builder.toString();
    }
}
