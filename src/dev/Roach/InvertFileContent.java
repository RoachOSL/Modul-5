package dev.Roach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InvertFileContent {

    public boolean invertFile(String filePath) {

        CreateDirectoryUtil.createDirectory(filePath);

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

        try (Scanner scanner = new Scanner(fileToRead);
             FileWriter fw = new FileWriter(fileToSave)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().stripTrailing();
                content.append(line).append("\n");
            }

            if (content.toString().trim().isEmpty()) {
                System.err.println("File is empty. No content to invert.");
                return false;
            }

            content.reverse();

            if (!content.isEmpty() && content.charAt(0) == '\n') {
                content.deleteCharAt(0);
            }

            fw.write(content.toString());

            return true;

        } catch (IOException exception) {
            System.err.println("Error");
            exception.printStackTrace();
            return false;
        }
    }


}
