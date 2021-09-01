package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parseToMap(ObjectMapper objectMapper, String fileToString)
                                                throws JsonProcessingException {
        return objectMapper.readValue(fileToString, Map.class);
    }

    public static ObjectMapper objectMapper(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
            return objectMapper;
        }
        return objectMapper;
    }
}
