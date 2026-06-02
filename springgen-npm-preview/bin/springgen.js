#!/usr/bin/env node

import { spawn } from 'child_process';
import fs from 'fs';
import os from 'os';
import path from 'path';
import https from 'https';

const VERSION = "0.0.1";

const LOCAL_CLI_JAR = process.env.SPRINGGEN_LOCAL_CLI_JAR;

const CLI_DIR = path.join(os.homedir(), ".springgen");
const CLI_JAR = LOCAL_CLI_JAR || path.join(CLI_DIR, `springgen-cli-${VERSION}.jar`);

const DOWNLOAD_URL =`https://releases.springgen.dev/springgen-cli-${VERSION}.jar`;

async function ensureCliDownloaded() {
  if (LOCAL_CLI_JAR) {
    if (!fs.existsSync(LOCAL_CLI_JAR)) {
      throw new Error(`Local CLI jar not found: ${LOCAL_CLI_JAR}`);
    }

    console.log(`Using local SpringGen CLI jar: ${LOCAL_CLI_JAR}`);
    return;
  }

  if (fs.existsSync(CLI_JAR)) {
    return;
  }

  fs.mkdirSync(CLI_DIR, { recursive: true });

  console.log(`Downloading SpringGen CLI ${VERSION}...`);

  await downloadFile(DOWNLOAD_URL, CLI_JAR);

  console.log("Download complete");
}

function downloadFile(url, destination) {
  return new Promise((resolve, reject) => {

    https.get(url, response => {

      if (response.statusCode !== 200) {
        reject(
            new Error(
                `Download failed: HTTP ${response.statusCode}`
            )
        );
        return;
      }

      const file = fs.createWriteStream(destination);

      response.pipe(file);

      file.on('finish', () => {
        file.close(resolve);
      });

    }).on('error', err => {
      fs.unlink(destination, () => {});
      reject(err);
    });

  });
}


async function main() {
  await ensureCliDownloaded();

  const args = process.argv.slice(2);

  const child = spawn(
      'java',
      ['-jar', CLI_JAR, ...args],
      {
        stdio: 'inherit'
      }
  );

  child.on('exit', code => {
    process.exit(code);
  });
}

main().catch(err => {
  console.error(err);
  process.exit(1);
});