package dev.Roach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class ListFilesInFolder {

    public void createFolder() {

        File folder = new File("E:\\ProjektyIntelliJ\\Modul-5\\ExampleFiles");

        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("Folder created: " + folder.getAbsolutePath());
        } else {
            System.out.println("Folder is already created");
        }
    }

    public void createFiles() {

        String path = "E:\\ProjektyIntelliJ\\Modul-5\\ExampleFiles\\";
        for (int i = 0; i < 15; i++) {

            String fileName = (i + 1) + "exampleFile" + ".txt";
            File file = new File(path + fileName);

            try {
                if (file.createNewFile()) {
                    System.out.println("File was successfully created at " + file.getAbsolutePath());
                } else {
                    System.out.println("File already exists in " + file.getAbsolutePath());
                }
            } catch (IOException exception) {
                System.err.println("Error occured, try to create folder first");
                exception.printStackTrace();
            }
        }
    }

    public void fillTheFiles() {

        String path = "E:\\ProjektyIntelliJ\\Modul-5\\ExampleFiles\\";
        File folder = new File(path);

        File[] files = folder.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(randomText());
                    fw.close();
                    System.out.println("File " + file.getName() + " filled with random text");
                } catch (IOException exception) {
                    System.err.println("Error occured");
                    exception.printStackTrace();
                }
            }
        } else {
            System.err.println("Files or folder doesn't exist, " +
                    "first use method createFolder and createFiles()");
        }

    }

    public void printDirectory(String directoryPath) {

        File file = new File(directoryPath);
        File[] files = file.listFiles();

        System.out.println("Files in folder are: ");

        for (File f : files) {
            System.out.println("File named: " + f.getName());
        }
    }

    public void deleteFilesInFolder() {

        String path = "E:\\ProjektyIntelliJ\\Modul-5\\ExampleFiles\\";
        File folder = new File(path);

        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                file.delete();
                System.out.println("File " + file.getName() + " was successfully deleted");
            }
            System.out.println("You deleted all the files in the folder");
        }

    }

    public void deleteFilesInFolder(File directory) {

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFilesInFolder(file);
                } else {
                    if (file.delete()) {
                        System.out.println("File " + file.getName() + " was successfully deleted");
                    } else {
                        System.err.println("Failed to delete file " + file.getName());
                    }
                }
            }
        }

        if (directory.delete()) {
            System.out.println("Folder " + directory.getName() + " was deleted");
        } else {
            System.err.println("Failed to delete folder " + directory.getName());
        }

    }

    public void deleteWholeFolder() {

        String path = "E:\\ProjektyIntelliJ\\Modul-5\\ExampleFiles";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete content of: " +
                "\n " + path + " ? ");
        System.out.println("Type \"yes\" to proceed");
        String input = scanner.nextLine().toLowerCase();

        if (input.equals("yes")) {
            File folder = new File(path);
            if (folder.exists() && folder.isDirectory()) {
                deleteFilesInFolder(folder);
                if (folder.delete()) {
                    System.out.println("You successfully delted folder and files");
                }
            } else {
                System.err.println("The specified path is not a directory or does not exist.");
            }
        } else {
            return;
        }
    }

    public String randomText() {

        StringBuilder sb = new StringBuilder();
        Random randomCharGenerator = new Random();

        for (int i = 0; i < 100; i++) {
            if (i > 0 && i % 7 == 0) {
                sb.append(" ");
            }

            int randomInt = randomCharGenerator.nextInt(52);
            if (randomInt >= 26) {
                randomInt += 6;
            }
            char randomChar = (char) (randomInt + 65);
            sb.append(randomChar);
        }

        return String.valueOf(sb);
    }


}
