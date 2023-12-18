package dev.Roach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InvertFileContent {

    public boolean invertFile(String filePath) {

        createDirectory(filePath);

        File fileToRead = new File(filePath);

        if (!fileToRead.exists()) {
            try {
                fileToRead.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        String invertedFilePath;
        if (filePath.endsWith(".txt")) {
            invertedFilePath = filePath.substring(0, filePath.length() - 4) + "Inverted.txt";
        } else {
            invertedFilePath = filePath + "Inverted.txt";
        }

        File fileToSave = new File(invertedFilePath);

        StringBuilder content = new StringBuilder();

        try {
            FileWriter fw = new FileWriter(fileToSave);
            Scanner scanner = new Scanner(fileToRead);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().stripTrailing();
                content.append(line).append("\n");
            }

            content.reverse();

            if (!content.isEmpty() && content.charAt(0) == '\n') {
                content.deleteCharAt(0);
            }

            fw.write(content.toString());
            fw.close();

            return true;

        } catch (IOException exception) {
            System.err.println("Error");
            exception.printStackTrace();
        }

        return false;

    }

    private void createDirectory(String filePath) {
        int index = filePath.lastIndexOf("\\");
        if (index > 0) {
            String directoryPath = filePath.substring(0, index);
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdir();
            }
        }
    }

}
