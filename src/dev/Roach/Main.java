package dev.Roach;

public class Main {

    public static void main(String[] args) {

        ListFilesInFolder listFilesInFolder = new ListFilesInFolder();

        listFilesInFolder.createFolder();
        System.out.println("-".repeat(50));
        listFilesInFolder.createFiles();
        System.out.println("-".repeat(50));
        listFilesInFolder.fillTheFiles();
        System.out.println("-".repeat(50));
        listFilesInFolder.printDirectory("E:\\ProjektyIntelliJ\\Modul-5\\ExampleFiles\\");
        System.out.println("-".repeat(50));
//        listFilesInFolder.deleteFilesInFolder();
//        System.out.println("-".repeat(50));
//        listFilesInFolder.deleteWholeFolder();

    }
}
