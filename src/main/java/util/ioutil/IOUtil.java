package util.ioutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOUtil {

    public static String readFileToString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
