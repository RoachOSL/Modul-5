package dev.Roach;

import java.io.File;

public class CreateDirectoryUtil {
    public static boolean createDirectory(String filePath) {

        if (filePath.startsWith("\\")) {
            filePath = filePath.substring(1);
        }

        int index = filePath.lastIndexOf("\\");

        String directoryPath = index > 0 ? filePath.substring(0, index) : filePath;
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean created = directory.mkdir();
            if (created) {
                System.out.println("Folder created: " + directory.getAbsolutePath());
                return true;
            } else {
                System.out.println("Failed to create folder: " + directory.getAbsolutePath());
                return false;
            }
        }
        return true;
    }
}
