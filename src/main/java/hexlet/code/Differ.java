package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;


public final class Differ {

    public static String fileParsePath(String path) throws IOException {
        Path resPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(resPath);
    }

    public static HashSet<String> keySet(Map<String, Object> first, Map<String, Object> second) {
        HashSet<String> keySet = new HashSet<>(first.keySet());
        keySet.addAll(second.keySet());
        return keySet;
    }

    public static boolean checkNull(Object first, Object second) {
        if (first == null || second == null) {
            return first == second;
        }
        return first.equals(second);
    }

    public static TreeMap<String, Diff> differ(HashSet<String> keySet, Map<String,
            Object> firstMap, Map<String, Object> secondMap) {
        TreeMap<String, Diff> diff = new TreeMap<>();
        for (String key : keySet) {
            if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                Diff differ = new Diff("removed", firstMap.get(key), secondMap.get(key));
                diff.put(key, differ);
            }
            if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                Diff differ = new Diff("added", firstMap.get(key), secondMap.get(key));
                diff.put(key, differ);
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && checkNull(firstMap.get(key), (secondMap.get(key)))) {
                Diff differ = new Diff("equals", firstMap.get(key), secondMap.get(key));
                diff.put(key, differ);
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key)
                    && !checkNull(firstMap.get(key), (secondMap.get(key)))) {
                Diff differ = new Diff("changed", firstMap.get(key), secondMap.get(key));
                diff.put(key, differ);
            }
        }
        return diff;
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        String firstFileToString = fileParsePath(filepath1);
        String secondFileToString = fileParsePath(filepath2);
        Map<String, Object> firstMap = Parser.parseToMap(Parser.objectMapper(filepath1), firstFileToString);
        Map<String, Object> secondMap = Parser.parseToMap(Parser.objectMapper(filepath2), secondFileToString);
        HashSet<String> keystore = keySet(firstMap, secondMap);
        TreeMap<String, Diff> diff = differ(keystore, firstMap, secondMap);

        return Formatter.formatter(format, diff);
    }
}


