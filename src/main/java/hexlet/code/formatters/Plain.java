package hexlet.code.formatters;

import hexlet.code.Diff;
import hexlet.code.Formatter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Plain {

    public static String checkForObjectValues(Object obj) {
        if (obj instanceof Arrays || obj instanceof List || obj instanceof Map) {
            return "[complex value]";
        }
        if (obj instanceof String) {
            return "\'" + obj + "\'";
        }
        return obj + "";
    }

    public static String plainGen(TreeMap<String, Diff> diff) {

        LinkedHashMap<String, Object> plain = new LinkedHashMap<>();

        for (Map.Entry<String, Diff> entry : diff.entrySet()) {
            switch (entry.getValue().getStatus()) {
                case "added":
                    plain.put("Property '"
                            + entry.getKey(), "' was added with value: "
                            + checkForObjectValues(entry.getValue().getValue2()) + "\n");
                    break;
                case "changed":
                    plain.put("Property '"
                            + entry.getKey(), "' was updated. From "
                            + checkForObjectValues(entry.getValue().getValue1()) + " to "
                            + checkForObjectValues(entry.getValue().getValue2()) + "\n");
                    break;

                case "removed":
                    plain.put("Property '" + entry.getKey(), "' was removed" + "\n");
                    break;
                default:
                    break;
            }
        }
        return "\"" + Formatter.mapToString(plain) + "\"";
    }


}

