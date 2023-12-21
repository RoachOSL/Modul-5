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

        if (CreateDirectoryUtil.createDirectory(filePath1)) {
            System.out.println("Folder successfully created");
        }

        File firstFile = new File(filePath1);
        File secondFile = new File(filePath2);

        try {
            if (firstFile.createNewFile()) {
                System.out.println("First file successfully created");
            } else {
                System.out.println("First file already created");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            if (secondFile.createNewFile()) {
                System.out.println("Second file successfully created");
            } else {
                System.out.println("Second file already created");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        //If files are empty or doesn't exist --> they are not equal

        if (!firstFile.exists() || !secondFile.exists() || firstFile.length() == 0 || secondFile.length() == 0) {
            System.out.println("They are not equal");
            return false;
        }

        try (Scanner scannerForFirstFile = new Scanner(firstFile);
             Scanner scannerForSecondFile = new Scanner(secondFile)) {

            while (scannerForFirstFile.hasNextLine() || scannerForSecondFile.hasNextLine()) {
                if (scannerForFirstFile.hasNextLine() && scannerForSecondFile.hasNextLine()) {
                    if (!scannerForFirstFile.nextLine().equals(scannerForSecondFile.nextLine())) {
                        System.out.println("They are not equal");
                        return false;
                    }
                } else {
                    System.out.println("They are not equal");
                    return false;
                }
            }

        } catch (IOException exception) {
            System.err.println("Error occurred");
            exception.printStackTrace();
        }

        System.out.println("They are equal");
        return true;
    }

}
