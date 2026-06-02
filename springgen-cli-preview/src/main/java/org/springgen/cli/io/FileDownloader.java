package org.springgen.cli.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDownloader {

    public void save(byte[] bytes, Path outputPath) {
        try {
            Files.createDirectories(outputPath.getParent());
            Files.write(outputPath, bytes);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save downloaded file: " + outputPath, e);
        }
    }
}
