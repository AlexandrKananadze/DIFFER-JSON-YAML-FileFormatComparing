
package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Formatter {

    public static String formatter(String format, TreeMap<String, Diff> diffMap) {
        switch (format) {
            case "stylish":
                return Stylish.collectFinalDiffStylish(diffMap);
            case "json":
                return Json.jsonGen(diffMap);
            case "plain":
                return Plain.plainGen(diffMap);
            default:
                return "Incorrect format name";
        }
    }

    public static String mapToString(Map<String, Object> map) {
       return map.entrySet().stream().map(entry -> (entry.getKey() + entry.getValue())).collect(Collectors.joining("\n"));
    }
}
