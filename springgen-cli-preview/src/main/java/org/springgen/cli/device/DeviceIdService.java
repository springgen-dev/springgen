package org.springgen.cli.device;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class DeviceIdService {

    private static final String CONFIG_DIR_NAME = ".springgen";
    private static final String DEVICE_FILE_NAME = "device-id";

    public String getOrCreateDeviceId() {
        try {
            Path deviceFile = getDeviceFilePath();

            if (Files.exists(deviceFile)) {
                String existing = Files.readString(deviceFile).trim();
                if (!existing.isBlank()) {
                    return existing;
                }
            }

            Files.createDirectories(deviceFile.getParent());

            String deviceId = UUID.randomUUID().toString();
            Files.writeString(deviceFile, deviceId);

            return deviceId;

        } catch (IOException e) {
            throw new RuntimeException("Failed to load/create device ID", e);
        }
    }

    private Path getDeviceFilePath() {
        String userHome = System.getProperty("user.home");

        if (userHome == null || userHome.isBlank()) {
            throw new IllegalStateException("User home directory not found");
        }

        return Path.of(userHome, CONFIG_DIR_NAME, DEVICE_FILE_NAME);
    }
}