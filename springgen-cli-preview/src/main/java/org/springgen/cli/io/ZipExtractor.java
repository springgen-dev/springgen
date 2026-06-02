package org.springgen.cli.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExtractor {

    public void extract(Path zipPath, Path targetDir) {
        try {
            Files.createDirectories(targetDir);

            try (InputStream inputStream = Files.newInputStream(zipPath);
                 ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {

                ZipEntry entry;

                while ((entry = zipInputStream.getNextEntry()) != null) {
                    Path outputPath = targetDir.resolve(entry.getName()).normalize();

                    if (!outputPath.startsWith(targetDir)) {
                        throw new IllegalStateException("Invalid ZIP entry: " + entry.getName());
                    }

                    if (entry.isDirectory()) {
                        Files.createDirectories(outputPath);
                    } else {
                        Files.createDirectories(outputPath.getParent());
                        Files.write(outputPath, zipInputStream.readAllBytes());

                        if (isExecutable(outputPath)) {
                            outputPath.toFile().setExecutable(true);
                        }
                    }

                    zipInputStream.closeEntry();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract ZIP: " + zipPath, e);
        }
    }

    private boolean isExecutable(Path path) {
        String fileName = path.getFileName().toString();

        return fileName.equals("gradlew")
                || fileName.endsWith(".sh");
    }
}
