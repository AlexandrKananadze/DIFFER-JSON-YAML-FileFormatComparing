package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Maping {

    public static Map<String, Object> reader(String filepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filepath), new TypeReference<>() {
});
    }

    public static void main(String[] args) throws IOException {
        String filepath1 = "src/main/resources/file1.json";
        String filepath2 = "src/main/resources/file2.json";
        Map<String, Object> firstFile = new HashMap<>(reader(filepath1));
        Map<String, Object> secondFile = new HashMap<>(reader(filepath2));
        System.out.println(firstFile);
        System.out.println(secondFile);

        Map<String, Object> result = new HashMap<>();


        for (Map.Entry<String, Object> first : firstFile.entrySet()) {
            if (!secondFile.containsKey(first.getKey())) {
               result.put("-" + first.getKey(), ": " + first.getValue());
            }
        }
        for (Map.Entry<String, Object> first : firstFile.entrySet()) {
            for (Map.Entry<String, Object> second : secondFile.entrySet()) {
                if (first.getKey().equals(second.getKey()) && first.getValue().equals(second.getValue())) {
                   result.put(" " + first.getKey(), ":" + first.getValue());
                }
                if (first.getKey().equals(second.getKey()) && !first.getValue().equals(second.getValue())) {
                    result.put("-" + first.getKey(), ": " + first.getValue());
                    result.put("+" + second.getKey(), ": " + second.getValue());
                }

            }
        }
        for (Map.Entry<String, Object> second : secondFile.entrySet()) {
            if (!firstFile.containsKey(second.getKey())) {
                result.put("+" + second.getKey(), ": " + second.getValue());
            }
        }
    //   // final map unsorted
    //   System.out.println();
    //   for (Map.Entry<String, Object> res : result.entrySet()) {
    //       System.out.println(res);
    //   }

        System.out.println();
        // sorting sout alphabet
        result.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }
}

