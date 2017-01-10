package net.zymen.exceptionsworld.models;

import org.springframework.data.annotation.Id;

public class PackageClass {

    @Id
    private int id;

    private String fullClassName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }
}
