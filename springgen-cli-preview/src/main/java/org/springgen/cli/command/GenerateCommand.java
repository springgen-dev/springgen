package org.springgen.cli.command;


import org.springgen.cli.config.CliConfig;
import org.springgen.cli.device.DeviceIdService;
import org.springgen.cli.http.GenerateRequest;
import org.springgen.cli.http.SpringGenClient;
import org.springgen.cli.io.FileDownloader;
import org.springgen.cli.io.ZipExtractor;
import org.springgen.cli.util.ProjectNameUtil;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(
        name = "init",
        description = "Generate a free Spring Boot Starter project",
        mixinStandardHelpOptions = true
)
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"--project-name"}, required = true, description = "Project name, e.g. my-starter-app")
    private String projectName;

    @Option(names = {"--package-name"}, required = true, description = "Base package, e.g. com.example.demo")
    private String packageName;

    @Option(
            names = {"--db"},
            defaultValue = "NONE",
            description = "Database type: NONE, POSTGRES, MYSQL, MONGO"
    )
    private String database;

    @Option(
            names = "--docker",
            defaultValue = "true",
            description = "Include local Docker support (true/false)",
            arity = "1"
    )
    private Boolean docker;

    @Option(
            names = {"--basic-ci"},
            defaultValue = "true",
            description = "Include basic GitHub Actions CI (true/false)",
            arity = "1"
    )
    private Boolean basicCi;


    @Option(
            names = {"--output"},
            defaultValue = ".",
            description = "Output directory"
    )
    private String outputDir;

    @Option(
            names = {"--unzip"},
            defaultValue = "true",
            description = "Unzip generated project after download"
    )
    private boolean unzip;

    @Option(
            names = {"--api-url"},
            hidden = true,
            description = "Override SpringGen backend URL"
    )
    private String apiUrl;

    @Override
    public Integer call() {
        try {
            validate();

            CliConfig config = CliConfig.load(apiUrl);
            DeviceIdService deviceIdService = new DeviceIdService();

            String deviceId = deviceIdService.getOrCreateDeviceId();

            GenerateRequest request = new GenerateRequest();
            request.setProjectName(projectName);
            request.setBasePackage(packageName);
            request.setDatabase(database.toUpperCase());
            request.setTargetTier("STARTER");

            boolean dockerEnabled =
                    docker == null || docker;

            request.setDocker(dockerEnabled);

            boolean basicCiEnabled =
                    basicCi == null || basicCi;

            request.setBasicCi(basicCiEnabled);

            SpringGenClient client = new SpringGenClient(config.getApiBaseUrl());

            System.out.println("Generating Starter project...");
            System.out.println("Project: " + projectName);
            System.out.println("Package: " + packageName);
            System.out.println("Database: " + database.toUpperCase());
            if (basicCi) System.out.println("Basic Ci: Included");
            if (docker) System.out.println("Docker: Included");

            byte[] zipBytes = client.generateStarterProject(request, deviceId);

            Path outputPath = Path.of(outputDir).toAbsolutePath().normalize();
            Path zipPath = outputPath.resolve(ProjectNameUtil.toSafeFileName(projectName) + ".zip");

            FileDownloader fileDownloader = new FileDownloader();
            fileDownloader.save(zipBytes, zipPath);

            System.out.println("Downloaded ZIP: " + zipPath);

            if (unzip) {
                ZipExtractor extractor = new ZipExtractor();
                Path extractDir = outputPath.resolve(ProjectNameUtil.toSafeFileName(projectName));
                extractor.extract(zipPath, extractDir);

                System.out.println("Extracted project: " + extractDir);
                System.out.println();

                System.out.println("Next steps:");
                System.out.println("1. cd " + extractDir);

                if (!"NONE".equalsIgnoreCase(request.getDatabase())) {
                    System.out.println("2. Review/update .env with your database settings:");
                    System.out.println("   - DB_NAME");
                    System.out.println("   - DB_USER");
                    System.out.println("   - DB_PASSWORD");
                    System.out.println("   - DB_PORT");
                    System.out.println();
                    System.out.println("3. Start locally:");
                    System.out.println("   docker compose up --build");
                } else {
                    System.out.println("2. Start locally:");
                    System.out.println("   docker compose up --build");
                }
            }

            return 0;

        } catch (Exception e) {
            System.err.println("Failed to generate project: " + e.getMessage());
            return 1;
        }
    }

    private void validate() {
        if (!database.equalsIgnoreCase("NONE")
                && !database.equalsIgnoreCase("POSTGRES")
                && !database.equalsIgnoreCase("MYSQL")
                && !database.equalsIgnoreCase("MONGO")) {
            throw new IllegalArgumentException("Invalid database. Allowed values: NONE, POSTGRES, MYSQL, MONGO");
        }

        if (projectName == null || projectName.isBlank()) {
            throw new IllegalArgumentException("Project name is required");
        }

        if (packageName == null || packageName.isBlank()) {
            throw new IllegalArgumentException("Package name is required");
        }

        if (!packageName.matches("^[a-zA-Z_][a-zA-Z0-9_]*(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$")) {
            throw new IllegalArgumentException("Invalid Java package name");
        }

    }
}