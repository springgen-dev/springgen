# SpringGen CLI Preview

This folder contains a preview/reference version of the SpringGen CLI client.

It is provided so developers can review how the CLI interacts with the SpringGen API, generates a device ID, downloads the generated ZIP file, and extracts the project locally.

The production backend and Pro generation modules are not included in this repository.

## What CLI does

For free Starter generation, the CLI uses a locally generated device ID to prevent abuse. It does not collect source code, environment variables, secrets, or local project files.