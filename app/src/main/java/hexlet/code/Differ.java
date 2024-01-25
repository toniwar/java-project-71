package hexlet.code;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2) throws Exception {

        var map1 = Mapper.getMapFromJSON(path1);
        var map2 = Mapper.getMapFromJSON(path2);
        var resultMap = new TreeMap<String, DiffHolder>();
        fillResultMap(resultMap, map1, 0);
        fillResultMap(resultMap, map2, 1);
        var list = new ArrayList<String>();
        for (var diffHolder : resultMap.values()) {
            diffHolder.generateDifference();
            list.add(diffHolder.getDifference());
        }
        var result = new StringBuilder("{\n");
        for (var item : list) {
            result.append(item);
        }
        result.append("}");
        return result.toString();
    }

    private static void fillResultMap(
            Map<String, DiffHolder> resultMap,
            Map<String, Object> source, int index
    ) {

        if (index > 1 || index < 0) {
            return;
        }
        for (var entry : source.entrySet()) {
            if (resultMap.containsKey(entry.getKey())) {
                resultMap.get(entry.getKey()).setValue(entry.getValue(), index);
            } else {
                var diffHolder = new DiffHolder(entry.getKey());
                diffHolder.setValue(entry.getValue(), index);
                resultMap.put(entry.getKey(), diffHolder);
            }
        }
    }
}
