package org.springgen.cli.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class SpringGenClient {

    private static final String DEVICE_ID_HEADER = "X-DEVICE-ID";

    private final String apiBaseUrl;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SpringGenClient(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public byte[] generateStarterProject(GenerateRequest request, String deviceId) {
        HttpURLConnection connection = null;

        try {
            URI uri = URI.create(apiBaseUrl + "/api/generate?targetTier=" + request.getTargetTier());

            connection = (HttpURLConnection) uri.toURL().openConnection();

            connection.setRequestMethod("POST");
            connection.setConnectTimeout(10_000);
            connection.setReadTimeout(120_000);
            connection.setDoOutput(true);

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/octet-stream");
            connection.setRequestProperty(DEVICE_ID_HEADER, deviceId);

            byte[] body = objectMapper.writeValueAsBytes(request);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(body);
            }

            int status = connection.getResponseCode();

            if (status >= 200 && status < 300) {
                try (InputStream inputStream = connection.getInputStream()) {
                    return inputStream.readAllBytes();
                }
            }

            String errorBody = readErrorBody(connection);
            throw new RuntimeException("Backend returned HTTP " + status + ": " + errorBody);

        } catch (Exception e) {
            throw new RuntimeException("Failed to call SpringGen backend " + e.getMessage(), e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String readErrorBody(HttpURLConnection connection) throws IOException {
        InputStream errorStream = connection.getErrorStream();

        if (errorStream == null) {
            return "";
        }

        try (InputStream input = errorStream) {
            return new String(input.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}