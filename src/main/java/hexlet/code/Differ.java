package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;


public final class Differ {


    public static String readFile(String path) throws IOException {
        Path resPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(resPath);
    }

    public static HashSet<String> keySet(Map<String, Object> first, Map<String, Object> second) {
        HashSet<String> keySet = new HashSet<>(first.keySet());
        keySet.addAll(second.keySet());
        return keySet;
    }

    public static boolean checkObjectEquals(Object first, Object second) {
        return Objects.deepEquals(first, second);
    }

    public static TreeMap<String, Diff> makeDiffer(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        TreeMap<String, Diff> diff = new TreeMap<>();
        for (String key : keySet(firstMap, secondMap)) {
            String status = "";
            if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                status = "removed";
            }
            if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                status = "added";
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && checkObjectEquals(firstMap.get(key), (secondMap.get(key)))) {
                status = "equals";
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && !checkObjectEquals(firstMap.get(key), (secondMap.get(key)))) {
                status = "changed";
            }
            Diff record = new Diff(status, firstMap.get(key), secondMap.get(key));
            diff.put(key, record);
        }
        return diff;
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        String firstFileToString = readFile(filepath1);
        String secondFileToString = readFile(filepath2);
        Map<String, Object> firstMap = Parser.parseToMap(Parser.objectMapper(filepath1), firstFileToString);
        Map<String, Object> secondMap = Parser.parseToMap(Parser.objectMapper(filepath2), secondFileToString);
        TreeMap<String, Diff> diff = makeDiffer(firstMap, secondMap);
        return Formatter.formatter(format, diff);
    }
}


