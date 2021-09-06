package hexlet.code.formatters;

import hexlet.code.Diff;
import hexlet.code.Formatter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Json {


    public static Object checkForObjectValues(Object obj) {
        if (obj instanceof Arrays || obj instanceof List || obj instanceof Map || obj instanceof String) {
            return "\"" + obj + "\"";
        }
        return obj;
    }

    public static String jsonGen(TreeMap<String, Diff> diff) {
        String beginKey = "    {\"field\":\"";
        String status = "\"status\":\"";
        String oldValue = "\"oldValue\":";
        String newValue = "\"newValue\":";
        String end = "},";


        LinkedHashMap<String, Object> json = new LinkedHashMap<>();
        for (Map.Entry<String, Diff> entry : diff.entrySet()) {
            switch (entry.getValue().getStatus()) {
                case "added":
                    json.put(beginKey + entry.getKey() + "\",",
                            status + "added\"," + newValue
                                    + entry.getValue().getValue2() + end);
                    break;
                case "changed":
                    json.put(beginKey + entry.getKey() + "\",",
                            status + "changed\"," + oldValue + checkForObjectValues(entry.getValue().getValue1()) + ","
                                    + newValue + checkForObjectValues(entry.getValue().getValue2()) + end);
                    break;
                case "equals":
                    json.put(beginKey + checkForObjectValues(entry.getValue().getValue1()) + "\"", status
                            + "unchanged" + ","
                            + oldValue + checkForObjectValues(entry.getValue().getValue2())
                            + newValue + checkForObjectValues(entry.getValue().getValue2()) + end);


                    break;
                case "removed":
                    json.put(beginKey + entry.getKey() + "\",", status + "deleted\","
                            + oldValue + checkForObjectValues(entry.getValue().getValue1())
                            + end);

                    break;
                default:
                    throw new Error("Unknown Error in Json format");
            }
        }
        return "\n  \"diffs\": [\n" + Formatter.mapToString(json) + "\n  ]";
    }
}
