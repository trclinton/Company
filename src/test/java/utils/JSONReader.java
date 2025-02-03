package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class JSONReader {

    public Map<String, String> JSONDataReader(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = Paths.get(filePath).toFile();
        Map<String, String> jsonMap = objectMapper.readValue(file, Map.class);
        return jsonMap;
    }
}
