package hexlet.code.formatters;

import hexlet.code.Diff;
import hexlet.code.Formatter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Stylish {

    public static String collectFinalDiffStylish(TreeMap<String, Diff> diff) {
        LinkedHashMap<String, Object> stylish = new LinkedHashMap<>();
        for (Map.Entry<String, Diff> entry : diff.entrySet()) {
            switch (entry.getValue().getStatus()) {
                case "added":
                    stylish.put("  + " + entry.getKey() + ": ", entry.getValue().getValue2());
                    break;
                case "changed":
                    stylish.put("  - " + entry.getKey() + ": ", entry.getValue().getValue1());
                    stylish.put("  + " + entry.getKey() + ": ", entry.getValue().getValue2());
                    break;
                case "equals":
                    stylish.put("    " + entry.getKey() + ": ", entry.getValue().getValue1());
                    break;
                case "removed":
                    stylish.put("  - " + entry.getKey() + ": ", entry.getValue().getValue1());
                    break;
                default:
                    break;
            }
        }
        return "{\n" + Formatter.mapToString(stylish) + "\n}";
    }
}




