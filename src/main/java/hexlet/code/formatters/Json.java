package hexlet.code.formatters;

import hexlet.code.Formatter;
import java.util.HashMap;
import java.util.Map;

public class Json {
    public static String jsonGen(Map<String, Object> firstMap, Map<String, Object> secondMap,
                                 Map<String, String> keyMap) {

        Map<String, Object> diffFinal = new HashMap<>();
        for (Map.Entry<String, String> entry : keyMap.entrySet()) {
            switch (entry.getValue()) {
                case "added":
                    diffFinal.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": \"\"," + "\n"
                            + "   \"now\": " + "\"" + secondMap.get(entry.getKey()) + "\"" + "\n"
                            + "},\n");
                    break;
                case "changed":
                    diffFinal.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": " + "\"" + firstMap.get(entry.getKey()) + "\"," + "\n"
                            + "   \"now\": " + "\"" + secondMap.get(entry.getKey()) + "\"" + "\n"
                            + "},\n");
                    break;
                case "equals":
                    diffFinal.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": " + "\"" + secondMap.get(entry.getKey()) + "\"," + "\n"
                            + "   \"now\": " + "\"" + secondMap.get(entry.getKey()) + "\"" + "\n"
                            + "},\n");
                    break;
                case "removed":
                    diffFinal.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": " + "\"" + firstMap.get(entry.getKey()) + "\"," + "\n"
                            + "   \"now\": \"\" " + "\n"
                            + "},\n");
                    break;
                default:
                    break;
            }
        }
        return Formatter.mapToString(Formatter.comparator(diffFinal));
    }
}

