package dev.Roach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserNamedFile {

    private String lastWrittenFilePath;

    public boolean writeUserInputToFile() {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Provide name for your file: ");
            String name = scanner.nextLine();

            if (!name.toLowerCase().endsWith(".txt")) {
                name += ".txt";
            }

            System.out.println("Provide text for your file: ");
            String text = scanner.nextLine();

            String directoryName = "ExampleFiles";
            if (!CreateDirectoryUtil.createDirectory(directoryName)) {
                return false;
            }

            File file = new File(directoryName, name);
            lastWrittenFilePath = file.getAbsolutePath();

            try (FileWriter fw = new FileWriter(file)) {
                String[] words = text.split("\\s+");
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < words.length; i++) {
                    sb.append(words[i]);
                    if ((i + 1) % 4 == 0) {
                        sb.append("\n");
                    } else {
                        sb.append(" ");
                    }
                }

                fw.write(sb.toString());
                fw.flush();
                System.out.println("Successfully wrote your text to the file.");
                readFromFile();
                return true;

            } catch (IOException exception) {
                exception.printStackTrace();
                return false;
            }

        }
    }

    public void readFromFile(String fileName) {

        File file = new File(fileName);

        if (file.isDirectory()) {
            System.err.println("Provided path is a directory, not a file: " + fileName);
            return;
        }

        if (!file.exists()) {
            System.err.println("File does not exist: " + fileName);
            return;
        }

        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                String fileData = fileReader.nextLine();
                System.out.println(fileData);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void readFromFile() {

        if (lastWrittenFilePath == null) {
            System.err.println("No file path available to read.");
            return;
        }

        File file = new File(lastWrittenFilePath);

        if (!file.exists()) {
            System.err.println("File does not exist: " + lastWrittenFilePath);
            return;
        }

        try (Scanner fileReader = new Scanner(file)) {
            System.out.println("Reading from file: " + file.getAbsolutePath());
            while (fileReader.hasNextLine()) {
                String fileData = fileReader.nextLine();
                System.out.println(fileData);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
