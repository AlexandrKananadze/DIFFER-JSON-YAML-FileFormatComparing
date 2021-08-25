
package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;
import java.util.TreeMap;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
