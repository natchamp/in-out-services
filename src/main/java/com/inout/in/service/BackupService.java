package com.inout.in.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class BackupService {

    private Logger log = LoggerFactory.getLogger(BackupService.class);

    public void createBackup(String databaseUrl, String username, String password, String backupFilePath) {

        backupFilePath = "E:\\Swiatlotech.in\\UI";//+ LocalDateTime.now()+".sql";
        log.info(backupFilePath);
        // Example command for MySQL backup
        String command = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldumpmysqldump -h " + "jdbc:mysql://localhost:3308/in-out" + " -u " + "root" + " -p " + "Rohit123@" + " dbname > " + backupFilePath;

        Process process = null;
        int exitCode = 1;
        try {
            process = Runtime.getRuntime().exec(command);
            exitCode = process.waitFor();
            log.info("ackup created successfully......");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (exitCode == 0) {
            System.out.println("Backup created successfully.");
        } else {
            System.err.println("Backup creation failed.");
        }
    }
}
