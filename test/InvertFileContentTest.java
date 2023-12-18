import dev.Roach.InvertFileContent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InvertFileContentTest {

    InvertFileContent testObject = new InvertFileContent();
    File testFile = new File("testFile.txt");
    File outputTestFile = new File("testFileInverted.txt");

    @AfterEach
    public void cleanUp() {
        boolean isTestFileDeleted = testFile.delete();
        boolean isOutputFileDeleted = outputTestFile.delete();

        System.out.println("Test file deleted: " + isTestFileDeleted);
        System.out.println("Output file deleted: " + isOutputFileDeleted);
    }

    @Test
    public void testIfOutputFileIsCreatedReturnTrue() {

        prepareTestFile();

        testObject.invertFile(testFile.getAbsolutePath());
        Assertions.assertTrue(outputTestFile.exists());
    }

    @Test
    public void InvertFileContentTestForCorrectOutput() {

        prepareTestFile();

        Assertions.assertTrue(testObject.invertFile(testFile.getAbsolutePath()));

        try (Scanner scannerForFirstFile = new Scanner(testFile); Scanner scannerForSecondFile = new Scanner(outputTestFile)) {

            while (scannerForFirstFile.hasNextLine() && scannerForSecondFile.hasNextLine()) {
                String lineFirstForFirstFile = scannerForFirstFile.nextLine();
                String lineFirstForSecondFile = scannerForSecondFile.nextLine();

                Assertions.assertEquals(new StringBuilder(lineFirstForFirstFile).reverse().toString(), lineFirstForSecondFile);
            }
            Assertions.assertFalse((scannerForFirstFile.hasNextLine()) || scannerForSecondFile.hasNextLine());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void prepareTestFile() {
        try (FileWriter fw = new FileWriter(testFile)) {
            fw.write("Ala ma kota.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
