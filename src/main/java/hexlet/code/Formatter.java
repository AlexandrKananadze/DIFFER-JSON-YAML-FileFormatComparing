
package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Formatter {

    public static String formatter(String format, Map<String, Object> firstMap,
                                   Map<String, Object> secondMap, Map<String, String> keys)  {
        switch (format) {
            case "stylish":
                return Stylish.collectFinalDiffStylysh(firstMap, secondMap, keys);
            case "json":
                return Json.jsonGen(firstMap, secondMap, keys);
            case "plain":
                return Plain.plainGen(firstMap, secondMap, keys);
        }
        return "Incorrect format name";
    }
    // sort final diff map
    public static Map<String, Object> comparator(Map<String, Object> result) {


        return result.entrySet()
                .stream()
                .sorted((x1, x2) -> {
                    String withoutPrefix1 = x1.getKey().substring(4);
                    String withoutPrefix2 = x2.getKey().substring(4);
                    return CharSequence.compare(withoutPrefix1, withoutPrefix2);
                })
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));
    }

    public static String mapToString(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        return stringBuilder.append("}") + "";
    }

}
