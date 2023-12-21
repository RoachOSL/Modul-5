package dev.Roach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class ListFilesInFolder {


    private void createFiles() {

        for (int i = 0; i < 15; i++) {

            String fileName = (i + 1) + "exampleFile" + ".txt";
            File file = new File("ExampleFiles\\" + fileName);

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

    private void fillTheFiles() {

        File folder = new File("ExampleFiles");
        File[] files = folder.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(randomText());
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

        createFiles();
        fillTheFiles();

        if (directoryPath.startsWith("\\")) {
            directoryPath = directoryPath.substring(1);
        }

        File file = new File(directoryPath);
        File[] files = file.listFiles();

        System.out.println("Files in folder are: ");

        for (File f : files) {
            System.out.println("File named: " + f.getName());
        }
    }

    public void deleteFilesInFolder() {

        File folder = new File("ExampleFiles");
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                file.delete();
                System.out.println("File " + file.getName() + " was successfully deleted");
            }
            System.out.println("You deleted all the files in the folder");
        }

    }

    private void deleteFilesInFolder(File directory) {

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

        String path = "ExampleFiles";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete content of: " +
                "\n " + path + " ? ");
        System.out.println("Type \"yes\" to proceed \n");
        String input = scanner.nextLine().toLowerCase();

        if (input.equals("yes")) {
            File folder = new File(path);
            if (folder.exists() && folder.isDirectory()) {
                deleteFilesInFolder(folder);
                if (folder.delete()) {
                    System.out.println("You successfully deleted folder and files");
                }
            } else {
                System.err.println("The specified path is not a directory or does not exist.");
            }
        } else {
            return;
        }
    }

    private String randomText() {

        StringBuilder sb = new StringBuilder();
        Random randomCharGenerator = new Random();

        for (int i = 0; i < 100; i++) {
            if (i > 0 && i % 7 == 0) {
                sb.append(" ");
            }

            int randomInt = randomCharGenerator.nextInt(52);
            // It skips 6 ASCII Character between big A-Z and small a-z
            if (randomInt >= 26) {
                randomInt += 6;
            }
            char randomChar = (char) (randomInt + 65);
            sb.append(randomChar);
        }

        return String.valueOf(sb);
    }


}
