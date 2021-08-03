package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@CommandLine.Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference",
        mixinStandardHelpOptions = true)

public class App implements Runnable {
    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;

    // Option(names = {"-v", "--verbose"}, description = "version")
    // boolean verbose;


    public static void main(String[] args) throws IOException {

        CommandLine.run(new App());
          String filepath1 = "src/main/resources/file1.json";
          String filepath2 = "src/main/resources/file2.json";
        Differ.generate(filepath1, filepath2);
    }
    @Override
    public void run() {

    }
    public void call() {

    }

    public String getGreeting() {
        return "Hello";
    }





}
