package org.springgen.cli.http;

public class GenerateRequest {

    private String projectName;
    private String basePackage;
    private String database;
    private String targetTier;
    private boolean docker;
    private boolean basicCi;

    public String getProjectName() {
        return projectName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getDatabase() {
        return database;
    }

    public String getTargetTier() {
        return targetTier;
    }

    public boolean isDocker() {
        return docker;
    }

    public boolean isBasicCi() {
        return basicCi;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setTargetTier(String targetTier) {
        this.targetTier = targetTier;
    }

    public void setDocker(boolean docker) {
        this.docker = docker;
    }

    public void setBasicCi(boolean basicCi) {
        this.basicCi = basicCi;
    }
}