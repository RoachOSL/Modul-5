package dev.Roach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InvertFileContent {

    public boolean invertFile(String filePath) {


        File fileToRead = new File(filePath);
        File fileToSave = new File(filePath + "Inverted.txt");

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

}
