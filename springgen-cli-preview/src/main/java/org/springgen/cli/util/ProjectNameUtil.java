package org.springgen.cli.util;

public final class ProjectNameUtil {

    private ProjectNameUtil() {
    }

    public static String toSafeFileName(String projectName) {
        return projectName
                .toLowerCase()
                .replaceAll("[^a-z0-9._-]", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");
    }
}