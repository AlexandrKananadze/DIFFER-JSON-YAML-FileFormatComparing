package hexlet.code.formatters;

import hexlet.code.Formatter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String checkForObjectValues(Object obj) {
        if (obj instanceof Arrays || obj instanceof List || obj instanceof Map) {
            return "[complex value]";
        }
        return obj + "";
    }

    public static String plainGen(Map<String, Object> firstMap, Map<String, Object> secondMap,
                                  Map<String, String> keyMap) {

        Map<String, Object> diffFinal = new HashMap<>();

        for (Map.Entry<String, String> entry : keyMap.entrySet()) {
            switch (entry.getValue()) {
                case "added":
                    diffFinal.put("Property '"
                            + entry.getKey(), "' was added with value: "
                            + checkForObjectValues(secondMap.get(entry.getKey())) + "\n");
                    break;
                case "changed":
                    diffFinal.put("Property '"
                            + entry.getKey(), "' was updated. From "
                            + checkForObjectValues(firstMap.get(entry.getKey())) + " to "
                            + checkForObjectValues(secondMap.get(entry.getKey())) + "\n");
                    break;

                case "removed":
                    diffFinal.put("Property '" + entry.getKey(), "' was removed\n");
                    break;
                default:
                    break;
            }
        }
        return Formatter.mapToString(Formatter.comparator(diffFinal));
    }



}

