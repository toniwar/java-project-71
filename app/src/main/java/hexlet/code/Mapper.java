package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;
public class Mapper {

    public static Map<String, Object> getMapFromJSON(String filePath) throws Exception {
        var file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<Map<String, Object>>() { });
    }

}
