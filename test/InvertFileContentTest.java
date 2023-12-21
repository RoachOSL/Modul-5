import dev.Roach.InvertFileContent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InvertFileContentTest {

    InvertFileContent testObject = new InvertFileContent();
    File testFile = new File("testFile.txt");
    File outputTestFile = new File("testFileInverted.txt");

    @BeforeEach
    private void prepareTestFile() {
        try (FileWriter fw = new FileWriter(testFile)) {
            fw.write("Ala ma kota.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void cleanUp() {
        testFile.delete();
        outputTestFile.delete();
    }

    @Test
    public void testIfOutputFileIsCreatedReturnTrue() {
        testObject.invertFile(testFile.getAbsolutePath());
        Assertions.assertTrue(outputTestFile.exists());
    }

    @Test
    public void InvertFileContentTestForCorrectOutput() {

        Assertions.assertTrue(testObject.invertFile(testFile.getAbsolutePath()));

        try (Scanner scannerForFirstFile = new Scanner(testFile); Scanner scannerForSecondFile = new Scanner(outputTestFile)) {

            while (scannerForFirstFile.hasNextLine() && scannerForSecondFile.hasNextLine()) {

                String reversedFirstLine = new StringBuilder(scannerForFirstFile.nextLine()).reverse().toString();
                String lineFirstForSecondFile = scannerForSecondFile.nextLine();

                Assertions.assertEquals(reversedFirstLine, lineFirstForSecondFile);
            }
            Assertions.assertFalse((scannerForFirstFile.hasNextLine()) || scannerForSecondFile.hasNextLine());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
