package com.roadreadywheels.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

    public static void main(String[] args) {
        // SMTP server details
        String host = "smtp.gmail.com";
        int port = 465;

        // System properties for email
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", String.valueOf(port));
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Step 1: Get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String email = PropertyReader.getConfigProperty("reportEmail").trim();
                String password = PropertyReader.getConfigProperty("reportKey").trim();
                return new PasswordAuthentication(email, password);
            }
        });

        // Optionally enable session debugging
      //  boolean isDebug = Boolean.parseBoolean(PropertyReader.getConfigProperty("debugEmail", "false"));
       // session.setDebug(isDebug);

        try {
            // Step 2: Compress the folder into a ZIP file
            String folderPath = "target/cucumber-html-reports";
            String zipFilePath = "target/cucumber-html-reports.zip";

            compressFolderToZip(folderPath, zipFilePath);

            // Step 3: Compose the email
            MimeMessage message = new MimeMessage(session);

            // Set recipient addresses
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(PropertyReader.getConfigProperty("reportTo").trim()));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(PropertyReader.getConfigProperty("reportCC").trim()));

            // Set email subject
            message.setSubject("Automation Report of Roadready Wheels.");

            // Email body
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Please find the attached Cucumber report.");

            // Attachment
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            File zipFile = new File(zipFilePath);
            System.out.println("file="+zipFile.getName());
            System.out.println("file="+zipFile.getAbsolutePath());
            

            if (!zipFile.exists() || !zipFile.isFile()) {
                throw new FileNotFoundException("ZIP file not found: " + zipFilePath);
            }

            attachmentBodyPart.attachFile(zipFile);

            // Combine text and attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textBodyPart);
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);

            // Step 4: Send the email
            Transport.send(message);
            System.out.println("Email sent successfully with the folder attachment!");

        } catch (FileNotFoundException e) {
            System.err.println("Attachment error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Compresses a folder into a ZIP file.
     *
     * @param folderPath   the path of the folder to compress
     * @param zipFilePath  the path where the ZIP file will be created
     * @throws IOException if an I/O error occurs
     */
    private static void compressFolderToZip(String folderPath, String zipFilePath) throws IOException {
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new FileNotFoundException("Folder not found or invalid: " + folderPath);
        }

        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            zos.setComment("Automation report ZIP file created for Roadready Wheels.");
            zipFolder(folder, folder.getName(), zos);
        }
    }

    /**
     * Recursively adds files and subdirectories to the ZIP output stream,
     * excluding specified files.
     *
     * @param folder       the folder to compress
     * @param parentFolder the parent folder name for ZIP entries
     * @param zos          the ZIP output stream
     * @throws IOException if an I/O error occurs
     */
    private static void zipFolder(File folder, String parentFolder, ZipOutputStream zos) throws IOException {
        for (File file : folder.listFiles()) {
            // Exclude specific files from the ZIP
        	  if (file.isDirectory() && file.getName().equals("js")) {
                  System.out.println("Excluding folder: " + file.getAbsolutePath());
                  continue;
              }
            if (file.isFile() && file.getName().endsWith("RoadreadyWheelsAutomation-0.0.1-SNAPSHOT.jar")) {
                System.out.println("Excluding file: " + file.getAbsolutePath());
                continue;
            }

            if (file.isDirectory()) {
                // Recursively add subdirectories
                zipFolder(file, parentFolder + "/" + file.getName(), zos);
            } else {
                // Add file to the ZIP
                ZipEntry zipEntry = new ZipEntry(parentFolder + "/" + file.getName());
                zos.putNextEntry(zipEntry);
                zos.write(java.nio.file.Files.readAllBytes(file.toPath()));
                zos.closeEntry();
            }
        }
    }
}
