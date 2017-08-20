package util.ioutil;

import org.junit.Assert;
import org.junit.Test;
import util.ioutil.IOUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class IOUtilTest {

    String testFilesPath = "src/main/resources/test-files/";

    public IOUtilTest() {
        File testDirectory = new File(testFilesPath);
        testDirectory.mkdir();
    }

    @Test
    public void readTxtFileTest() throws IOException {
        String pathToFile = testFilesPath + "testTextFile.txt";
        String expectedResult = "The first file.\nThe second line.";
        try{
            PrintWriter writer = new PrintWriter(pathToFile, "UTF-8");
            writer.print(expectedResult);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileContents = IOUtil.readFileToString(pathToFile);
        Assert.assertEquals(expectedResult, fileContents);
    }
}
