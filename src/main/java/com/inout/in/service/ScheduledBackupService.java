package com.inout.in.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ScheduledBackupService {

    @Autowired
    private BackupService backupService;

    private Logger log = LoggerFactory.getLogger(ScheduledBackupService.class);

    //String backupFileName = "backup"+new Date().getTime()+".sql";
    String backupFileName = "backup.sql";

    @Scheduled(cron = "10 41 14 * * *") // Run daily at midnight
    public void performDatabaseBackup() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dbHost = "localhost";
        String dbPort = "3308";
        String dbName = "in-out";
        String dbUser = "root";
        String dbPass = "Rohit123@";
        String dumpExe = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe";
        String dumpSavePath = "E:\\Swiatlotech.in\\";
        String fileName = "backup.sql";
        Backupdbtosql(dbHost, dbPort, dbUser, dbPass, dbName, dumpExe, dumpSavePath, fileName);
    }

    public void Backupdbtosql(String host,String port,String user,String password,String dbName,String dumpExe,String dumpSavePath,String fileName){

        Boolean backupCompleted = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            String batchCommand;
            if (password != ""){
                batchCommand = dumpExe +
                        " -h " + host +
                        " --port " + port +
                        " -u " + user +
                        " --password=" + password +
                        " --add-drop-database -B " + dbName +
                        " -r \"" + dumpSavePath + "" + backupFileName;
            }else{
                batchCommand = dumpExe +
                        " -h " + host +
                        " --port " + "3308" +
                        " -u " + user +
                        " --add-drop-database -B " + dbName +
                        " -r \"" + dumpSavePath + "" + backupFileName;
            }
            System.out.println("Execute Commond - " +batchCommand);
            System.out.println("Processing.. "+ "STARTED " +sdf.format(new Date()));
            Date sDate = new Date();
            Process runtimeProcess = Runtime.getRuntime().exec(batchCommand);
            int processComplete = runtimeProcess.waitFor();

            System.out.println("Processing.. "+ "END " +sdf.format(new Date()));
            Date eDate = new Date();
            long duration =  eDate.getTime() - sDate.getTime();
            int seconds=(int) ((duration/1000)%60);
            long minutes=((duration-seconds)/1000)/60;
            System.err.println("TOTAL TIME : " + minutes +" minutes :: ");
            System.err.print(seconds +" seconds :: ");
            System.err.print(duration +" milliseconds");
            if (processComplete == 0) {
                System.out.println("Backup Complete");
                backupCompleted=true;
            } else {
                System.out.println("Backup Failure");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        if(backupCompleted){
            try {
                addFiletoGoogleDrive();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addFiletoGoogleDrive() throws Exception {

        String APPLICATION_NAME = "Your Application Name";
        JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        String CREDENTIALS_FILE_PATH = "/DriveAPiCredentials.json"; // Update with your credentials file path
        String UPLOAD_FILE_PATH = "E:\\Swiatlotech.in\\backup.sql"; // Update with the file you want to upload

        // Load client secrets
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                new InputStreamReader(ScheduledBackupService.class.getResourceAsStream(CREDENTIALS_FILE_PATH)));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, clientSecrets,
                Collections.singleton(DriveScopes.DRIVE_FILE)).setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

        // Build a new authorized API client service
        Drive service = new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME).build();

        // Upload a file
        File fileMetadata = new File();
        fileMetadata.setName("My Uploaded File");
        java.io.File filePath = new java.io.File(UPLOAD_FILE_PATH);
        FileContent mediaContent = new FileContent("text/plain", filePath);
        File uploadedFile = service.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + uploadedFile.getId());
    }
}
