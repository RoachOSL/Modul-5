package dev.Roach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserNamedFile {

    public boolean writeUserInputToFile() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide name for your file: ");
        String name = scanner.nextLine();

        if (!name.toLowerCase().endsWith(".txt")) {
            name += ".txt";
        }

        System.out.println("Provide text for your file: ");
        String text = scanner.nextLine();

        String directoryName = "ExampleFiles";
        File directory = new File((directoryName));

        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = new File(directory, name);

        try {
            FileWriter fw = new FileWriter(file);
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
            fw.close();
            System.out.println("Successfully wrote you text to the file.");
            return true;

        } catch (IOException exception) {
            System.err.println("Error occurred");
            exception.printStackTrace();
        }
        return false;
    }

    public void readFromFile(String fileName) {

        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String fileData = fileReader.nextLine();
                System.out.println(fileData);
            }
            fileReader.close();

        } catch (IOException exception) {
            System.err.println("Error occurred");
            exception.printStackTrace();
        }

    }
}
