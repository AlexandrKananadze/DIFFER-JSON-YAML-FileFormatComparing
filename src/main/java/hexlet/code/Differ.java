package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Differ {
    private static final Map<String, String> KEYS_MAP = new HashMap<>();

    public static String fileParsePath(String path) throws IOException {
        Path resPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(resPath);
    }
//comparator for maps values objects
    public static boolean comparator(Object map1, Object map2) {
        if (map1 == null || map2 == null) {
            return false;
        }
        return map1.equals(map2);
    }

// default format stylish
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
//choosable format plain, stylish, json
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        String firstFileToString = fileParsePath(filepath1);
        String secondFileToString = fileParsePath(filepath2);
        Map<String, Object> firstMap = Parser.parseToMap(firstFileToString, filepath1);
        Map<String, Object> secondMap = Parser.parseToMap(secondFileToString, filepath2);
        // keymap fullfilment
        for (Map.Entry<String, Object> first : firstMap.entrySet()) {
            if (!secondMap.containsKey(first.getKey())) {
                //removed firstmap key
                KEYS_MAP.put(first.getKey(), "removed");
            }
        }
        for (Map.Entry<String, Object> first : firstMap.entrySet()) {
            for (Map.Entry<String, Object> second : secondMap.entrySet()) {
                if (first.getKey().equals(second.getKey()) && comparator(first.getValue(), second.getValue())) {
                    // key equals and value equals // no diff
                    KEYS_MAP.put(first.getKey(), "equals");
                }
                if (first.getKey().equals(second.getKey()) && !comparator(first.getValue(), second.getValue())) {
                    // keys equals, values no equals // changed
                    KEYS_MAP.put(first.getKey(), "changed");
                }
            }
        }
        for (Map.Entry<String, Object> second : secondMap.entrySet()) {
            if (!firstMap.containsKey(second.getKey())) {
                // added
                KEYS_MAP.put(second.getKey(), "added");
            }
        }
        return Formatter.formatter(format, firstMap, secondMap, KEYS_MAP);
    }

 // public static void main(String[] args) throws IOException {
 //    String firstJson = "src/test/resources/file1.yaml";
 //    String secondJson = "src/test/resources/file2.yaml";
 //    String format = "json";
 //    System.out.println(Differ.generate(firstJson, secondJson, format));

 // }

}


