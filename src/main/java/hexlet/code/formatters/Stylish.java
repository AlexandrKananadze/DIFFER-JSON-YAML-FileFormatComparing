package hexlet.code.formatters;

import hexlet.code.Formatter;

import java.util.HashMap;
import java.util.Map;

public class Stylish {

    public static String collectFinalDiffStylysh(Map<String, Object> firstMap,
                                                 Map<String, Object> secondMap, Map<String, String> keyMap) {

        Map<String, Object> diffFinal = new HashMap<>();

        for (Map.Entry<String, String> entry : keyMap.entrySet()) {
            switch (entry.getValue()) {
                case "added":
                    diffFinal.put("  + " + entry.getKey() + ": ", secondMap.get(entry.getKey()) + "\n");
                    break;
                case "changed":
                    diffFinal.put("  - " + entry.getKey() + ": ", firstMap.get(entry.getKey()) + "\n");
                    diffFinal.put("  + " + entry.getKey() + ": ", secondMap.get(entry.getKey()) + "\n");
                    break;
                case "equals":
                    diffFinal.put("    " + entry.getKey() + ": ", secondMap.get(entry.getKey()) + "\n");
                    break;
                case "removed":
                    diffFinal.put("  - " + entry.getKey() + ": ", firstMap.get(entry.getKey()) + "\n");
                    break;
                default:
                    break;
            }
        }
        return Formatter.mapToString(Formatter.comparator(diffFinal));
    }


}

