package dev.Roach;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SameContentChecker {

    public boolean areTextFilesEqual(String filePath1, String filePath2) {

        if (!filePath1.endsWith(".txt")) {
            filePath1 += ".txt";
        }
        if (!filePath2.endsWith(".txt")) {
            filePath2 += ".txt";
        }

        createDirectory(filePath1);
        createDirectory(filePath2);

        File firstFile = new File(filePath1);
        File secondFile = new File(filePath2);

        try {

            if (!firstFile.exists()) {
                firstFile.createNewFile();
            }
            if (!secondFile.exists()) {
                secondFile.createNewFile();
            }

            Scanner scannerForFirstFile = new Scanner(firstFile);
            Scanner scannerForSecondFile = new Scanner(secondFile);

            while (scannerForFirstFile.hasNextLine() || scannerForSecondFile.hasNextLine()) {
                if (scannerForFirstFile.hasNextLine() && scannerForSecondFile.hasNextLine()) {
                    if (!scannerForFirstFile.nextLine().equals(scannerForSecondFile.nextLine())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

        } catch (IOException exception) {
            System.err.println("Error occurred");
            exception.printStackTrace();
        }

        return true;
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
