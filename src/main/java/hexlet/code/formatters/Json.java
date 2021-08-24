package hexlet.code.formatters;

import hexlet.code.Diff;
import hexlet.code.Formatter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Json {
    public static String jsonGen(TreeMap<String, Diff> diff) {

        LinkedHashMap<String, Object> json = new LinkedHashMap<>();
        for (Map.Entry<String, Diff> entry : diff.entrySet()) {
            switch (entry.getValue().getStatus()) {
                case "added":
                    json.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": \"\"," + "\n"
                            + "   \"now\": " + "\"" + entry.getValue().getValue2() + "\"" + "\n"
                            + "},\n");
                    break;
                case "changed":
                    json.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": " + "\"" + entry.getValue().getValue1() + "\"," + "\n"
                            + "   \"now\": " + "\"" + entry.getValue().getValue2() + "\"" + "\n"
                            + "},\n");
                    break;
                case "equals":
                    json.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": " + "\"" + entry.getValue().getValue1() + "\"," + "\n"
                            + "   \"now\": " + "\"" + entry.getValue().getValue1() + "\"" + "\n"
                            + "},\n");
                    break;
                case "removed":
                    json.put("{\n" + " \"field\":" + " \"" + entry.getKey() + "\",", "\n"
                            + "   \"was\": " + "\"" + entry.getValue().getValue1() + "\"," + "\n"
                            + "   \"now\": \"\" " + "\n"
                            + "},\n");
                    break;
                default:
                    break;
            }
        }
        return Formatter.mapToString(json);
    }
}

