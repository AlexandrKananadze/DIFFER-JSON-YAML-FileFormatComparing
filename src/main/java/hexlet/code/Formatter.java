
package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;
import java.util.TreeMap;

public class Formatter {

    public static String formatter(String format, TreeMap<String, Diff> diffMap )  {
        switch (format) {
            case "stylish":
                return Stylish.collectFinalDiffStylish(diffMap);
           case "json":
               return Json.jsonGen(diffMap);
           case "plain":
               return Plain.plainGen(diffMap);
        }
        return "Incorrect format name";
    }
    // sort final diff map
   // public static Map<String, Object> comparator(Map<String, Object> result) {
//
   //     Map<String, Object> res =   result.entrySet()
   //             .stream()
   //             .sorted((x1, x2) -> {
   //                 String withoutPrefix1 = x1.getKey().substring(4);
   //                 String withoutPrefix2 = x2.getKey().substring(4);
//
   //                 return CharSequence.compare(withoutPrefix1, withoutPrefix2);
   //             })
   //             .collect(Collectors.toMap(Map.Entry::getKey,
   //                     Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));
   //     for (Map.Entry<String, Object> entry: res.entrySet()) {
   //         for (Map.Entry<String, Object> entry1: res.entrySet()) {
   //         if (entry.getKey().substring(4).equals(entry1.getKey().substring(4))) {
//
   //         }
   //     }
//
   //     return
   // }

    public static String mapToString(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue());
        }
        return stringBuilder.append("}") + "";
    }

}
