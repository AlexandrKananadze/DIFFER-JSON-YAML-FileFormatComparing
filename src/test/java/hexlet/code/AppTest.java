package hexlet.code;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {
    private final Path pathStylish = Paths.get("src/test/resources/TestResult/TestStylish").normalize();
    private final String expectedStylish = Files.readString(pathStylish);

    private final Path pathRecursive = Paths.get("src/test/resources/TestResult/TestRecus").normalize();
    private final String expRecursive = Files.readString(pathRecursive);
    private final Path pathPlain = Paths.get("src/test/resources/TestResult/TestPlain").normalize();
    private final String expPlain = Files.readString(pathPlain);
    private final Path pathJson = Paths.get("src/test/resources/TestResult/TestJson").normalize();
    private final String expJson = Files.readString(pathJson);

    public AppTest() throws IOException {
    }

    @Test
    public void diffJson() throws Exception {
        String firstJson = "src/test/resources/file1.json";
        String secondJson = "src/test/resources/file2.json";
        Assertions.assertEquals(expectedStylish, Differ.generate(firstJson, secondJson));
    }

    @Test
    public void difYaml() throws Exception {
        String firstYaml = "src/test/resources/file1.yaml";
        String secondYaml = "src/test/resources/file2.yaml";
        Assertions.assertEquals(expectedStylish, Differ.generate(firstYaml, secondYaml));
    }

    @Test // +- changed
    public void difRecursiveJson() throws Exception {
        String firstJson = "src/test/resources/Recursive1.json";
        String secondJson = "src/test/resources/Recursive2.json";

        Assertions.assertEquals(expRecursive, Differ.generate(firstJson, secondJson));
    }

    @Test
    public void difRecursiveYaml() throws Exception {
        String firstYaml = "src/test/resources/Recursive1.yaml";
        String secondYaml = "src/test/resources/Recursive2.yaml";
        Assertions.assertEquals(expRecursive, Differ.generate(firstYaml, secondYaml));
    }

    @Test
    public void difRecursiveJsonPlain() throws Exception {
        String firstJson = "src/test/resources/Recursive1.json";
        String secondJson = "src/test/resources/Recursive2.json";
        Assertions.assertEquals(expPlain, Differ.generate(firstJson, secondJson, "plain"));
    }

    @Test
    void difRecursiveJsonJson() throws Exception {
        String firstJson = "src/test/resources/file1.json";
        String secondJson = "src/test/resources/file2.json";
        Assertions.assertEquals(expJson, Differ.generate(firstJson, secondJson, "json"));
    }

}
