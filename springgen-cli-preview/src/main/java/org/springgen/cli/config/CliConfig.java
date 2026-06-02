package org.springgen.cli.config;

public class CliConfig {

    private static final String DEFAULT_API_URL = "https://api.springgen.dev";

    private final String apiBaseUrl;

    public CliConfig(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public static CliConfig load(String overrideApiUrl) {
        if (overrideApiUrl != null && !overrideApiUrl.isBlank()) {
            return new CliConfig(trimTrailingSlash(overrideApiUrl));
        }

        String envApiUrl = System.getenv("SPRINGGEN_API_URL");

        if (envApiUrl != null && !envApiUrl.isBlank()) {
            return new CliConfig(trimTrailingSlash(envApiUrl));
        }

        return new CliConfig(DEFAULT_API_URL);
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    private static String trimTrailingSlash(String value) {
        while (value.endsWith("/")) {
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }
}